package it.latartaruga.sensoryturtles.repository.interf;

import it.framework.core.repository.interf.IRepositoryFactory;

public interface IRepositoryFactoryTurtles extends IRepositoryFactory {
	 IRoomRepository getRoomRepository();
	 IRelayRepository getRelayRepository();
	 IControllerRGBRepository getControllerRGBRepository();
	 IMultimediaRepository getMultimediaRepository();
}
