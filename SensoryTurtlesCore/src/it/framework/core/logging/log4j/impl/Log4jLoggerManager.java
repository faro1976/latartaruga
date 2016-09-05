package it.framework.core.logging.log4j.impl;

import it.framework.core.logging.interf.IAuditLogger;
import it.framework.core.logging.interf.IExecutionLogContext;
import it.framework.core.logging.interf.ILogContext;
import it.framework.core.logging.interf.ILogger;
import it.framework.core.logging.interf.ILoggerManager;
import it.framework.core.logging.interf.IPerformanceLogger;

public class Log4jLoggerManager implements ILoggerManager {
	private IAuditLogger auditLogger;
	private IPerformanceLogger performanceLogger;
	private ILogger defaultLogger;

	private Log4jFactory factory = new Log4jFactory();

	@Override
	public IAuditLogger getAuditLogger() {
		if (auditLogger == null) {
			auditLogger = factory.getAuditLogger();
		}
		return auditLogger;
	}

	@Override
	public IAuditLogger getAuditLogger(String resource) {
		return factory.getAuditLogger(resource);
	}

	@Override
	public IPerformanceLogger getPerformanceLogger() {
		if (performanceLogger == null) {
			performanceLogger = factory.getPerformanceLogger();
		}
		return performanceLogger;
	}

	@Override
	public ILogger getLogger(String resource) {
		return factory.getLogger(resource);
	}

	@Override
	public ILogger getLogger() {
		if (defaultLogger == null) {
			defaultLogger = factory.getDefaultLogger();
		}
		return defaultLogger;
	}

	@Override
	public void initContext(ILogContext requestContext) {
		LogEntry.initContext(requestContext);
	}

	@Override
	public void initContext(IExecutionLogContext context) {
		LogEntry.initContext(context);
	}

}
