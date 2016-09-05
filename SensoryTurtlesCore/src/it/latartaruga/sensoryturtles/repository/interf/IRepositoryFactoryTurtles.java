package it.latartaruga.sensoryturtles.repository.interf;

import it.framework.core.repository.interf.IRepositoryFactory;
import it.latartaruga.sensoryturtles.repository.impl.RoomRepository;

public interface IRepositoryFactoryTurtles extends IRepositoryFactory {
	RoomRepository getRoomRepository();
}
