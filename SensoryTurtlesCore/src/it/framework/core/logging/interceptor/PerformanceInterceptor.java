package it.framework.core.logging.interceptor;

import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import it.framework.core.logging.annotation.Performance;
import it.framework.core.logging.impl.LoggerFactory;
import it.framework.core.logging.interf.IPerformanceLogger;


@Priority(Interceptor.Priority.APPLICATION)
@Dependent
@Performance
@Interceptor
public class PerformanceInterceptor {

	private static IPerformanceLogger pLogger = LoggerFactory.getPerformanceLogger();

	public PerformanceInterceptor() {
		System.out.println("PerformanceInterceptor");
	}

	@AroundInvoke
	public Object logPerformance(InvocationContext invocationContext) throws Exception {
		long startTime = System.currentTimeMillis();
		Object res = invocationContext.proceed();
		long stopTime = System.currentTimeMillis();

		long elapsedTime = stopTime - startTime;
		Method method = invocationContext.getMethod();
		Performance performanceAnnotation = method.getAnnotation(Performance.class);
		String operation = performanceAnnotation != null ? performanceAnnotation.operation() : "";
		if (!"".equals(operation)) {
			pLogger.log(operation, method, invocationContext.getParameters(), elapsedTime);
		} else {
			pLogger.log(method, invocationContext.getParameters(), elapsedTime);
		}
		return res;
	}
}