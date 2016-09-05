package it.framework.core.service.impl;

import it.framework.client.service.impl.PagedResponse;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IRequestContext;
import it.framework.client.service.inferf.IResponse;
import it.framework.client.service.inferf.IService;
import it.framework.core.executor.impl.PagedOperation;
import it.framework.core.executor.interf.IOperation;
import it.framework.core.executor.interf.IOperationExecutor;

public class BusinessService implements IService {

	private IOperationExecutor executor;

	public BusinessService(IOperationExecutor executor) {
		this.executor = executor;
	}

	protected <T> IResponse<T> invoke(IOperation<T> operation) throws ServiceException {
		return executor.execute(operation);
	}

	protected <R> PagedResponse<R> invoke(PagedOperation<?, R> operation) throws ServiceException {
		PagedResponse<R> response = new PagedResponse<>();
		executor.execute(operation, response);
		response.setTotalCount(operation.getTotalCount());
		return response;
	}

	@Override
	public ServiceException createServiceException(Exception e, IRequestContext requestContext) {
		return executor.createServiceException(e, requestContext);
	}


}
