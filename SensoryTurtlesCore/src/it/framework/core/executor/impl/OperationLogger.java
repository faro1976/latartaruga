package it.framework.core.executor.impl;

import it.framework.client.service.inferf.IExecutionContext;
import it.framework.core.executor.interf.IDispositiveOperation;
import it.framework.core.executor.interf.IInquiryOperation;
import it.framework.core.executor.interf.IOperation;
import it.framework.core.logging.impl.LoggerFactory;
import it.framework.core.logging.interf.IAuditLogger;

public class OperationLogger {

	private static IAuditLogger ologger = LoggerFactory.getAuditLogger("operation.Generic");
	private static IAuditLogger dologger = LoggerFactory.getAuditLogger("operation.Dispositive");
	private static IAuditLogger iologger = LoggerFactory.getAuditLogger("operation.Inquiry");

	public void log(IOperation<?> operation, IExecutionContext executionContext, boolean isSuccess,
			boolean inTransaction) {
		IAuditLogger logger = ologger;
		if (operation instanceof IDispositiveOperation) {
			logger = dologger;
		} else if (operation instanceof IInquiryOperation) {
			logger = iologger;
		}
		log(logger, operation, executionContext, isSuccess, inTransaction);
	}

	private void log(IAuditLogger logger, IOperation<?> operation, IExecutionContext executionContext, boolean isSuccess,
			boolean inTransaction) {
		logger.log(executionContext.getOperatonId(), operation.getBusinessId(), isSuccess, inTransaction);
	}
}
