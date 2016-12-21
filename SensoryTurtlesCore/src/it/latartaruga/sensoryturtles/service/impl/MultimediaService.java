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
import it.latartaruga.sensoryturtles.model.Multimedia;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IMultimediaRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.service.interf.IMultimediaService;

public class MultimediaService extends BusinessService implements IMultimediaService{
	
	private IMultimediaRepository multimediaRepository= null;
	
		
	public MultimediaService(IRepositoryFactoryTurtles repositoryFactory, IOperationExecutor executor) {
		super(executor);
		this.multimediaRepository = repositoryFactory.getMultimediaRepository();
	}


	@Override
	public IPagedResponse<List<? extends Multimedia>> ricercaMultimediaByRoom(IPagedRequest<Integer> request) throws ServiceException {
		return invoke( new PagedOperation<Integer, List<? extends Multimedia>>(request, "ricercaMultimediaByRoom") {
			@Override
			public String getBusinessId() {
				return Room.class.getSimpleName() + " " + request.getParameter();
			}

			@Override
			protected IPager<? extends List<? extends Multimedia>> getPager(IOffset offset,Integer paraam) {
				return multimediaRepository.findByRoom(offset, paraam);
			}
		});
	}
	
}
