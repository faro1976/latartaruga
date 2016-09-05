package it.framework.client.service.impl;

import java.util.ArrayList;
import java.util.List;

import it.framework.client.service.inferf.IResponse;
import it.framework.client.service.inferf.IResultStatus;

public class BusinessResponseDefault<T> implements IResponse<T> {

	private T result;
	private List<IResultStatus> resultStatus = new ArrayList<IResultStatus>();

	@Override
	public List<IResultStatus> getResultStatus() {
		return resultStatus;
	}

	@Override
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
