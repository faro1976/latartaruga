package it.framework.core.logging.interf;

import java.util.Map;

import it.framework.core.logging.enums.LevelEnum;

public interface ILogger {
	void log(LevelEnum level, String message);

	void log(LevelEnum level, String message, Map<String, Object> metadata);

	/**
	 * 
	 * @param level
	 * @param message
	 * @param operationId
	 * @param businessId
	 */
	void log(LevelEnum level, String message, String operationId, String businessId);
			
	/**
	 *
	 * @param level
	 * @param message
	 * @param operationId
	 *            se null usa la variabile di contesto
	 * @param businessId
	 *            se null usa la variabile di contesto
	 * @param metadata
	 */
	void log(LevelEnum level, String message, String operationId, String businessId, Map<String, Object> metadata);

	void info(String message);

	void error(String message, Map<String, Object> metadata, Throwable throwable);

	void error(String message, Throwable throwable);
}
