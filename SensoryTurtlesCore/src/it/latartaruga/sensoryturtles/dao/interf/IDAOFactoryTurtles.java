package it.latartaruga.sensoryturtles.dao.interf;

import javax.persistence.EntityManager;

import it.framework.core.dao.interf.IDAOFactory;

public interface IDAOFactoryTurtles extends IDAOFactory {
	
	IRoomDAO getRoomDAO(EntityManager em);
	
}
