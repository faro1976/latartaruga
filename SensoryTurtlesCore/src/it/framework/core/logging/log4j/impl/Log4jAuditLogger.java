package it.framework.core.logging.log4j.impl;

import it.framework.core.logging.enums.LevelEnum;
import it.framework.core.logging.interf.IAuditLogger;

public class Log4jAuditLogger implements IAuditLogger {

	private final Log4jWrapper logger;

	public Log4jAuditLogger(Log4jWrapper log4jWrapper) {
		this.logger = log4jWrapper;
	}

	@Override
	public void log(String operationName, String businessId, boolean isSuccess, boolean inTransaction) {
		LogEntry logEntry = new LogEntry();
		logEntry.setOperationId(operationName);
		logEntry.setBusinessId(businessId);
		logEntry.setStatus(isSuccess ? "SUCCESS" : "FAILURE");
		logEntry.setInTransaction(inTransaction);
		logger.log(LevelEnum.INFO, logEntry);
	}

	@Override
	public void log(String operationName, boolean isSuccess) {
		LogEntry logEntry = new LogEntry();
		logEntry.setOperationId(operationName);
		logEntry.setStatus(isSuccess ? "SUCCESS" : "FAILURE");
		logger.log(LevelEnum.INFO, logEntry);
	}

}
