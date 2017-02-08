package it.latartaruga.sensoryturtles.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the device_relay database table.
 * 
 */
@Entity(name="device_relay")
@Table(name="device_relay")
@NamedQueries({ @NamedQuery(name = "DeviceRelayEntity.findByRoom", query = "select o from device_relay o where o.id.idROOM= :idROOMValue")})
public class DeviceRelayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeviceRelayEntityPK id;
	
	
	private String code;

	private String descr;

	private int idRaspBerry;

	//bi-directional many-to-one association to RoomEntity
	@ManyToOne
	@JoinColumn(name="idROOM",insertable=false, updatable=false)
	private RoomEntity room;

	public DeviceRelayEntity() {
	}

	public DeviceRelayEntityPK getId() {
		return this.id;
	}

	public void setId(DeviceRelayEntityPK id) {
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