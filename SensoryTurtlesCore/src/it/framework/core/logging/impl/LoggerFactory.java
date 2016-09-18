package it.framework.core.logging.impl;

import it.framework.core.logging.interf.IAuditLogger;
import it.framework.core.logging.interf.IExecutionLogContext;
import it.framework.core.logging.interf.ILogContext;
import it.framework.core.logging.interf.ILogger;
import it.framework.core.logging.interf.ILoggerManager;
import it.framework.core.logging.interf.IPerformanceLogger;

public class LoggerFactory {

	private static ILoggerManager logManager = LoggerFactoryBinder.getSingletonLog4J();

	public static IAuditLogger getAuditLogger() {
		return logManager.getAuditLogger();
	}

	public static IPerformanceLogger getPerformanceLogger() {
		return logManager.getPerformanceLogger();
	}

	public static ILogger getLogger(String resource) {
		return logManager.getLogger(resource);
	}

	public static ILogger getLogger(Class<?> clazz) {
		return logManager.getLogger(clazz.getName());
	}

	public static ILogger getLogger() {
		return logManager.getLogger();
	}

	public static void initContext(ILogContext context) {
		logManager.initContext(context);
	}

	public static void initContext(IExecutionLogContext context) {
		logManager.initContext(context);
	}

	public static IAuditLogger getAuditLogger(String resource) {
		return logManager.getAuditLogger(resource);
	}
}
