package it.latartaruga.sensoryturtles.service.interf;

import java.util.List;

import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IService;
import it.latartaruga.sensoryturtles.model.Multimedia;


public interface IMultimediaService extends IService {
	
	public IPagedResponse<List<? extends Multimedia>> ricercaMultimediaByRoom(IPagedRequest<Integer> request) throws ServiceException;
	


}
