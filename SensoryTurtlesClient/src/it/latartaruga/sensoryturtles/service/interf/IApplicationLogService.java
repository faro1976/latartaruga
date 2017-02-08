package it.latartaruga.sensoryturtles.service.interf;

import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IRequestParameter;
import it.framework.client.service.inferf.IResponse;
import it.framework.client.service.inferf.IService;
import it.latartaruga.sensoryturtles.model.ApplicationLog;


public interface IApplicationLogService extends IService {
	

	public IResponse<ApplicationLog> createLog(IRequestParameter<ApplicationLog> request) throws ServiceException;


}
