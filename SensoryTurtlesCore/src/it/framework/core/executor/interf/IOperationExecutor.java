package it.framework.core.executor.interf;

import it.framework.client.service.impl.BusinessResponseDefault;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IResponse;
import it.framework.client.service.inferf.IService;

public interface IOperationExecutor extends IService {

	<R> IResponse<R> execute(IOperation<R> operation) throws ServiceException;
	
	<R, BR extends BusinessResponseDefault<R>> BR execute(IOperation<R> operation, BR response)
			throws ServiceException;

}
