package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.impl.jpa.JpaDao;
import it.framework.core.dao.interf.IListPager;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceControllerRGBDAO;
import it.latartaruga.sensoryturtles.entity.DeviceControllerRgbEntity;
import it.latartaruga.sensoryturtles.entity.DeviceControllerRgbEntityPK;

public class DeviceControllerRGBDAOJPA extends JpaDao<DeviceControllerRgbEntity, DeviceControllerRgbEntityPK> implements IDeviceControllerRGBDAO<DeviceControllerRgbEntity, DeviceControllerRgbEntityPK>{

	public DeviceControllerRGBDAOJPA(EntityManager em, Class<DeviceControllerRgbEntity> entityClass) {
		super(em, entityClass);
	}

	@Override
	public IListPager<DeviceControllerRgbEntity> findByRoom(IOffset offset,Integer idRoom) {
	
		TypedQuery<DeviceControllerRgbEntity> q  = em.createNamedQuery("DeviceControllerRgbEntity.findByRoom", DeviceControllerRgbEntity.class);
		q.setParameter("idROOMValue", idRoom);
		return  getPager(offset,q);
		
	
	}

}
