package it.framework.client.service.impl;

public class SearchCriteriaApplicationLog  {
	
	private Integer idRoom;
	private String therapist;
	private String member;
	
	
	public SearchCriteriaApplicationLog(Integer idRoom, String therapist, String member) {
		super();
		this.idRoom = idRoom;
		this.therapist = therapist;
		this.member = member;
	}
	
	
	public Integer getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(Integer idRoom) {
		this.idRoom = idRoom;
	}
	public String getTherapist() {
		return therapist;
	}
	public void setTherapist(String therapist) {
		this.therapist = therapist;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	
	
	

}
