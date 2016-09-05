package it.framework.core.logging.log4j.impl;

public class FrameworkLoggingLog4jRuntimeExcpetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7177356520971621071L;

	public FrameworkLoggingLog4jRuntimeExcpetion(String message) {
		super(message);
	}

	public FrameworkLoggingLog4jRuntimeExcpetion(String message, Exception e) {
		super(message, e);
	}

}
