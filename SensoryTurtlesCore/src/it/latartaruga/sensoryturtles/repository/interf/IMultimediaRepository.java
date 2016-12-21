package it.latartaruga.sensoryturtles.repository.interf;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.repository.interf.IRepository;
import it.latartaruga.sensoryturtles.model.DeviceKey;
import it.latartaruga.sensoryturtles.model.Multimedia;

public interface IMultimediaRepository extends IRepository<Multimedia, DeviceKey> {
	
	IListPager<? extends Multimedia> findByRoom(IOffset offset,Integer idRoom);
	

}
