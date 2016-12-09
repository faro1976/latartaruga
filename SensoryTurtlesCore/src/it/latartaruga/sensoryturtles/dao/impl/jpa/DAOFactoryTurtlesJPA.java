package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.persistence.EntityManager;

import it.latartaruga.sensoryturtles.dao.interf.IDAOFactoryTurtles;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceRelayDAO;
import it.latartaruga.sensoryturtles.dao.interf.IRoomDAO;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;
import it.latartaruga.sensoryturtles.entity.RoomEntity;

public class DAOFactoryTurtlesJPA implements IDAOFactoryTurtles {

	@Override
	public IRoomDAO getRoomDAO(EntityManager em) {
		return new RoomDAOJPA(em,RoomEntity.class);
	}
	

	@Override
	public IDeviceRelayDAO getDeviceReleayDAO(EntityManager em) {
		return new DeviceRelayDAOJPA(em,DeviceRelayEntity.class);
	}

}
