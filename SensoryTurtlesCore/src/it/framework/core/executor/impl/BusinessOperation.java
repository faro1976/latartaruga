package it.framework.core.executor.impl;

import java.util.ArrayList;
import java.util.List;

import it.framework.client.service.impl.OperationException;
import it.framework.client.service.inferf.IRequest;
import it.framework.client.service.inferf.IRequestParameter;
import it.framework.client.service.inferf.IResultStatus;
import it.framework.client.service.inferf.ResultStatus;
import it.framework.core.executor.interf.IOperation;

public abstract class BusinessOperation<P, R> implements IOperation<R> {

	protected IRequestParameter<P> businessRequest;

	private List<IResultStatus> resultStatus = new ArrayList<>();

	private Level level;

	public BusinessOperation(IRequestParameter<P> businessRequest) {
		this.businessRequest = businessRequest;
		this.level = Level.NORMAL;
	}

	public BusinessOperation(IRequestParameter<P> businessRequest, Level level) {
		this.businessRequest = businessRequest;
		this.level = level;
	}

	@Override
	public IRequestParameter<?> getRequest() {
		return businessRequest;
	}

	@Override
	public R perform() throws OperationException {
		return doPerform(businessRequest.getParameter());
	}

	protected abstract R doPerform(P param) throws OperationException;

	@Override
	public List<IResultStatus> getResultStatus() {
		return resultStatus;
	}

	public void add(IResultStatus rs) {
		resultStatus.add(rs);
	}

	@Override
	public Level getLevel() {
		return level;
	}

}
