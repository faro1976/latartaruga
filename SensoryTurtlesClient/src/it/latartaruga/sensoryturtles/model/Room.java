package it.latartaruga.sensoryturtles.model;

public class Room {
	
	private int idRoom;
	private String code;
	private String description;
	
	public Room () {
		
	}
	
	public Room(int idRoom, String code, String description) {
		super();
		this.idRoom = idRoom;
		this.code = code;
		this.description = description;
	}
	
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
