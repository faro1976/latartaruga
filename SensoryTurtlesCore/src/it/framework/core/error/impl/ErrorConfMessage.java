package it.framework.core.error.impl;

import it.framework.core.error.interf.IErrorConfMessage;

public class ErrorConfMessage implements IErrorConfMessage {
	
	private String applicationId;
	private long errorId;
	private String sourceCode;
	private String sourceMessage;
	private String userCode;
	private String userMessage;
	

	public ErrorConfMessage(String applicationId, long errorId, String sourceCode, String sourceMessage,
			String userCode, String userMessage) {
		super();
		this.applicationId = applicationId;
		this.errorId = errorId;
		this.sourceCode = sourceCode;
		this.sourceMessage = sourceMessage;
		this.userCode = userCode;
		this.userMessage = userMessage;
	}

	@Override
	public long getErrorId() {
		return errorId;
	}

	@Override
	public String getApplicationId() {
		return applicationId;
	}

	
	@Override
	public String getSourceCode() {
		return sourceCode;
	}

	@Override
	public String getSourceMessage() {
		return sourceMessage;
	}

	@Override
	public String getUserCode() {
		return userCode;
	}

	@Override
	public String getUserMessage() {
		return userMessage;
	}

}
