package it.latartaruga.sensoryturtles.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the device_controller_rgb database table.
 * 
 */
@Entity
@Table(name="device_controller_rgb")
@NamedQuery(name="DeviceControllerRgbEntity.findAll", query="SELECT d FROM DeviceControllerRgbEntity d")
public class DeviceControllerRgbEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeviceControllerRgbEntityPK id;

	private String code;

	private String descr;

	private int idRaspBerry;

	//bi-directional many-to-one association to RoomEntity
	@ManyToOne
	@JoinColumn(name="idROOM",insertable=false, updatable=false)
	private RoomEntity room;

	public DeviceControllerRgbEntity() {
	}

	public DeviceControllerRgbEntityPK getId() {
		return this.id;
	}

	public void setId(DeviceControllerRgbEntityPK id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getIdRaspBerry() {
		return this.idRaspBerry;
	}

	public void setIdRaspBerry(int idRaspBerry) {
		this.idRaspBerry = idRaspBerry;
	}

	public RoomEntity getRoom() {
		return this.room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

}