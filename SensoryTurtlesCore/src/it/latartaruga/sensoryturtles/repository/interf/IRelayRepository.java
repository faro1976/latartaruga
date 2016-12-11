package it.latartaruga.sensoryturtles.repository.interf;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.repository.interf.IRepository;
import it.latartaruga.sensoryturtles.model.DeviceKey;
import it.latartaruga.sensoryturtles.model.Relay;

public interface IRelayRepository extends IRepository<Relay, DeviceKey> {
	
	IListPager<? extends Relay> findByRoom(IOffset offset,Integer idRoom);
	

}
