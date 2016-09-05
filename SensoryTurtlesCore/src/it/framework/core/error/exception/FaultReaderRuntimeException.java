package it.framework.core.error.exception;

public class FaultReaderRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -161053458392726527L;

	public FaultReaderRuntimeException(String e) {
		super(e);
	}

	public FaultReaderRuntimeException(Exception e) {
		super(e);
	}

}
