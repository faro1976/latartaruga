package it.latartaruga.sensoryturtles.model;

public class DeviceKey {
	
	private int idRoom;
	private int idDevice;
	

	public DeviceKey(int idRoom, int idDevice) {
		super();
		this.idRoom = idRoom;
		this.idDevice = idDevice;
	}
	
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public int getIdDevice() {
		return idDevice;
	}
	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

}
