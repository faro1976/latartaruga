package it.framework.core.executor.interf;

/**
 * Repository usato per ottenere l'execution id da usare nel logging e nel
 * baseFault di risposta in caso d'errore
 *
 */
public interface IExecutionId {
	String getExecutionId();
}
