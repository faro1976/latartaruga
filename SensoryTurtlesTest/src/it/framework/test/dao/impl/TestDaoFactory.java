package it.framework.test.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import it.framework.test.dao.interf.ITestFacotryDAO;

public  class TestDaoFactory implements ITestFacotryDAO{
	
	protected EntityManager em;



	private EntityManagerFactory entityManagerFactory;
	private TestProperties testProperties = null;

		
	public TestDaoFactory(TestProperties testProperties) {
		super();
		this.testProperties = testProperties;
		em = newEntityManager();
	}

	
	protected EntityManager newEntityManager() {
		if (entityManagerFactory == null) {
			try {
				Map<String, String> props = new HashMap<String, String>();
				props.put(PersistenceUnitProperties.TRANSACTION_TYPE, "RESOURCE_LOCAL");
				props.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
				props.put("javax.persistence.jdbc.url", testProperties.getJdbcUrl());
				props.put("javax.persistence.jdbc.user", testProperties.getJdbcUser());
				props.put("javax.persistence.jdbc.password", testProperties.getJdbcPassword());
				entityManagerFactory = Persistence.createEntityManagerFactory("SensoryTurtlesJPA", props);
			} catch (Exception e) {
				e.printStackTrace();
				throw new TestRuntimeException(e);
			}
		}
		return entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEm() {
		return em;
	}
	


}
