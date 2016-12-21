package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.impl.jpa.JpaDao;
import it.framework.core.dao.interf.IListPager;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceRelayDAO;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntityPK;

public class DeviceRelayDAOJPA extends JpaDao<DeviceRelayEntity, DeviceRelayEntityPK> implements IDeviceRelayDAO<DeviceRelayEntity, DeviceRelayEntityPK>{

	public DeviceRelayDAOJPA(EntityManager em, Class<DeviceRelayEntity> entityClass) {
		super(em, entityClass);
	}

	@Override
	public IListPager<DeviceRelayEntity> findByRoom(IOffset offset,Integer idRoom) {
	
		TypedQuery<DeviceRelayEntity> q  = em.createNamedQuery("DeviceRelayEntity.findByRoom", DeviceRelayEntity.class);
		q.setParameter("idROOMValue", idRoom);
		return  getPager(offset,q);
		
	
	}

}
