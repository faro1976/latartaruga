package it.latartaruga.sensoryturtles.dao.interf;

import it.framework.core.dao.interf.IDao;
import it.framework.core.repository.impl.ListPager;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;

public interface IDeviceRelayDAO<E,K> extends IDao<E, K>{
	
	public ListPager<DeviceRelayEntity> findByRoom(Integer idRoom);

}
