package it.framework.test.dao.impl;

public class TestRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -405662152021155554L;
	
	public TestRuntimeException(Exception e){
		super(e);
	}

}
