package it.framework.client.service.impl;

import it.framework.client.service.inferf.IExecutionContext;

public class ExternalServiceException extends ServiceException {

	private static final long serialVersionUID = -6238646246771805374L;
	private String source;

	public ExternalServiceException(String applicationId, String errorType, String errorCode, String errorMessage,
			IExecutionContext context,
			boolean toNotify, Exception e, String source) {
		super(applicationId, errorType, errorCode, errorMessage, context, toNotify, e);
		this.source = source;
	}

	public String getSource() {
		return source;
	}

}
