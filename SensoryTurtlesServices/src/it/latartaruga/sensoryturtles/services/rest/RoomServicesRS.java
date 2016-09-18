package it.latartaruga.sensoryturtles.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import it.framework.client.service.impl.PagedRequest;
import it.framework.client.service.impl.RequestContext;
import it.framework.client.service.impl.RestFault;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IRequestContext;
import it.framework.core.exposer.impl.RestExposer;
import it.framework.core.service.impl.Offset;
import it.latartarufa.sensoryturtles.ejb.RoomServiceBean;
import it.latartarufa.sensoryturtles.ejb.interf.IRoomServiceEJBLocal;
import it.latartaruga.sensoryturtles.model.ControllerRGB;
import it.latartaruga.sensoryturtles.model.Multimedia;
import it.latartaruga.sensoryturtles.model.Relay;
import it.latartaruga.sensoryturtles.model.Room;

public class RoomServicesRS extends RestExposer implements IRoomServiceRS {
	
	
	@EJB
	private IRoomServiceEJBLocal roomService;

	@Override
	public IPagedResponse<List<? extends Room>> getRooms() throws RestFault {
		try {
			IRequestContext requestContext = new RequestContext("JUNIT", null, null, "1", null);
			IOffset offset = new Offset(0, Integer.MAX_VALUE);
			IPagedRequest<String> pagedRequest = new PagedRequest(requestContext,offset,null,null);
			return roomService.ricercaRooms(pagedRequest);
		} catch (ServiceException  e){
			throw createRestExeption(e);
		}
	}

	@Override
	public Room getRoom(String idRoom) {
		System.out.println("ID_ROOM:[" +idRoom + "]");
		Room room = new Room(1,"01","Prova 1");
		return room;
	}


	@Override
	public List<Relay> getRelaysByRoom(String idRoom) {
		System.out.println("ID_ROOM:[" +idRoom + "]");
		
		List<Relay> devices = new ArrayList<>();
		Relay device = new Relay(1,"01","device 1",11);
		devices.add(device);

		return devices;
	}

	@Override
	public List<ControllerRGB> getControllerRGBByRoom(String idRoom) {
		System.out.println("ID_ROOM:[" +idRoom + "]");
		
		List<ControllerRGB> devices = new ArrayList<>();
		ControllerRGB device =  new ControllerRGB(2,"02","device 2",22);
		devices.add(device);
		
		return devices;
	}

	@Override
	public List<Multimedia> getMultimediaByRoom(String idRoom) {
		System.out.println("ID_ROOM:[" +idRoom + "]");
		
		List<Multimedia> devices = new ArrayList<>();
		Multimedia device =  new Multimedia(3,"03","device 3");
		devices.add(device);
		
		return devices;
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
