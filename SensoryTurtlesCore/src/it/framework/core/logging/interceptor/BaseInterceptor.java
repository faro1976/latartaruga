package it.framework.core.logging.interceptor;

import java.lang.reflect.Method;

public class BaseInterceptor {
	protected String getOperationFromMethod(Method method) {
		return method.getDeclaringClass().getName() + "." + method.getName();
	}
}
