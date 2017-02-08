package it.latartaruga.sensoryturtles.dao.test;

import javax.persistence.EntityManager;

import it.framework.test.dao.impl.TestDaoFactory;
import it.framework.test.dao.impl.TestProperties;
import it.latartaruga.sensoryturtles.dao.impl.jpa.DeviceRelayDAOJPA;
import it.latartaruga.sensoryturtles.dao.impl.jpa.RoomDAOJPA;
import it.latartaruga.sensoryturtles.dao.interf.IApplicationLogDAO;
import it.latartaruga.sensoryturtles.dao.interf.IDAOFactoryTurtles;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceControllerRGBDAO;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceMultimediaDAO;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceRelayDAO;
import it.latartaruga.sensoryturtles.dao.interf.IRoomDAO;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;
import it.latartaruga.sensoryturtles.entity.RoomEntity;

public class TestDaoFactoryTurtles extends TestDaoFactory  implements IDAOFactoryTurtles {
	
	public TestDaoFactoryTurtles() {
		super( new TestProperties("/SensoryTurtlesTest.properties"));

	}


	@Override
	public IRoomDAO getRoomDAO(EntityManager em) {
		return new RoomDAOJPA(this.em, RoomEntity.class);
	}


	@Override
	public IDeviceRelayDAO getDeviceReleayDAO(EntityManager em) {
		return new DeviceRelayDAOJPA(this.em, DeviceRelayEntity.class);
	}


	@Override
	public IDeviceControllerRGBDAO getDeviceControllerRGBDAO(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IDeviceMultimediaDAO getDeviceMultimediaDAO(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IApplicationLogDAO getApplicationLogDAO(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

}
