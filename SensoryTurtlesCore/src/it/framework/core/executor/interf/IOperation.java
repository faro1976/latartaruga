package it.framework.core.executor.interf;

import java.util.List;

import it.framework.client.service.impl.OperationException;
import it.framework.client.service.inferf.IRequest;
import it.framework.client.service.inferf.IResultStatus;

public interface IOperation<R> {
	IRequest<R> getRequest();

	R perform() throws OperationException;

	String getOperationId();

	String getBusinessId();

	List<IResultStatus> getResultStatus();

	Level getLevel();

	enum Level {
		HIGH, NORMAL, LOW
	}
}
