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
import it.latartaruga.sensoryturtles.model.Relay;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IRelayRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.service.interf.IRelayService;

public class RelayService extends BusinessService implements IRelayService{
	
	private IRelayRepository relayRepository= null;
	
		
	public RelayService(IRepositoryFactoryTurtles repositoryFactory, IOperationExecutor executor) {
		super(executor);
		this.relayRepository = repositoryFactory.getRelayRepository();
	}


	@Override
	public IPagedResponse<List<? extends Relay>> ricercaRelaysByRoom(IPagedRequest<Integer> request) throws ServiceException {
		return invoke( new PagedOperation<Integer, List<? extends Relay>>(request, "ricercaRelaysByRoom") {
			@Override
			public String getBusinessId() {
				return Room.class.getSimpleName() + " " + request.getParameter();
			}

			@Override
			protected IPager<? extends List<? extends Relay>> getPager(IOffset offset,Integer paraam) {
				return relayRepository.findByRoom(offset, paraam);
			}
		});
	}
	
}
