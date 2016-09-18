package it.framework.core.logging.interceptor;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import it.framework.core.logging.annotation.Trace;
import it.framework.core.logging.enums.LevelEnum;
import it.framework.core.logging.impl.LoggerFactory;
import it.framework.core.logging.interf.ILogger;


@Priority(Interceptor.Priority.APPLICATION)
@Dependent
@Trace
@Interceptor
public class TraceInterceptor extends BaseInterceptor {

	private static ILogger logger = LoggerFactory.getLogger("interceptor.TraceInterceptor");

	@AroundInvoke
	public Object logTrace(InvocationContext invocationContext) throws Exception {
		String message = getOperationFromMethod(invocationContext.getMethod()) + invocationContext.getParameters();
		logger.log(LevelEnum.INFO, message);
		return invocationContext.proceed();
	}
}
