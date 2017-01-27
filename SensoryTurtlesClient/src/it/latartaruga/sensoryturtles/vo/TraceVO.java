package it.latartaruga.sensoryturtles.vo;

import java.util.Date;

public class TraceVO {
	private String idTherapist;
	private String idMember;
	private Date timestamp;
	private String invokedUrl;
	private String deviceId;
	private DeviceTypeVO deviceType;
	private String cmd;
	
	public enum DeviceTypeVO {
		SWITCH,
		RGB,
		MEDIA_PLAYER
	}
	
	public String getIdTherapist() {
		return idTherapist;
	}
	public void setIdTherapist(String idTherapist) {
		this.idTherapist = idTherapist;
	}
	public String getIdMember() {
		return idMember;
	}
	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getInvokedUrl() {
		return invokedUrl;
	}
	public void setInvokedUrl(String invokedUrl) {
		this.invokedUrl = invokedUrl;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public DeviceTypeVO getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceTypeVO deviceType) {
		this.deviceType = deviceType;
	}

	
	
}
