package it.framework.core.logging.log4j.impl;



import org.apache.logging.log4j.LogManager;

import it.framework.core.logging.interf.IAuditLogger;
import it.framework.core.logging.interf.ILogger;
import it.framework.core.logging.interf.IPerformanceLogger;

public class Log4jFactory {

	private static final String LOGGER_PREFIX = "ipfl.";

	public IAuditLogger getAuditLogger() {
		org.apache.logging.log4j.Logger log4jLogger = LogManager.getLogger(LOGGER_PREFIX + "audit");
		return new Log4jAuditLogger(new Log4jWrapper(log4jLogger));
	}

	public IAuditLogger getAuditLogger(String resource) {
		org.apache.logging.log4j.Logger log4jLogger = LogManager.getLogger(LOGGER_PREFIX + "audit." + resource);
		return new Log4jAuditLogger(new Log4jWrapper(log4jLogger));
	}

	public IPerformanceLogger getPerformanceLogger() {
		org.apache.logging.log4j.Logger log4jLogger = LogManager.getLogger(LOGGER_PREFIX + "performance");
		return new Log4jPerformanceLogger(new Log4jWrapper(log4jLogger));
	}

	public ILogger getDefaultLogger() {
		org.apache.logging.log4j.Logger log4jLogger = LogManager.getLogger(LOGGER_PREFIX + "default");
		return new Log4jLogger(new Log4jWrapper(log4jLogger));
	}

	public ILogger getLogger(String name) {
		return new Log4jLogger(
				new Log4jWrapper(LogManager.getLogger(LOGGER_PREFIX + name)));
	}
}
