package it.framework.client.service.impl;

import javax.ws.rs.WebApplicationException;

import it.framework.client.service.impl.type.BaseFaultType;

public class RestFault extends WebApplicationException {

	private BaseFaultType fault;
	private static final long serialVersionUID = 7925555469835782878L;

	public RestFault(BaseFaultType fault, Exception e) {
		super(e);
		this.fault = fault;
	}

	public BaseFaultType getFault() {
		return fault;
	}
}
