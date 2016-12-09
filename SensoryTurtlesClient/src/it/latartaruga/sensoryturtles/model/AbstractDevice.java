package it.latartaruga.sensoryturtles.model;

public abstract class AbstractDevice {
	
	private DeviceKey deviceKey;
	private String code;
	private String description;
	
		
	public AbstractDevice(DeviceKey deviceKey, String code, String description) {
		super();
		this.deviceKey = deviceKey;
		this.code = code;
		this.description = description;
	}
	

	public DeviceKey getDeviceKey() {
		return deviceKey;
	}
	public void setDeviceKey(DeviceKey deviceKey) {
		this.deviceKey = deviceKey;
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
