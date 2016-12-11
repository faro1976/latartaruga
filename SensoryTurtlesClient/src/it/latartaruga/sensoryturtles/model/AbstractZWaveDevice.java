package it.latartaruga.sensoryturtles.model;

public abstract class AbstractZWaveDevice extends AbstractDevice {
	
	private int idRaspBerry;

		
	public AbstractZWaveDevice(DeviceKey deviceKey, String code, String description, int idRaspBerry) {
		super(deviceKey, code, description);
		this.idRaspBerry = idRaspBerry;
	}

	public int getIdRaspBerry() {
		return idRaspBerry;
	}

	public void setIdRaspBerry(int idRaspBerry) {
		this.idRaspBerry = idRaspBerry;
	}
	
	

}
