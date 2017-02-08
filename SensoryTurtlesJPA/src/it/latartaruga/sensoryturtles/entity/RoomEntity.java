package it.latartaruga.sensoryturtles.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@Table(name="room")
@NamedQuery(name="RoomEntity.findAll", query="SELECT r FROM RoomEntity r")
public class RoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idROOM;

	private String code;

	private String descr;

	//bi-directional many-to-one association to DeviceControllerRgbEntity
	@OneToMany(mappedBy="room")
	private List<DeviceControllerRgbEntity> deviceControllerRgbs;

	//bi-directional many-to-one association to DeviceRelayEntity
	@OneToMany(mappedBy="room")
	private List<DeviceRelayEntity> deviceRelays;

	public RoomEntity() {
	}

	public int getIdROOM() {
		return this.idROOM;
	}

	public void setIdROOM(int idROOM) {
		this.idROOM = idROOM;
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

	public List<DeviceControllerRgbEntity> getDeviceControllerRgbs() {
		return this.deviceControllerRgbs;
	}

	public void setDeviceControllerRgbs(List<DeviceControllerRgbEntity> deviceControllerRgbs) {
		this.deviceControllerRgbs = deviceControllerRgbs;
	}

	public DeviceControllerRgbEntity addDeviceControllerRgb(DeviceControllerRgbEntity deviceControllerRgb) {
		getDeviceControllerRgbs().add(deviceControllerRgb);
		deviceControllerRgb.setRoom(this);

		return deviceControllerRgb;
	}

	public DeviceControllerRgbEntity removeDeviceControllerRgb(DeviceControllerRgbEntity deviceControllerRgb) {
		getDeviceControllerRgbs().remove(deviceControllerRgb);
		deviceControllerRgb.setRoom(null);

		return deviceControllerRgb;
	}

	
	public List<DeviceRelayEntity> getDeviceRelays() {
		return this.deviceRelays;
	}

	public void setDeviceRelays(List<DeviceRelayEntity> deviceRelays) {
		this.deviceRelays = deviceRelays;
	}

	public DeviceRelayEntity addDeviceRelay(DeviceRelayEntity deviceRelay) {
		getDeviceRelays().add(deviceRelay);
		deviceRelay.setRoom(this);

		return deviceRelay;
	}

	public DeviceRelayEntity removeDeviceRelay(DeviceRelayEntity deviceRelay) {
		getDeviceRelays().remove(deviceRelay);
		deviceRelay.setRoom(null);

		return deviceRelay;
	}

}