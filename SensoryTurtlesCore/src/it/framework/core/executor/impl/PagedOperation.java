package it.framework.core.executor.impl;

import it.framework.client.service.impl.OperationException;
import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.core.dao.interf.IPager;

public abstract class PagedOperation<P, R> extends BusinessInquiryOperation<P, R> {

	IPager<? extends R> pager;
	private IPagedRequest<P> businessRequest;

	public PagedOperation(IPagedRequest<P> businessRequest, String operationId) {
		super(businessRequest, operationId);
		this.businessRequest = businessRequest;
	}

	@Override
	protected R doPerform(P param) throws OperationException {
		pager = getPager(businessRequest.getOffset(),param);
		pager.setSortProperties(businessRequest.getSortProperties());
		return pager.getResult();
	}

	protected abstract IPager<? extends R> getPager(IOffset offset,P param);

	public Long getTotalCount() {
		return pager.getTotalCount();
	}

}
