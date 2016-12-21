package it.latartaruga.sensoryturtles.model;

public class Multimedia extends AbstractDevice {
	
	private String path;	

	public Multimedia(DeviceKey deviceKey, String code, String description,String path) {
		super(deviceKey, code, description);
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


}
