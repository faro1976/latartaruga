package it.framework.client.service.inferf;

import java.io.Serializable;

public interface IExecutionContext extends Serializable {
	String getClientId();

	String getSessionId();

	String getTraceabilityId();

	String getOperatonId();

	String getExecutionId();

}
