package it.framework.client.service.inferf;

import it.framework.client.service.impl.ServiceException;

public interface IService {
	ServiceException createServiceException(Exception e, IRequestContext requestContext);
}
