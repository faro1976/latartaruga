package it.latartaruga.sensoryturtles.model;

public abstract class AbstractDevice {
	
	private int idDevice;
	private String code;
	private String description;
	
		
	public AbstractDevice(int idDevice, String code, String description) {
		super();
		this.idDevice = idDevice;
		this.code = code;
		this.description = description;
	}
	
	
	public int getIdDevice() {
		return idDevice;
	}
	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
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
