package it.framework.core.error.impl;

import java.util.Map;

import it.framework.client.service.impl.OperationException;
import it.framework.core.error.exception.FaultReaderRuntimeException;
import it.framework.core.error.interf.IErrorConfMessage;
import it.framework.core.error.interf.IErrorFormatterService;
import it.framework.core.repository.interf.IErrorRepository;


public class ApplicationErrorService implements IErrorRepository {

	private String applicationId;
	private String errorSource;
	private IErrorFormatterService errorFormatter;

	public ApplicationErrorService(String applicationId, String errorSource,
			IErrorFormatterService errorFormatter) {
		this.applicationId = applicationId;
		this.errorSource = errorSource;
		this.errorFormatter = errorFormatter;
	}

	@Override
	public String getMessage(String errorCode, Map<String, Object> parameters) {
		IErrorConfMessage errorMessage;
		try {
			errorMessage = errorFormatter.formatMessage(applicationId, errorCode, errorSource,
					parameters);
		} catch (OperationException e) {
			throw new FaultReaderRuntimeException(e);
		}
		return errorMessage.getSourceMessage();
	}

}
