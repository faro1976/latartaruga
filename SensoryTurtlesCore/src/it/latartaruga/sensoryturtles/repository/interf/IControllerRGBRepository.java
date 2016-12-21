package it.latartaruga.sensoryturtles.repository.interf;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.repository.interf.IRepository;
import it.latartaruga.sensoryturtles.model.ControllerRGB;
import it.latartaruga.sensoryturtles.model.DeviceKey;

public interface IControllerRGBRepository extends IRepository<ControllerRGB, DeviceKey> {
	
	IListPager<? extends ControllerRGB> findByRoom(IOffset offset,Integer idRoom);
	

}
