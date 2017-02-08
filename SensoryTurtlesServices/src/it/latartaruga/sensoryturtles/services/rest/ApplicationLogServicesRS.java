package it.latartaruga.sensoryturtles.services.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;

import it.framework.client.service.impl.RequestContext;
import it.framework.client.service.impl.RequestParameter;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IRequestContext;
import it.framework.client.service.inferf.IRequestParameter;
import it.framework.client.service.inferf.IResponse;
import it.framework.core.exposer.impl.RestExposer;
import it.latartarufa.sensoryturtles.ejb.factory.ServiceFactoryTurtles;
import it.latartaruga.sensoryturtles.model.ApplicationLog;
import it.latartaruga.sensoryturtles.service.interf.IApplicationLogService;

public class ApplicationLogServicesRS extends RestExposer implements IApplicationLogServiceRS {
	

	@Inject
	private ServiceFactoryTurtles factory;
	
			
	
	private IApplicationLogService getDelegateApplicationLogService() {
		return factory.getApplicationLogService();
	}
	

	@Override
	@Transactional
	public IResponse<ApplicationLog> createLog(ApplicationLog applicationLog) {
		try {
	
			IRequestContext requestContext = new RequestContext("WEB", null, null, "1", null);
			IRequestParameter<ApplicationLog> requestParameter = new RequestParameter(requestContext,applicationLog);
			return getDelegateApplicationLogService().createLog(requestParameter);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	
	}



}
