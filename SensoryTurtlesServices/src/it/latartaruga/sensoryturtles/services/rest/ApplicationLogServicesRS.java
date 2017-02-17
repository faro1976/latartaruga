package it.latartaruga.sensoryturtles.services.rest;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import it.framework.client.service.impl.PagedRequest;
import it.framework.client.service.impl.RequestContext;
import it.framework.client.service.impl.RequestParameter;
import it.framework.client.service.impl.RestFault;
import it.framework.client.service.impl.SearchCriteriaApplicationLog;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IRequestContext;
import it.framework.client.service.inferf.IRequestParameter;
import it.framework.client.service.inferf.IResponse;
import it.framework.core.exposer.impl.RestExposer;
import it.framework.core.service.impl.Offset;
import it.latartarufa.sensoryturtles.ejb.factory.ServiceFactoryTurtles;
import it.latartaruga.sensoryturtles.model.ApplicationLog;
import it.latartaruga.sensoryturtles.model.CRUDResult;
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


	@Override
	public IPagedResponse<List<? extends ApplicationLog>> getLogs(	@PathParam("idRoom")  String idRoom,
																	@QueryParam("therapist") String therapist,
																	@QueryParam("member") String member ) throws RestFault {
		try {
			IRequestContext requestContext = new RequestContext("WEB", null, null, "1", null);
			IOffset offset = new Offset(0, Integer.MAX_VALUE);
			SearchCriteriaApplicationLog criteria = new SearchCriteriaApplicationLog(Integer.valueOf(idRoom), therapist, member);
			IPagedRequest<SearchCriteriaApplicationLog> pagedRequest = new PagedRequest(requestContext,offset,null,criteria);
			return getDelegateApplicationLogService().ricercaLogs(pagedRequest);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	}


	@Override
	public CRUDResult readLogs(	@PathParam ("idRoom") String idRoom,
								@QueryParam("therapist") String therapist,
								@QueryParam("member") String member ) {
		IPagedResponse<List<? extends ApplicationLog>> ret = getLogs(idRoom,therapist,member);
		return new CRUDResult(CRUDResult.OK, ret.getResult());
	}



}
