package it.framework.core.logging.interf;

public interface IAuditLogger {
	void log(String operationName, boolean isSuccess);

	void log(String operationName, String businessId, boolean isSuccess, boolean inTransaction);
}
