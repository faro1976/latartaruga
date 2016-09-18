package it.latartaruga.sensoryturtles.service.test;

import java.util.List;

import javax.enterprise.event.Event;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.framework.client.service.impl.PagedRequest;
import it.framework.client.service.impl.RequestContext;
import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.IPagedRequest;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IRequestContext;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.error.impl.ApplicationErrorService;
import it.framework.core.error.interf.IErrorFormatterService;
import it.framework.core.executor.impl.BaseExecutor;
import it.framework.core.executor.impl.ExecutionId;
import it.framework.core.executor.impl.OperationExecution;
import it.framework.core.executor.impl.BaseExecutor.CoreExecutorParameters;
import it.framework.core.executor.interf.IExecutionId;
import it.framework.core.repository.interf.IErrorRepository;
import it.framework.core.service.impl.Offset;
import it.framework.test.dao.impl.BaseTest;
import it.framework.test.repository.impl.TestRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.dao.impl.jpa.DAOFactoryTurtlesJPA;
import it.latartaruga.sensoryturtles.dao.test.TestDaoFactoryTurtles;
import it.latartaruga.sensoryturtles.entity.RoomEntity;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.properties.TurtlesProperties;
import it.latartaruga.sensoryturtles.repository.impl.RoomRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRoomRepository;
import it.latartaruga.sensoryturtles.service.impl.RoomService;
import it.latartaruga.sensoryturtles.service.interf.IRoomService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomServiceTest extends BaseTest<TestDaoFactoryTurtles,TestRepositoryFactoryTurtles>  {
	
	private static final TurtlesProperties PROPERTIES = new TurtlesProperties();
	private IRoomService roomService;
	private static EntityManager em ;
	

	@Override
	protected TestDaoFactoryTurtles getTestDAOFactory() {
		return new TestDaoFactoryTurtles();
	}
	
	@Override
	protected TestRepositoryFactoryTurtles getTestRepositoryFactory() {
		return new TestRepositoryFactoryTurtles();
	}


	@Override
	protected void inizialize() {
		if (em == null) {
			testDaoFactory.getEm().getTransaction().begin();
			em = testDaoFactory.getEm();
		}
		IExecutionId executionIdRepository = new ExecutionId();
		IErrorFormatterService errorFormatterService = null;
		Event<OperationExecution> operationEvent = null;
		ApplicationErrorService errorRepository = new ApplicationErrorService(
				PROPERTIES.getApplicationId(),
				PROPERTIES.getErrorSource(),
				errorFormatterService);
		roomService = new RoomService(getTestRepositoryFactory(),new BaseExecutor(PROPERTIES,operationEvent,errorRepository,executionIdRepository));
	} 
	
	@Test
	public void AtestRicercaRooms() throws Exception {
		try {
			IRequestContext requestContext = new RequestContext("JUNIT", null, null, "1", null);
			IOffset offset = new Offset(0, Integer.MAX_VALUE);
			IPagedRequest<String> pagedRequest = new PagedRequest(requestContext,offset,null,null);
			IPagedResponse<List<? extends Room>> pagedResponse = roomService.ricercaRooms(pagedRequest);
									
			Assert.assertTrue(pagedResponse.getTotalCount() != 0);
			
			Assert.assertTrue(pagedResponse.getTotalCount()==pagedResponse.getResult().size());
			
			pagedResponse.getResult().forEach(room-> {
				System.out.println("ID:" + room.getIdRoom() + " CODE:" + room.getCode() + " DESCRIPTION:" +  room.getDescription());
			});

						
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
}
