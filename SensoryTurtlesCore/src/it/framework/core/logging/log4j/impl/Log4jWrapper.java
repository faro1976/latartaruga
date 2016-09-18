package it.framework.core.logging.log4j.impl;

import org.apache.logging.log4j.Logger;

import it.framework.core.logging.enums.LevelEnum;

public class Log4jWrapper {

	private Logger logger;

	public Log4jWrapper(Logger logger) {
		this.logger = logger;
	}

	public void log(LevelEnum level, LogEntry logEntry) {
		org.apache.logging.log4j.Level log4jLevel;
		switch (level) {
		case FATAL:
			log4jLevel = org.apache.logging.log4j.Level.FATAL;
			break;
		case ERROR:
			log4jLevel = org.apache.logging.log4j.Level.ERROR;
			break;
		case WARN:
			log4jLevel = org.apache.logging.log4j.Level.WARN;
			break;
		case INFO:
			log4jLevel = org.apache.logging.log4j.Level.INFO;
			break;
		case DEBUG:
			log4jLevel = org.apache.logging.log4j.Level.DEBUG;
			break;
		case TRACE:
			log4jLevel = org.apache.logging.log4j.Level.TRACE;
			break;
		default:
			throw new FrameworkLoggingLog4jRuntimeExcpetion("Livello di log non previsto " + level);
		}
		logEntry.log(logger, log4jLevel);
	}
}
