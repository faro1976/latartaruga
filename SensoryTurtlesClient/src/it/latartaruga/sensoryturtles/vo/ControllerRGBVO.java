package it.latartaruga.sensoryturtles.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ControllerRGBVO extends ZWaveDeviceVO {

	public ControllerRGBVO(String code, String description, String idZWave) {
		super(code, description, idZWave);

	}

}
