package it.latartaruga.sensoryturtles.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDResult {
	public final static String OK="OK";
	public final static String ERROR="ERROR";
	
	private String Result;
	private List Records;
	
	public CRUDResult(String result, List records) {
		Result = result;
		Records = records;
	}
	
	
	@JsonProperty("Result")
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	
	@JsonProperty("Records")
	public List getRecords() {
		return Records;
	}
	public void setRecords(List records) {
		Records = records;
	}
}
