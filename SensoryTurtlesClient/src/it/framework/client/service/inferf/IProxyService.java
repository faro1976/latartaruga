package it.framework.client.service.inferf;

import it.framework.client.service.impl.ServiceException;

public abstract class IProxyService implements IService {
	protected abstract IService getDelegateService();

	@Override
	public ServiceException createServiceException(Exception e, IRequestContext requestContext) {
		return getDelegateService().createServiceException(e, requestContext);
	}



}
