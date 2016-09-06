package it.latartaruga.sensoryturtles.vo;

public abstract class ZWaveDeviceVO extends AbstractDeviceVO{
	private String idZWave;

	public ZWaveDeviceVO(String code, String description, String idZWave) {
		super(code, description);
		this.idZWave = idZWave;
	}

	public String getIdZWave() {
		return idZWave;
	}

	public void setIdZWave(String idZWave) {
		this.idZWave = idZWave;
	}
	
}
