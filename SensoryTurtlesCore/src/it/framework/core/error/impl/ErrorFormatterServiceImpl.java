package it.framework.core.error.impl;

import java.util.Map;

import it.framework.client.service.impl.OperationException;
import it.framework.core.error.interf.IErrorConfMessage;
import it.framework.core.error.interf.IErrorFormatterService;
import it.framework.core.error.interf.IErrorRepository;


public class ErrorFormatterServiceImpl implements IErrorFormatterService {

	private IErrorRepository errorConfMessagesRepository;

	public ErrorFormatterServiceImpl(IErrorRepository errorConfMessagesRepository) {
		super();
		this.errorConfMessagesRepository = errorConfMessagesRepository;
	}

	@Override
	public IErrorConfMessage formatMessage(String applicationId, String sourceCode, String errorSource, Map<String, Object> parameters) throws OperationException {
		String message = errorConfMessagesRepository.getMessage(errorSource, parameters);
		return new ErrorConfMessage(applicationId,0,sourceCode,errorSource,sourceCode,message);
	}

}
