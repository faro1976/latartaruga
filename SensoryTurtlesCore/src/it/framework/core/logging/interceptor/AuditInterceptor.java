package it.framework.core.logging.interceptor;

import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import it.framework.core.logging.annotation.Audit;
import it.framework.core.logging.impl.LoggerFactory;
import it.framework.core.logging.interf.IAuditLogger;


@Priority(Interceptor.Priority.APPLICATION)
@Dependent
@Audit
@Interceptor
public class AuditInterceptor extends BaseInterceptor {
	private static IAuditLogger ologger = LoggerFactory.getAuditLogger("interceptor.AuditInterceptor");

	@AroundInvoke
	public Object logAudit(InvocationContext invocationContext) throws Exception {
		boolean isSuccess = false;
		try {
			Object res = invocationContext.proceed();
			isSuccess = true;
			return res;
		} finally {
			Method method = invocationContext.getMethod();
			Audit audit = method.getAnnotation(Audit.class);
			String operation = audit.operation();
			if ("".equals(operation)) {
				operation = getOperationFromMethod(method);
			}
			ologger.log(operation, isSuccess);
		}
	}
}
