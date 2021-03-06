package it.latartarufa.sensoryturtles.ejb.factory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.framework.core.error.impl.ApplicationErrorService;
import it.framework.core.error.impl.ErrorFormatterServiceImpl;
import it.framework.core.error.impl.ErrorRepository;
import it.framework.core.executor.impl.BaseExecutor;
import it.framework.core.executor.impl.ExecutionId;
import it.framework.core.executor.impl.OperationExecution;
import it.framework.core.executor.interf.IExecutionId;
import it.latartaruga.sensoryturtles.properties.TurtlesProperties;
import it.latartaruga.sensoryturtles.repository.impl.RepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.service.impl.ApplicationLogService;
import it.latartaruga.sensoryturtles.service.impl.ControllerRGBService;
import it.latartaruga.sensoryturtles.service.impl.MultimediaService;
import it.latartaruga.sensoryturtles.service.impl.RelayService;
import it.latartaruga.sensoryturtles.service.impl.RoomService;
import it.latartaruga.sensoryturtles.service.interf.IApplicationLogService;
import it.latartaruga.sensoryturtles.service.interf.IControllerRGBService;
import it.latartaruga.sensoryturtles.service.interf.IMultimediaService;
import it.latartaruga.sensoryturtles.service.interf.IRelayService;
import it.latartaruga.sensoryturtles.service.interf.IRoomService;

@Dependent
public class ServiceFactoryTurtles {

	private static final TurtlesProperties PROPERTIES = new TurtlesProperties();

	private BaseExecutor executor;

	
	@PersistenceContext(unitName = "SensoryTurtlesJPA")
	private EntityManager onlineEm;

	
	private RepositoryFactoryTurtles repositoryFactory;

	@Inject
	@Any
	private Event<OperationExecution> operationEvent;

	//@EJB
	//private IErrorFormatterService errorFormatterService;

	@PostConstruct
	private void init() {
		
		//executionIdRepository executionIdRepository = new WeblogicExecutionIdRepository();
		IExecutionId executionIdRepository = new ExecutionId();
		ApplicationErrorService errorRepository = new ApplicationErrorService(
				PROPERTIES.getApplicationId(),
				PROPERTIES.getErrorSource(),
				new ErrorFormatterServiceImpl(new ErrorRepository()));
		executor = new BaseExecutor(PROPERTIES, operationEvent, errorRepository, executionIdRepository);
		repositoryFactory = new RepositoryFactoryTurtles(getOnlineEm());
	}

	public EntityManager getOnlineEm() {
		return onlineEm;
	}
	
	public IRoomService getRoomService() {
		return new RoomService(repositoryFactory, executor);
	}
	
	public IRelayService getRelayService() {
		return new RelayService(repositoryFactory, executor);
	}
	
	public IControllerRGBService getControllerRGBService() {
		return new ControllerRGBService(repositoryFactory, executor);
	}
	
	public IMultimediaService getMultimediaService() {
		return new MultimediaService(repositoryFactory, executor);
	}

	public IApplicationLogService getApplicationLogService() {
		return new ApplicationLogService(repositoryFactory, executor);
	}
	
	

}
