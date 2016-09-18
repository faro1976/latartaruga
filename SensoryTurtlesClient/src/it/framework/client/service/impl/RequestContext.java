package it.framework.client.service.impl;

import java.util.Date;

import it.framework.client.service.inferf.IRequestContext;

public class RequestContext implements IRequestContext {
	
	private String clientId;
	private String sessionId;
	private String traceabilityId;
	private String operationId;
	private Date dateTimestamp;
			
	public RequestContext(String clientId, String sessionId, String traceabilityId,String operationId, Date dateTimestamp) {
		super();
		this.clientId = clientId;
		this.sessionId = sessionId;
		this.traceabilityId = traceabilityId;
		this.operationId = operationId;
		this.dateTimestamp = dateTimestamp;
	}

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	@Override
	public String getTraceabilityId() {
		return traceabilityId;
	}

	@Override
	public String getOperationId() {
		return operationId;
	}

	@Override
	public Date getDateTimestamp() {
		return dateTimestamp;
	}

}
