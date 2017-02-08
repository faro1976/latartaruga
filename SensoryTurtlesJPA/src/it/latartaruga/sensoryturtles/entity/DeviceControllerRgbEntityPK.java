package it.latartaruga.sensoryturtles.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the device_controller_rgb database table.
 * 
 */
@Embeddable
public class DeviceControllerRgbEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idDEVICE;

	private int idROOM;

	public DeviceControllerRgbEntityPK() {
	}
	public int getIdDEVICE() {
		return this.idDEVICE;
	}
	public void setIdDEVICE(int idDEVICE) {
		this.idDEVICE = idDEVICE;
	}
	public int getIdROOM() {
		return this.idROOM;
	}
	public void setIdROOM(int idROOM) {
		this.idROOM = idROOM;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeviceControllerRgbEntityPK)) {
			return false;
		}
		DeviceControllerRgbEntityPK castOther = (DeviceControllerRgbEntityPK)other;
		return 
			(this.idDEVICE == castOther.idDEVICE)
			&& (this.idROOM == castOther.idROOM);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDEVICE;
		hash = hash * prime + this.idROOM;
		
		return hash;
	}
}