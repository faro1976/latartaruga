package it.framework.core.repository.impl;

public class RepositoryRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 8104300920731099574L;

	public RepositoryRuntimeException() {
	}

	public RepositoryRuntimeException(String message) {
		super(message);
	}

	public RepositoryRuntimeException(Throwable cause) {
		super(cause);
	}

	public RepositoryRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
