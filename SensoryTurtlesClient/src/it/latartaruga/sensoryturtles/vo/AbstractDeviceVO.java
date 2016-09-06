package it.latartaruga.sensoryturtles.vo;

public abstract class AbstractDeviceVO {
	private String code;
	private String description;
	private String className;
	
	public AbstractDeviceVO(String code, String description) {
		super();
		this.code = code;
		this.description = description;
		this.className = this.getClass().getCanonicalName();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
