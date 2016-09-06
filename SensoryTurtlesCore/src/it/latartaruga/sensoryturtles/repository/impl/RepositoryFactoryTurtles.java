package it.latartaruga.sensoryturtles.repository.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import it.latartaruga.sensoryturtles.dao.impl.jpa.DAOFactoryTurtlesJPA;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;

public class RepositoryFactoryTurtles implements IRepositoryFactoryTurtles {

	private EntityManager em;

	
	public RepositoryFactoryTurtles(EntityManager em) {
		this.em = em;
	}

	@Override
	public RoomRepository getRoomRepository() {
		return new  RoomRepository(new DAOFactoryTurtlesJPA(), em);
	}

	

}
