package it.framework.core.logging.log4j.impl;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Level;

import it.framework.core.logging.enums.LevelEnum;
import it.framework.core.logging.interf.IPerformanceLogger;


public class Log4jPerformanceLogger implements IPerformanceLogger {

	private Log4jWrapper log4jWrapper;

	public Log4jPerformanceLogger(Log4jWrapper log4jWrapper) {
		this.log4jWrapper = log4jWrapper;
	}

	@Override
	public void log(String operation, long duration) {
		LogEntry logEntry = new LogEntry();
		logEntry.setOperationId(operation);
		logEntry.setDuration(duration);
		log4jWrapper.log(LevelEnum.INFO, logEntry);
	}

	@Override
	public void log(String operation, Method method, long duration) {
		LogEntry logEntry = new LogEntry();
		logEntry.setOperationId(operation);
		logEntry.setMethod(method);
		logEntry.setDuration(duration);
		log4jWrapper.log(LevelEnum.INFO, logEntry);
	}

	@Override
	public void log(Method method, Object[] parameters, long duration) {
		LogEntry logEntry = new LogEntry();
		logEntry.setMethod(method, parameters);
		logEntry.setDuration(duration);
		log4jWrapper.log(LevelEnum.INFO, logEntry);
	}

	@Override
	public void log(String operation, Method method, Object[] parameters, long duration) {
		LogEntry logEntry = new LogEntry();
		logEntry.setOperationId(operation);
		logEntry.setMethod(method, parameters);
		logEntry.setDuration(duration);
		log4jWrapper.log(LevelEnum.INFO, logEntry);
	}

}
