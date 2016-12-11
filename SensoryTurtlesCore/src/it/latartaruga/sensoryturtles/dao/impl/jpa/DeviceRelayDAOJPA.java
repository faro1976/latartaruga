package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.persistence.EntityManager;

import it.framework.core.dao.impl.jpa.JpaDao;
import it.framework.core.repository.impl.ListPager;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceRelayDAO;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntityPK;

public class DeviceRelayDAOJPA extends JpaDao<DeviceRelayEntity, DeviceRelayEntityPK> implements IDeviceRelayDAO<DeviceRelayEntity, DeviceRelayEntityPK>{

	public DeviceRelayDAOJPA(EntityManager em, Class<DeviceRelayEntity> entityClass) {
		super(em, entityClass);
	}

	@Override
	public ListPager<DeviceRelayEntity> findByRoom(Integer idRoom) {
		return (ListPager<DeviceRelayEntity>) getPager(r -> getCriteriaBuilder().lessThan(r.get("id.idROOM"), idRoom));
	
	}

}
