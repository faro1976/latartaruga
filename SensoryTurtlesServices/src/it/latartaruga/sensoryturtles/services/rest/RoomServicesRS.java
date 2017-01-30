package it.latartaruga.sensoryturtles.services.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.framework.client.service.impl.PagedRequest;
import it.framework.client.service.impl.RequestContext;
import it.framework.client.service.impl.RequestParameter;
import it.framework.client.service.impl.RestFault;
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
import it.latartaruga.sensoryturtles.model.CRUDResult;
import it.latartaruga.sensoryturtles.model.ControllerRGB;
import it.latartaruga.sensoryturtles.model.Multimedia;
import it.latartaruga.sensoryturtles.model.Relay;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.service.interf.IControllerRGBService;
import it.latartaruga.sensoryturtles.service.interf.IMultimediaService;
import it.latartaruga.sensoryturtles.service.interf.IRelayService;
import it.latartaruga.sensoryturtles.service.interf.IRoomService;

public class RoomServicesRS extends RestExposer implements IRoomServiceRS {
	
	
	//@EJB
	//private IRoomServiceEJBLocal roomService;
	
	@Inject
	private ServiceFactoryTurtles factory;
	
	private IRoomService getDelegateRoomService() {
		return factory.getRoomService();
	}
	
	private IRelayService getDelegateRelayService() {
		return factory.getRelayService();
	}
	
	private IControllerRGBService getDelegateControllerRGBService() {
		return factory.getControllerRGBService();
	}
	
	private IMultimediaService getDelegateMultimediaService() {
		return factory.getMultimediaService();
	}

	@Override
	public IPagedResponse<List<? extends Room>> getRooms() throws RestFault {
		try {
			IRequestContext requestContext = new RequestContext("WEB", null, null, "1", null);
			IOffset offset = new Offset(0, Integer.MAX_VALUE);
			IPagedRequest<String> pagedRequest = new PagedRequest(requestContext,offset,null,null);
			return getDelegateRoomService().ricercaRooms(pagedRequest);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	}

	#Override
	public CRUDResult readList() {
		IPagedResponse<List<? extends Room>> ret = getRooms();
		return new CRUDResult(CRUDResult.OK, ret.getResult());
    }
	
	
	@Override
	public IResponse<Room> getRoom(String idRoom) {
		try {
			IRequestContext requestContext = new RequestContext("WEB", null, null, "1", null);
			IRequestParameter<Integer> requestParameter = new RequestParameter<Integer>(requestContext, Integer.valueOf(idRoom));
			return getDelegateRoomService().ricercaRoom(requestParameter);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	}


	@Override
	public IPagedResponse<List<? extends Relay>> getRelaysByRoom(String idRoom) {
		try {
			IRequestContext requestContext = new RequestContext("WEB", null, null, "1", null);
			IOffset offset = new Offset(0, Integer.MAX_VALUE);
			IPagedRequest<Integer> pagedRequest = new PagedRequest(requestContext,offset,null,Integer.valueOf(idRoom));
			return getDelegateRelayService().ricercaRelaysByRoom(pagedRequest);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	}

	@Override
	public IPagedResponse<List<? extends ControllerRGB>> getControllerRGBByRoom(String idRoom) {
		try {
			IRequestContext requestContext = new RequestContext("WEB", null, null, "1", null);
			IOffset offset = new Offset(0, Integer.MAX_VALUE);
			IPagedRequest<Integer> pagedRequest = new PagedRequest(requestContext,offset,null,Integer.valueOf(idRoom));
			return getDelegateControllerRGBService().ricercaControllerRGBByRoom(pagedRequest);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	}

	@Override
	public IPagedResponse<List<? extends Multimedia>> getMultimediaByRoom(String idRoom) {
		try {
			IRequestContext requestContext = new RequestContext("WEB", null, null, "1", null);
			IOffset offset = new Offset(0, Integer.MAX_VALUE);
			IPagedRequest<Integer> pagedRequest = new PagedRequest(requestContext,offset,null,Integer.valueOf(idRoom));
			return getDelegateMultimediaService().ricercaMultimediaByRoom(pagedRequest);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	}

	@Override
	public Room createRoom(Room room) {

		System.out.println("CODE:[" +room.getCode() + "]");
		System.out.println("DESCRIPTION:[" + room.getDescription() + "]");
		room.setIdRoom(100);

		return room;
	}

	@Override
	public Room replaceRoom(Room room) {
		
		System.out.println("CODE:[" +room.getCode() + "]");
		System.out.println("DESCRIPTION:[" + room.getDescription() + "]");
		room.setCode(room.getCode() + "UPDATE");

		return room;
	}

	@Override
	public void deleteRoom(int idRoom) {
		System.out.println("ID_ROOM:[" +idRoom + "]");
		
	}


	@Override
	public Room createRelayByRoom(int idRoom, Relay relay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room replaceRelayByRoom(int idRoom, Relay relay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room deleteRelayByRoom(int idRoom, int idRelay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room createControllersRGBByRoom(int idRoom, ControllerRGB controllerRGB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room replaceControllersRGBByRoom(int idRoom, ControllerRGB controllerRGB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room deleteControllersRGBByRoom(int idRoom, int idControllerRGB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room createMultimediaByRoom(int idRoom, Multimedia multimedia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room replaceMultimediaByRoom(int idRoom, Multimedia multimedia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room deleteMultimediaBByRoom(int idRoom, int idMultimedia) {
		// TODO Auto-generated method stub
		return null;
	}



}
