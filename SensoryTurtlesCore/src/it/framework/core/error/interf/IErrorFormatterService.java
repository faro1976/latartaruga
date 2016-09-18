package it.framework.core.error.interf;

import java.util.Map;

import it.framework.client.service.impl.OperationException;

public interface IErrorFormatterService {

	public IErrorConfMessage formatMessage(String applicationId, String sourceCode, String errorSource, Map<String, Object> parameters)
			throws OperationException;

}
