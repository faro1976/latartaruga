package it.framework.core.executor.impl;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

@Dependent
public class OperationObserver {
	private static OperationLogger auditLogger = new OperationLogger();

	void logSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS) OperationExecution operationExecution) {
		logFromObserver(operationExecution, true);
	}

	void logFailure(@Observes(during = TransactionPhase.AFTER_FAILURE) OperationExecution operationExecution) {
		logFromObserver(operationExecution, false);
	}

	void logAfterComplete(@Observes(during = TransactionPhase.AFTER_COMPLETION) OperationExecution operationExecution) {
		logFromObserver(operationExecution, false);
	}

	private void logFromObserver(OperationExecution operationExecution, boolean transactionStatus) {
		// necesario per loggare solo una volta, in quanto se non si è in
		// transazione, viene chiamato sia
		// logSuccess che logFailure, inoltre le operazioni fallite già in fase
		// di esecuzione dell'operation sono già state loggate nell'executor
		if (!operationExecution.isLogged()) {
			boolean status;
			// l'evento non è differito, quindi non siamo in transazione
			boolean inTransaction = !operationExecution.isExecuting();
			if (inTransaction) {
				status = transactionStatus;
			} else {
				status = operationExecution.isSuccess();
			}
			log(operationExecution, status, inTransaction);
		}
	}

	public static void log(OperationExecution operationExecution, boolean status, boolean inTransaction) {
		auditLogger.log(operationExecution.getOperation(), operationExecution.getExecutionContext(), status,
				inTransaction);
		operationExecution.setLogged(true);
	}
}
