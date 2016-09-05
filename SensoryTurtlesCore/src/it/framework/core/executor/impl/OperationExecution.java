package it.framework.core.executor.impl;

import javax.resource.spi.work.ExecutionContext;

import it.framework.client.service.inferf.IExecutionContext;
import it.framework.core.executor.interf.IOperation;
import it.framework.core.logging.interf.IExecutionLogContext;

public class OperationExecution {
	
	private IOperation<?> operation;
	// risultato di un'operazione non transazionale
	private boolean isSuccess;
	// evita di loggare più volte se non si è in transazione
	private boolean isLogged;
	// necessario per capire se siamo in transazione o meno
	private boolean executing;
	private IExecutionContext executionContext;

	public OperationExecution(IOperation<?> operation, IExecutionContext executionContext) {
		this.operation = operation;
		this.executionContext = executionContext;
	}

	public boolean isExecuting() {
		return executing;
	}

	public IOperation<?> getOperation() {
		return operation;
	}

	public IExecutionContext getExecutionContext() {
		return executionContext;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLoggd) {
		this.isLogged = isLoggd;
	}

	public void setExecuting(boolean executing) {
		this.executing = executing;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
