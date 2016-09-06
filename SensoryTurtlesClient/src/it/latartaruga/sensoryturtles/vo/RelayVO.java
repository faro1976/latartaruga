package it.latartaruga.sensoryturtles.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RelayVO  extends ZWaveDeviceVO{

	public RelayVO(String code, String description, String idZWave) {
		super(code, description, idZWave);

	}

}
