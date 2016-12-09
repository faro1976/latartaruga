package it.latartarufa.sensoryturtles.ejb.factory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.xml.internal.ws.message.RelatesToHeader;

import it.framework.core.error.impl.ApplicationErrorService;
import it.framework.core.error.interf.IErrorFormatterService;
import it.framework.core.executor.impl.BaseExecutor;
import it.framework.core.executor.impl.ExecutionId;
import it.framework.core.executor.impl.OperationExecution;
import it.framework.core.executor.interf.IExecutionId;
import it.latartaruga.sensoryturtles.properties.TurtlesProperties;
import it.latartaruga.sensoryturtles.repository.impl.RepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.repository.interf.IRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.service.impl.RelayService;
import it.latartaruga.sensoryturtles.service.impl.RoomService;
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
				null);
		executor = new BaseExecutor(PROPERTIES, operationEvent, errorRepository, executionIdRepository);
		repositoryFactory = new RepositoryFactoryTurtles(getOnlineEm());
	}

	public IRoomService getRoomService() {
		return new RoomService(repositoryFactory, executor);
	}
	
	public IRelayService getRelayService() {
		return new RelayService(repositoryFactory, executor);
	}

	public EntityManager getOnlineEm() {
		return onlineEm;
	}

}
