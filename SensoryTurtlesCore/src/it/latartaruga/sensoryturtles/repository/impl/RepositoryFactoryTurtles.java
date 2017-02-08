package it.latartaruga.sensoryturtles.repository.impl;

import javax.persistence.EntityManager;

import it.latartaruga.sensoryturtles.dao.impl.jpa.DAOFactoryTurtlesJPA;
import it.latartaruga.sensoryturtles.repository.interf.IApplicationLogRepository;
import it.latartaruga.sensoryturtles.repository.interf.IControllerRGBRepository;
import it.latartaruga.sensoryturtles.repository.interf.IMultimediaRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRelayRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.repository.interf.IRoomRepository;

public class RepositoryFactoryTurtles implements IRepositoryFactoryTurtles {

	private EntityManager em;

	public RepositoryFactoryTurtles(EntityManager em) {
		this.em = em;
	}

	@Override
	public IMultimediaRepository getMultimediaRepository() {
		return new MultimediaRepository(new DAOFactoryTurtlesJPA(), em);
	}
	
	@Override
	public IRoomRepository getRoomRepository() {
		return new  RoomRepository(new DAOFactoryTurtlesJPA(), em);
	}

	@Override
	public IRelayRepository getRelayRepository() {
		return new  RelayRepository(new DAOFactoryTurtlesJPA(), em);
	}

		
	@Override
	public IControllerRGBRepository getControllerRGBRepository() {
		return new ControllerRGBRepository(new DAOFactoryTurtlesJPA(), em);
	}

	@Override
	public IApplicationLogRepository getApplicationLogRepository() {
		return new ApplicationLogRepository(new DAOFactoryTurtlesJPA(), em);
	}



}
