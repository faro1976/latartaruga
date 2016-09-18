package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.persistence.EntityManager;

import it.framework.core.dao.impl.jpa.JpaDao;
import it.latartaruga.sensoryturtles.dao.interf.IRoomDAO;
import it.latartaruga.sensoryturtles.entity.RoomEntity;

public class RoomDAOJPA extends JpaDao<RoomEntity, Integer> implements IRoomDAO<RoomEntity, Integer>{

	public RoomDAOJPA(EntityManager em, Class<RoomEntity> entityClass) {
		super(em, entityClass);
	}

}
