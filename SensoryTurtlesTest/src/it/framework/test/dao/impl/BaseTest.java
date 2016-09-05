package it.framework.test.dao.impl;

import org.junit.Before;

import it.framework.test.dao.interf.ITestFacotryDAO;
import it.framework.test.repository.interf.ITestFacotryRepository;

public abstract class BaseTest <FD extends ITestFacotryDAO, FR extends ITestFacotryRepository>  {

	protected FD testDaoFactory;
	protected FR testRepositoryFactory;
	
	protected abstract FD getTestDAOFactory();
	protected abstract FR getTestRepositoryFactory();
	protected abstract void inizialize();

	@Before
	public void setUp() {
		testDaoFactory =getTestDAOFactory();
		inizialize();
	}
}
