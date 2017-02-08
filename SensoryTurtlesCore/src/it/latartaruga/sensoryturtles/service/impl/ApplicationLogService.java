package it.latartaruga.sensoryturtles.service.impl;

import it.framework.client.service.impl.OperationException;
import it.framework.client.service.impl.ServiceException;
import it.framework.client.service.inferf.IRequestParameter;
import it.framework.client.service.inferf.IResponse;
import it.framework.core.executor.impl.BusinessOperation;
import it.framework.core.executor.interf.IOperationExecutor;
import it.framework.core.service.impl.BusinessService;
import it.latartaruga.sensoryturtles.model.ApplicationLog;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IApplicationLogRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.service.interf.IApplicationLogService;

public class ApplicationLogService extends BusinessService implements IApplicationLogService{
	
	private IApplicationLogRepository applicationLogRepository = null;
	
		
	public ApplicationLogService(IRepositoryFactoryTurtles repositoryFactory, IOperationExecutor executor) {
		super(executor);
		this.applicationLogRepository = repositoryFactory.getApplicationLogRepository();
	}


	
	@Override
	public IResponse<ApplicationLog> createLog(IRequestParameter<ApplicationLog> request) throws ServiceException {

		return invoke ( new BusinessOperation<ApplicationLog,ApplicationLog>(request) {

			@Override
			public String getOperationId() {
				return Room.class.getSimpleName() + " " + request.getParameter();
			}

			@Override
			public String getBusinessId() {
				return Room.class.getSimpleName() + " " + request.getParameter();
			}

			@Override
			protected ApplicationLog doPerform(ApplicationLog param) throws OperationException {
				return applicationLogRepository.create(param);
			}


		

		});
		
	}



}
