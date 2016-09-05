package it.framework.core.executor.impl;

import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger
;
import javax.enterprise.event.Event;
import javax.resource.spi.work.ExecutionContext;

import it.framework.client.service.impl.BusinessResponseDefault;
import it.framework.client.service.impl.OperationException;
import it.framework.client.service.impl.RequestContext;
import it.framework.client.service.impl.SerializableRequestContext;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IExecutionContext;
import it.framework.client.service.inferf.IRequestContext;
import it.framework.client.service.inferf.IResponse;
import it.framework.core.error.enums.ErrorCode;
import it.framework.core.error.enums.ErrorType;
import it.framework.core.executor.interf.IExecutionId;
import it.framework.core.executor.interf.IOperation;
import it.framework.core.executor.interf.IOperationExecutor;
import it.framework.core.logging.enums.LevelEnum;
import it.framework.core.logging.impl.LoggerFactory;
import it.framework.core.logging.interf.IExecutionLogContext;
import it.framework.core.logging.interf.ILogger;
import it.framework.core.repository.interf.IErrorRepository;

public class BaseExecutor implements IOperationExecutor {

	private ILogger logger = LoggerFactory.getLogger(BaseExecutor.class);

	// @Inject
	// @Any
	private Event<OperationExecution> operationEvent;

	// dovrebbe funzionare l'injection da un altro jar ma non funziona
	// quindi mi faccio passare quello di cui ho bisogno
	// @Inject
	// @Named("ErrorRepository")
	private IErrorRepository errorRepository;

	private CoreExecutorParameters parameters;
	private IExecutionId executionIdRepository;

	public static class CoreExecutorParameters {
		private String applicationId;

		public CoreExecutorParameters(String applicationId) {
			super();
			this.applicationId = applicationId;
		}
	}

	public BaseExecutor(CoreExecutorParameters parameters, Event<OperationExecution> operationEvent,
			IErrorRepository errorRepository) {
		this(parameters, operationEvent, errorRepository, () -> java.util.UUID.randomUUID().toString());
	}

	public BaseExecutor(CoreExecutorParameters parameters, Event<OperationExecution> operationEvent,
			IErrorRepository errorRepository, IExecutionId executionIdRepository) {
		super();
		this.parameters = parameters;
		this.operationEvent = operationEvent;
		this.errorRepository = errorRepository;
		this.executionIdRepository = executionIdRepository;
	}

	public static IRequestContext buildEmptyRequestContext() {
		return new RequestContext(	"pfDefaultClientId" + System.currentTimeMillis(),
									"pfDefaultSessionID_" + System.currentTimeMillis(),
									"pfDefaultTraceabilityID_" + System.currentTimeMillis(),
									"pfDefaultOperationID_" + System.currentTimeMillis(), 
									new Date());
	}

	@Override
	public <R> IResponse<R> execute(final IOperation<R> operation) throws ServiceException {
		return execute(operation, new BusinessResponseDefault<R>());
	}

	@Override
	public <R, BR extends BusinessResponseDefault<R>> BR execute(final IOperation<R> operation, BR response)
			throws ServiceException {

		ExecutorContext executorContext = new ExecutorContext(operation, executionIdRepository.getExecutionId());

		OperationExecution operationExecution = new OperationExecution(operation, executorContext);
		try {
			LoggerFactory.initContext(executorContext);
			logger.info("start execute operation " + operation.getOperationId());

			operationExecution.setExecuting(true);
			final R res = operation.perform();
			operationExecution.setSuccess(true);
			response.setResult(res);
			response.getResultStatus().addAll(operation.getResultStatus());
			logger.info("end execute operation " + operation.getOperationId());
			return response;
		} catch (Exception e) {
			operationExecution.setSuccess(false);
			ServiceException serviceException = toServiceException(executorContext, e);
			logger.error(
					"error during operation:" + executorContext.getOperatonId() + " " + getLogMessage(serviceException),
					e);
			throw serviceException;
		} finally {
			if (operationEvent != null) {
				// viene eseguito immediatamente se non in transazione,
				// altrimenti posticipato se l'observer è annotato adeguatamente
				// vedi OperationObserver
				// l'observer non è richiamato se la transazione è markata come
				// rolledback
				operationEvent.fire(operationExecution);
	
				if (!operationExecution.isSuccess() && !operationExecution.isLogged()) {
					// se l'operazione è fallita e siamo in transazione (perchè non
					// è stata loggata subito) loggo l'audit subito
					// in questo modo loggo anche transazioni marcate come
					// rolledback che non richiamano l'observer
					OperationObserver.log(operationExecution, false, true);
				}
				operationExecution.setExecuting(false);
			}
		}
	}

	private ServiceException toServiceException(IExecutionContext context, Exception e) {
		// converto tutto in ServiceException in modo da
		// ritornare sempre il contesto e far uscire un payload anche per rest
		String errorType = ErrorType.RUNTIME;
		String errorCode = ErrorCode.RUNTIME;

		Map<String, Object> formatParameters = null;
		if (e instanceof OperationException) {
			OperationException operationException = (OperationException) e;
			errorType = operationException.getErrorType();
			errorCode = operationException.getErrorCode();
			formatParameters = operationException.getFormatParameters();
		}

		String errorMessage;
		try {
			errorMessage = getMessage(errorCode, formatParameters);
		} catch (Exception getMessageException) {
			logger.error("Impossibile recuperare il messaggio d'errore per il codice d'errore:" + errorCode,
					getMessageException);
			errorMessage = "Impossibile recuperare il messaggio d'errore per il codice d'errore:" + errorCode;
			errorType = ErrorType.RUNTIME;
			errorCode = ErrorCode.RUNTIME;
		}
		return new ServiceException(parameters.applicationId, errorType, errorCode, errorMessage, context, true, e);
	}

	private String getMessage(String errorCode, Map<String, Object> formatParameters) {
		return errorRepository.getMessage(errorCode, formatParameters);
	}

	private static class ExecutorContext implements IExecutionLogContext, IExecutionContext {

		private static final long serialVersionUID = 1749717905822967939L;

		private String operationId;
		private String executionId;
		private ILogger logger = LoggerFactory.getLogger(ExecutorContext.class);

		private SerializableRequestContext requestContext;

		// quando viene eseguita un'operazione
		public ExecutorContext(IOperation<?> operation, String executionId) {
			this(operation.getRequest().getContext(), executionId);
			// prevale l'operation id passato dalla richiesta
			IRequestContext context = operation.getRequest().getContext();
			this.operationId = context != null && context.getOperationId() != null
					? context.getOperationId() + "::" + operation.getOperationId() : operation.getOperationId();
		}

		// quando viene creato per un'eccezione lato exposer
		public ExecutorContext(IRequestContext requestContext, String executionId) {
			if (requestContext == null) {
				requestContext = buildEmptyRequestContext();
				logger.log(LevelEnum.WARN, "Il requestContext è vuoto: è stato creato uno di default");
			}
			this.requestContext = new SerializableRequestContext(requestContext);
			this.executionId = executionId;
			this.operationId = requestContext.getOperationId();
		}

		@Override
		public String getClientId() {
			return requestContext.getClientId();
		}

		@Override
		public String getSessionId() {
			return requestContext.getSessionId();
		}

		@Override
		public String getTraceabilityId() {
			return requestContext.getTraceabilityId();
		}

		@Override
		public String getOperatonId() {
			return operationId;
		}

		@Override
		public String getExecutionId() {
			return executionId;
		}

	}

	@Override
	public ServiceException createServiceException(Exception e, IRequestContext request) {
		if (request == null) {
			request = BaseExecutor.buildEmptyRequestContext();
			logger.log(LevelEnum.WARN, "Il request context è vuoto..creato uno di default");
		}
		ExecutorContext executorContext = new ExecutorContext(request, executionIdRepository.getExecutionId());
		ServiceException serviceException = toServiceException(executorContext, e);
		logger.error("creating service exception: " + getLogMessage(serviceException), e);
		return serviceException;
	}

	private String getLogMessage(ServiceException se) {
		return "ServiceException(configuration message:" + se.getMessage() + ", error code:" + se.getErrorCode()
				+ ", error type:" + se.getErrorType() + ")";
	}

}
