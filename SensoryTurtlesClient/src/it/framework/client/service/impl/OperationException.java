package it.framework.client.service.impl;

import java.util.HashMap;
import java.util.Map;

import it.framework.core.service.enums.ErrorTypeEnum;
import it.framework.core.util.MessageFormatter;


public class OperationException extends Exception {
	private static final long serialVersionUID = -4503722043119928179L;

	private final String errorCode;
	private final HashMap<String, Object> formatParameters;

	public OperationException(String errorCode) {
		this(errorCode, (String) null);
	}

	public OperationException(String errorCode, String message) {
		this(errorCode, message, (Exception) null);
	}

	public OperationException(String errorCode, String message, Exception exception) {
		this(errorCode, message, exception, (Map<String, Object>) null);
	}

	public OperationException(String errorCode, Exception exception) {
		this(errorCode, (String) null, exception);
	}

	public OperationException(String errorCode, Map<String, Object> formatParameters) {
		this(errorCode, (String) null, formatParameters);
	}

	public OperationException(String errorCode, String message,
			Map<String, Object> formatParameters) {
		this(errorCode, message, (Exception) null, formatParameters);
	}

	public OperationException(String errorCode, String message, Exception exception,
			Map<String, Object> formatParameters) {
		super(message, exception);
		this.formatParameters = formatParameters != null ? new HashMap<>(formatParameters) : null;
		this.errorCode = errorCode;
	}

	public OperationException(String errorCode, Exception exception, Map<String, Object> formatParameters) {
		this(errorCode, (String) null, exception, formatParameters);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorType() {
		return ErrorTypeEnum.OPERATION;
	}

	public void addFormatParameter(String key, Object value) {
		formatParameters.put(key, value);
	}

	public Map<String, Object> getFormatParameters() {
		return formatParameters;
	}

	@Override
	public String getMessage() {
		return MessageFormatter.format(super.getMessage(), formatParameters);
	}

}
