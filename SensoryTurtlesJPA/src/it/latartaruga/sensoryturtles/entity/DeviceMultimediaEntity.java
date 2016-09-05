package it.latartaruga.sensoryturtles.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the device_multimedia database table.
 * 
 */
@Entity
@Table(name="device_multimedia")
@NamedQuery(name="DeviceMultimediaEntity.findAll", query="SELECT d FROM DeviceMultimediaEntity d")
public class DeviceMultimediaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeviceMultimediaEntityPK id;

	private String code;

	private String descr;

	private String path;

	//bi-directional many-to-one association to RoomEntity
	@ManyToOne
	@JoinColumn(name="idROOM")
	private RoomEntity room;

	public DeviceMultimediaEntity() {
	}

	public DeviceMultimediaEntityPK getId() {
		return this.id;
	}

	public void setId(DeviceMultimediaEntityPK id) {
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public RoomEntity getRoom() {
		return this.room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

}