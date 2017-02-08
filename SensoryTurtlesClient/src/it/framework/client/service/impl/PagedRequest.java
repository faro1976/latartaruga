package it.framework.client.service.impl;

import java.util.List;

import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IRequestContext;
import it.framework.client.service.inferf.ISortProperty;

public class PagedRequest<T> implements IPagedRequest<T> {
	
	private IRequestContext requestContext;
	private IOffset offset;
	private List<? extends ISortProperty> sortProperties;
	private T parameter;
	

	public PagedRequest(IRequestContext requestContext, IOffset offset, List<? extends ISortProperty> sortProperties,T parameter) {
		super();
		this.requestContext = requestContext;
		this.offset = offset;
		this.sortProperties = sortProperties;
		this.parameter = parameter;
	}

	@Override
	public T getParameter() {
		return parameter;
	}

	@Override
	public IRequestContext getContext() {
		return requestContext;
	}

	@Override
	public IOffset getOffset() {
		return offset;
	}

	@Override
	public List<? extends ISortProperty> getSortProperties() {
		return sortProperties;
	}

	@Override
	public void setContext(IRequestContext requestContext) {
		this.setContext(requestContext);
	}

}
