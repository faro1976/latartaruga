package it.framework.core.executor.impl;

import it.framework.core.executor.interf.IExecutionId;

/**
 * Consente di ottenere lo stesso ExecutionId usato nei log di weblogic
 *
 */
public class ExecutionId implements IExecutionId {

	@Override
	public String getExecutionId() {
		return "DA RECUPERARE";
	}

}
