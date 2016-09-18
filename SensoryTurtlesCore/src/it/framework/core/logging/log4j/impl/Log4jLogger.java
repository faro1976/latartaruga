package it.framework.core.logging.log4j.impl;

import java.util.Map;

import it.framework.core.logging.enums.LevelEnum;
import it.framework.core.logging.interf.ILogger;


public class Log4jLogger implements ILogger {

	private Log4jWrapper log4jWrapper;

	public Log4jLogger(Log4jWrapper log4jWrapper) {
		this.log4jWrapper = log4jWrapper;
	}

	@Override
	public void log(LevelEnum level, String message) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMessage(message);
		log4jWrapper.log(level, logEntry);
	}

	@Override
	public void log(LevelEnum level, String message, Map<String, Object> metadata) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMessage(message);
		logEntry.setMetadata(metadata);
		log4jWrapper.log(level, logEntry);
	}
	
	@Override
	public void log(LevelEnum level, String message, String operationId, String businessId) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMessage(message);
		logEntry.setOperationId(operationId);
		logEntry.setBusinessId(businessId);		
		log4jWrapper.log(level, logEntry);
	}

	@Override
	public void log(LevelEnum level, String message, String operationId, String businessId, Map<String, Object> metadata) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMessage(message);
		logEntry.setOperationId(operationId);
		logEntry.setBusinessId(businessId);
		logEntry.setMetadata(metadata);
		log4jWrapper.log(level, logEntry);
	}

	@Override
	public void info(String message) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMessage(message);
		log4jWrapper.log(LevelEnum.INFO, logEntry);
	}

	@Override
	public void error(String message, Map<String, Object> metadata, Throwable throwable) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMessage(message);
		logEntry.setMetadata(metadata);
		logEntry.setThrowable(throwable);
		log4jWrapper.log(LevelEnum.ERROR, logEntry);
	}

	@Override
	public void error(String message, Throwable throwable) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMessage(message);
		logEntry.setThrowable(throwable);
		log4jWrapper.log(LevelEnum.ERROR, logEntry);
	}

}
