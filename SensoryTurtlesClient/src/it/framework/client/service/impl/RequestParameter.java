package it.framework.client.service.impl;

import it.framework.client.service.inferf.IRequestContext;
import it.framework.client.service.inferf.IRequestParameter;

public class RequestParameter<P> implements IRequestParameter<P>{
	
	private IRequestContext requestContext;
	private P parameter;
	
	public RequestParameter(IRequestContext requestContext,P parameter) {
		super();
		this.requestContext = requestContext;
		this.parameter = parameter;
	}

	@Override
	public IRequestContext getContext() {
		return requestContext;
	}

	@Override
	public P getParameter() {
		return parameter;
	}

	@Override
	public void setContext(IRequestContext requestContext) {
		this.requestContext=requestContext;
	}
	

}
