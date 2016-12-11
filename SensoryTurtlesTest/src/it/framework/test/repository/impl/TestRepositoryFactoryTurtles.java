package it.framework.test.repository.impl;

import it.framework.test.repository.interf.ITestFacotryRepository;
import it.latartaruga.sensoryturtles.dao.test.TestDaoFactoryTurtles;
import it.latartaruga.sensoryturtles.repository.impl.RelayRepository;
import it.latartaruga.sensoryturtles.repository.impl.RoomRepository;

public class TestRepositoryFactoryTurtles implements ITestFacotryRepository {
	
	private TestDaoFactoryTurtles testFacotryDAO;

	public TestRepositoryFactoryTurtles() {
		this.testFacotryDAO = new TestDaoFactoryTurtles();
	}

	@Override
	public RoomRepository getRoomRepository() {
		return new  RoomRepository(testFacotryDAO, testFacotryDAO.getEm());
	}

	@Override
	public RelayRepository getRelayRepository() {
		return new  RelayRepository(testFacotryDAO, testFacotryDAO.getEm());
	}

	

}
