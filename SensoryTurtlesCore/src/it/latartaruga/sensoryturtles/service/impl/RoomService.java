package it.latartaruga.sensoryturtles.service.impl;

import java.util.List;

import it.framework.client.service.impl.OperationException;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IRequestParameter;
import it.framework.client.service.inferf.IResponse;
import it.framework.core.dao.interf.IPager;
import it.framework.core.executor.impl.BusinessInquiryOperation;
import it.framework.core.executor.impl.PagedOperation;
import it.framework.core.executor.interf.IOperationExecutor;
import it.framework.core.service.impl.BusinessService;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.repository.interf.IRoomRepository;
import it.latartaruga.sensoryturtles.service.interf.IRoomService;

public class RoomService extends BusinessService implements IRoomService{
	
	private IRoomRepository roomRepository = null;
	
		
	public RoomService(IRepositoryFactoryTurtles repositoryFactory, IOperationExecutor executor) {
		super(executor);
		this.roomRepository = repositoryFactory.getRoomRepository();
	}

	@Override
	public IPagedResponse<List<? extends Room>> ricercaRooms(IPagedRequest<String> request) throws ServiceException {
			return invoke( new PagedOperation<String, List<? extends Room>>(request, "ricercaRooms") {
					@Override
					public String getBusinessId() {
						return Room.class.getSimpleName() + " " + request.getParameter();
					}

					@Override
					protected IPager<? extends List<? extends Room>> getPager(IOffset offset,String paraam) {
						return roomRepository.findAllPaged(offset);
					}
				});
	}
	
	@Override
	public IResponse<Room> ricercaRoom(IRequestParameter<Integer> request) throws ServiceException {

		return invoke ( new BusinessInquiryOperation<Integer, Room>(request,"ricarcaRoom") {
		
			@Override
			public String getBusinessId() {
				return Room.class.getSimpleName() + " " + request.getParameter();
			}

			@Override
			protected Room doPerform(Integer param) throws OperationException {
				return roomRepository.find(param);
			}
		});
		
	}
		


}
