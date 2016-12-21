package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.impl.jpa.JpaDao;
import it.framework.core.dao.interf.IListPager;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceMultimediaDAO;
import it.latartaruga.sensoryturtles.entity.DeviceMultimediaEntity;
import it.latartaruga.sensoryturtles.entity.DeviceMultimediaEntityPK;

public class DeviceMultimediaDAOJPA extends JpaDao<DeviceMultimediaEntity, DeviceMultimediaEntityPK> implements IDeviceMultimediaDAO<DeviceMultimediaEntity, DeviceMultimediaEntityPK>{

	public DeviceMultimediaDAOJPA(EntityManager em, Class<DeviceMultimediaEntity> entityClass) {
		super(em, entityClass);
	}

	@Override
	public IListPager<DeviceMultimediaEntity> findByRoom(IOffset offset,Integer idRoom) {
	
		TypedQuery<DeviceMultimediaEntity> q  = em.createNamedQuery("DeviceMultimediaEntity.findByRoom", DeviceMultimediaEntity.class);
		q.setParameter("idROOMValue", idRoom);
		return  getPager(offset,q);
		
	
	}

}
