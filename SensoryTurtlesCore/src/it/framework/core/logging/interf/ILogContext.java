package it.framework.core.logging.interf;

public interface ILogContext {
	String getClientId();

	String getSessionId();

	String getTraceabilityId();
}
