package it.framework.core.exposer.impl;

import it.framework.client.service.enums.SeverityLevelEnum;
import it.framework.client.service.impl.ExternalServiceException;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.impl.type.BaseFaultType;
import it.framework.client.service.impl.type.ExecutionContextType;
import it.framework.client.service.inferf.IExecutionContext;
import it.framework.core.util.JaxbUtil;

public class Exposer {

	protected BaseFaultType toBaseFaultType(ServiceException e, String errorSource) {
		BaseFaultType res = new BaseFaultType();
		res.setApplicationId(e.getApplicationId());
		res.setCode(e.getErrorCode());
		res.setSourceCode(e.getErrorCode());
		res.setMessage(e.getMessage());
		res.setSourceMessage(e.getMessage());
		res.setTimestamp(JaxbUtil.now());
		res.setSeverity(SeverityLevelEnum.SEVERE);

		res.setExecutionContext(toExecutionContextType(e.getExecutionContext()));
		res.setErrorType(e.getErrorType());
		res.setErrorSource(errorSource);
		res.setToNotify(e.isToNotify());

		Throwable cause = e.getCause();
		if (cause instanceof ExternalServiceException) {
			ExternalServiceException ese = (ExternalServiceException) cause;
			res.setCause(toBaseFaultType(ese, ese.getSource()));
		}
		return res;
	}

	private ExecutionContextType toExecutionContextType(IExecutionContext executionContext) {
		ExecutionContextType res = new ExecutionContextType();
		res.setClientId(executionContext.getClientId());
		res.setSessionId(executionContext.getSessionId());
		res.setTraceabilityId(executionContext.getTraceabilityId());
		res.setOperationId(executionContext.getOperatonId());
		res.setExecutionId(executionContext.getExecutionId());
		return res;
	}
}
