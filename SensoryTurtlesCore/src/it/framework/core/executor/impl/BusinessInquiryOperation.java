package it.framework.core.executor.impl;

import it.framework.client.service.inferf.IRequestParameter;
import it.framework.core.executor.interf.IInquiryOperation;

public abstract class BusinessInquiryOperation<P, R> extends BusinessOperation<P, R> implements IInquiryOperation<R> {

	private String operationId;

	public BusinessInquiryOperation(IRequestParameter<P> businessRequest, String operationId) {
		super(businessRequest);
		this.operationId = operationId;
	}

	@Override
	public final String getOperationId() {
		return "inquiry:" + operationId;
	}

}
