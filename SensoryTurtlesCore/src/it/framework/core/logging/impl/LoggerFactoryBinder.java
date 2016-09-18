package it.framework.core.logging.impl;

import it.framework.core.logging.interf.ILoggerManager;
import it.framework.core.logging.log4j.impl.Log4jLoggerManager;



public class LoggerFactoryBinder {

	private static ILoggerManager instanceLog4j = new Log4jLoggerManager();

	public static ILoggerManager getSingletonLog4J() {
		return instanceLog4j;
	}

}
