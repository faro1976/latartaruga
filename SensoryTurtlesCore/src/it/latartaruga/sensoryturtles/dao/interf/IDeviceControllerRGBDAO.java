package it.latartaruga.sensoryturtles.dao.interf;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IDao;
import it.framework.core.dao.interf.IListPager;
import it.latartaruga.sensoryturtles.entity.DeviceControllerRgbEntity;

public interface IDeviceControllerRGBDAO<E,K> extends IDao<E, K>{
	
	public IListPager<DeviceControllerRgbEntity> findByRoom(IOffset offset,Integer idRoom);

}
