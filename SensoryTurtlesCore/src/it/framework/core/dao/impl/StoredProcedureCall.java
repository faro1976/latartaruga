package it.framework.core.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class StoredProcedureCall {

	private StoredProcedureQuery query;
	private boolean executed;

	public StoredProcedureCall(EntityManager em, String procedureName) {
		this.query = em.createStoredProcedureQuery(procedureName);
	}

	public StoredProcedureCall(StoredProcedureQuery query) {
		this.query = query;
	}

	public void setString(String parameterName, String value) {
		query.registerStoredProcedureParameter(parameterName, String.class, ParameterMode.IN);
		query.setParameter(parameterName, value);
	}

	public void setDate(String parameterName, Date value) {
		query.registerStoredProcedureParameter(parameterName, Date.class, ParameterMode.IN);
		query.setParameter(parameterName, value);
	}

	public void setCharacter(String parameterName, Character value) {
		query.registerStoredProcedureParameter(parameterName, Character.class, ParameterMode.IN);
		query.setParameter(parameterName, value);
	}

	public void setLong(String parameterName, Long value) {
		query.registerStoredProcedureParameter(parameterName, Long.class, ParameterMode.IN);
		query.setParameter(parameterName, value);
	}
	
	public long getLong(String outParameterName) {
		executeProcedure();
		Object res = query.getOutputParameterValue(outParameterName);
		if (res instanceof Integer) {
			return (int) res;
		}
		return (long) res;
	}

	public String getString(String outParameterName) {
		executeProcedure();
		return (String) query.getOutputParameterValue(outParameterName);
	}

	private void executeProcedure() {
		if (!executed) {
			query.execute();
			executed = true;
		}
	}

	public boolean execute() {
		executed = true;
		return query.execute();
	}

	public int executeUpdate() {
		executed = true;
		return query.executeUpdate();
	}

	public void registerOutLong(String outParameterName) {
		query.registerStoredProcedureParameter(outParameterName, Long.class, ParameterMode.OUT);
	}

	public void registerOutString(String outParameterName) {
		query.registerStoredProcedureParameter(outParameterName, String.class, ParameterMode.OUT);
	}

	public void registerOutCharacter(String outParameterName) {
		query.registerStoredProcedureParameter(outParameterName, Character.class, ParameterMode.OUT);
	}

}