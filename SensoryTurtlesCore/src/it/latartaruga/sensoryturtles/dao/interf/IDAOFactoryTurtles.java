package it.latartaruga.sensoryturtles.dao.interf;

import javax.persistence.EntityManager;

import it.framework.core.dao.interf.IDAOFactory;

public interface IDAOFactoryTurtles extends IDAOFactory {
	
	public IRoomDAO getRoomDAO(EntityManager em);
	public IDeviceRelayDAO getDeviceReleayDAO(EntityManager em);
	public IDeviceControllerRGBDAO getDeviceControllerRGBDAO(EntityManager em);
	public IDeviceMultimediaDAO getDeviceMultimediaDAO(EntityManager em);
	
}
