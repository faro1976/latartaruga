package it.latartarufa.sensoryturtles.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IProxyService;
import it.latartarufa.sensoryturtles.ejb.factory.ServiceFactoryTurtles;
import it.latartarufa.sensoryturtles.ejb.interf.IRoomServiceEJBLocal;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.service.interf.IRoomService;

@Stateless(name = "RoomServiceBean")
public class RoomServiceBean extends IProxyService implements IRoomServiceEJBLocal {

	@Inject
	private ServiceFactoryTurtles factory;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public IPagedResponse<List<? extends Room>> ricercaRooms(IPagedRequest<String> request) throws ServiceException {
		return getDelegateService().ricercaRooms(request);
	}

	@Override
	protected IRoomService getDelegateService() {
		return factory.getRoomService();
	}

	
}
