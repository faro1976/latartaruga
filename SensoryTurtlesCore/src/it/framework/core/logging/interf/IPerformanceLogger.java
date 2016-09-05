package it.framework.core.logging.interf;

import java.lang.reflect.Method;

public interface IPerformanceLogger {
	void log(String operation, long duration);

	void log(String operation, Method method, long duration);

	void log(Method method, Object[] parameters, long duration);

	void log(String operation, Method method, Object[] parameters, long duration);
}
