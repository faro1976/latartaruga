package it.framework.core.logging.interf;

public interface ILoggerManager {

	void initContext(ILogContext context);

	void initContext(IExecutionLogContext context);

	ILogger getLogger(String resource);

	ILogger getLogger();

	IPerformanceLogger getPerformanceLogger();

	IAuditLogger getAuditLogger();

	IAuditLogger getAuditLogger(String resource);

}
