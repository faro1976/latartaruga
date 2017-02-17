package it.latartaruga.sensoryturtles.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the application_log database table.
 * 
 */
@Entity
@Table(name="application_log")
@NamedQueries({ @NamedQuery(name = "ApplicationLogEntity.findByRoomTherapistMember", query = "select o from ApplicationLogEntity o where o.idROOM = :idROOMValue and o.therapist= :THERAPISTValue and o.member = :MEMBERValue")})
public class ApplicationLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAPPLICATIONLOG;

	private String cmdDEVICE;

	private int idDEVICE;

	private int idROOM;

	private String member;

	private String therapist;

	private Timestamp tsCMD;

	private String typeDEVICE;

	public ApplicationLogEntity() {
	}

	public int getIdAPPLICATIONLOG() {
		return this.idAPPLICATIONLOG;
	}

	public void setIdAPPLICATIONLOG(int idAPPLICATIONLOG) {
		this.idAPPLICATIONLOG = idAPPLICATIONLOG;
	}

	public String getCmdDEVICE() {
		return this.cmdDEVICE;
	}

	public void setCmdDEVICE(String cmdDEVICE) {
		this.cmdDEVICE = cmdDEVICE;
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

	public String getMember() {
		return this.member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getTherapist() {
		return this.therapist;
	}

	public void setTherapist(String therapist) {
		this.therapist = therapist;
	}

	public Timestamp getTsCMD() {
		return this.tsCMD;
	}

	public void setTsCMD(Timestamp tsCMD) {
		this.tsCMD = tsCMD;
	}

	public String getTypeDEVICE() {
		return this.typeDEVICE;
	}

	public void setTypeDEVICE(String typeDEVICE) {
		this.typeDEVICE = typeDEVICE;
	}

}