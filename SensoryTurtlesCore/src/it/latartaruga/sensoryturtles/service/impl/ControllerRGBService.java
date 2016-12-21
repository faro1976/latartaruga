package it.latartaruga.sensoryturtles.service.impl;

import java.util.List;

import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.core.dao.interf.IPager;
import it.framework.core.executor.impl.PagedOperation;
import it.framework.core.executor.interf.IOperationExecutor;
import it.framework.core.service.impl.BusinessService;
import it.latartaruga.sensoryturtles.model.ControllerRGB;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IControllerRGBRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.service.interf.IControllerRGBService;

public class ControllerRGBService extends BusinessService implements IControllerRGBService{
	
	private IControllerRGBRepository controllerRGBRepository= null;
	
		
	public ControllerRGBService(IRepositoryFactoryTurtles repositoryFactory, IOperationExecutor executor) {
		super(executor);
		this.controllerRGBRepository = repositoryFactory.getControllerRGBRepository();
	}


	@Override
	public IPagedResponse<List<? extends ControllerRGB>> ricercaControllerRGBByRoom(IPagedRequest<Integer> request) throws ServiceException {
		return invoke( new PagedOperation<Integer, List<? extends ControllerRGB>>(request, "ricercaControllerRGBByRoom") {
			@Override
			public String getBusinessId() {
				return Room.class.getSimpleName() + " " + request.getParameter();
			}

			@Override
			protected IPager<? extends List<? extends ControllerRGB>> getPager(IOffset offset,Integer paraam) {
				return controllerRGBRepository.findByRoom(offset, paraam);
			}
		});
	}
	
}
