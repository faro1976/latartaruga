package it.framework.client.service.impl;

import java.io.Serializable;
import java.util.Date;

import it.framework.client.service.inferf.IRequestContext;


public class SerializableRequestContext implements IRequestContext, Serializable {

	private static final String DEFAULT_CLIENTID_SEED = "pfDefaultClientID";
	private static final String DEFAULT_SESSIONID_SEED = "pfDefaultSessionID";
	private static final String DEFAULT_TRACEID_SEED = "pfDefaultTraceID";
	private static final String DEFAULT_OPERATIONID_SEED = "pfDefaultOperationID";

	private static final long serialVersionUID = 285188457202192574L;

	private String clientId;
	private String sessionId;
	private String traceabilityId;
	private String operationId;
	private Date timestamp;

	public SerializableRequestContext(IRequestContext requestContext) {
		timestamp = requestContext.getDateTimestamp();
		clientId = requestContext.getClientId();
		sessionId = requestContext.getSessionId();
		traceabilityId = requestContext.getTraceabilityId();
		operationId = requestContext.getOperationId();
	}

	private SerializableRequestContext() {

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
		return timestamp;
	}

	public static SerializableRequestContext buildDefaultContext() {
		SerializableRequestContext reqCont = new SerializableRequestContext();
		long timestamp = System.currentTimeMillis();
		reqCont.clientId = DEFAULT_CLIENTID_SEED + "_" + timestamp;
		reqCont.operationId = DEFAULT_OPERATIONID_SEED + "_" + timestamp;
		reqCont.sessionId = DEFAULT_SESSIONID_SEED + "_" + timestamp;
		reqCont.timestamp = new Date();
		reqCont.traceabilityId = DEFAULT_TRACEID_SEED + "_" + timestamp;
		return reqCont;

	}
}
