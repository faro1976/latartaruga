package it.latartaruga.sensoryturtles.services.rest;

import java.util.ArrayList;
import java.util.List;

import it.latartaruga.sensoryturtles.model.ControllerRGB;
import it.latartaruga.sensoryturtles.model.Multimedia;
import it.latartaruga.sensoryturtles.model.Relay;
import it.latartaruga.sensoryturtles.model.Room;

public class RoomServices implements IRoomService {

	@Override
	public List<Room> getRooms() {
		List<Room> rooms = new ArrayList<>();
		Room room = new Room(1,"01","Prova 1");
		rooms.add(room);
		return rooms;
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
