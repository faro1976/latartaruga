package it.latartaruga.sensoryturtles.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApplicationLog {
	
	private int id;
	private String therapist;
	private String member;
	private int idRoom;
	private int idDevice;
	private String typeDevice;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
	private Date timestamp;
	private String cmdDevice;
	
	
	
	public ApplicationLog() {
		super();
	}

	public ApplicationLog(String therapist, String member, int idRoom, int idDevice, String typeDevice, Date timestamp,
			String cmdDevice) {
		super();
		this.therapist = therapist;
		this.member = member;
		this.idRoom = idRoom;
		this.idDevice = idDevice;
		this.typeDevice = typeDevice;
		this.timestamp = timestamp;
		this.cmdDevice = cmdDevice;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTherapist() {
		return therapist;
	}

	public void setTherapist(String therapist) {
		this.therapist = therapist;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
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

	public String getTypeDevice() {
		return typeDevice;
	}

	public void setTypeDevice(String typeDevice) {
		this.typeDevice = typeDevice;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getCmdDevice() {
		return cmdDevice;
	}

	public void setCmdDevice(String cmdDevice) {
		this.cmdDevice = cmdDevice;
	}
	
	
	

}
