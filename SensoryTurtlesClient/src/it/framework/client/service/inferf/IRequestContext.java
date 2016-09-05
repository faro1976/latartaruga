package it.framework.client.service.inferf;

import java.util.Date;

public interface IRequestContext {

	String getClientId();

	String getSessionId();

	String getTraceabilityId();

	String getOperationId();

	Date getDateTimestamp();
}
