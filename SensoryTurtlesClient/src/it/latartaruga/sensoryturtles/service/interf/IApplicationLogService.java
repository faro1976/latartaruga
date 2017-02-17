package it.latartaruga.sensoryturtles.service.interf;

import java.util.List;

import it.framework.client.service.impl.SearchCriteriaApplicationLog;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IRequestParameter;
import it.framework.client.service.inferf.IResponse;
import it.framework.client.service.inferf.IService;
import it.latartaruga.sensoryturtles.model.ApplicationLog;


public interface IApplicationLogService extends IService {
	
	public IResponse<ApplicationLog> createLog(IRequestParameter<ApplicationLog> request) throws ServiceException;
	public IPagedResponse<List<? extends ApplicationLog>> ricercaLogs(IPagedRequest<SearchCriteriaApplicationLog> request) throws ServiceException;


}
