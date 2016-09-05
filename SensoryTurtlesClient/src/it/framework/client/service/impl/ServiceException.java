package it.framework.client.service.impl;

import java.util.Map;

import javax.ejb.ApplicationException;

import it.framework.client.service.inferf.IExecutionContext;

@ApplicationException(rollback = true)
public class ServiceException extends OperationException{
	private static final long serialVersionUID = 7447951039876735376L;

	private final String applicationId;
	private final IExecutionContext executionContext;
	private final boolean isToNotify;
	private final String errorType;

	public ServiceException(String applicationId, String errorType, String errorCode, String errorMessage,
			IExecutionContext context,
			boolean toNotify, Exception e) {
		this(applicationId, errorType, errorCode, errorMessage, context, toNotify, e, (Map<String, Object>) null);
	}

	public ServiceException(String applicationId, String errorType, String errorCode, String errorMessage,
			IExecutionContext context,
			boolean toNotify, Exception e, Map<String, Object> formatParameters) {
		super(errorCode, errorMessage, e, formatParameters);
		this.errorType = errorType;
		this.applicationId = applicationId;
		executionContext = context;
		isToNotify = toNotify;
	}

	public IExecutionContext getExecutionContext() {
		return executionContext;
	}

	public boolean isToNotify() {
		return isToNotify;
	}

	public String getApplicationId() {
		return applicationId;
	}

	@Override
	public String getErrorType() {
		return errorType;
	}

}
