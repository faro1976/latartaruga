package it.latartaruga.sensoryturtles.repository.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.service.impl.Offset;
import it.framework.test.dao.impl.BaseTest;
import it.framework.test.repository.impl.TestRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.dao.impl.jpa.DAOFactoryTurtlesJPA;
import it.latartaruga.sensoryturtles.dao.test.TestDaoFactoryTurtles;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.impl.RoomRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRoomRepository;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomRepositoryTest extends BaseTest<TestDaoFactoryTurtles,TestRepositoryFactoryTurtles>  {
	
	private IRoomRepository roomRepository;
	private static Room roomPiscina = null; 
	private static Room roomSalaAttesa = null; 
	private static EntityManager em ;
	

	@Override
	protected TestDaoFactoryTurtles getTestDAOFactory() {
		return new TestDaoFactoryTurtles();
	}
	
	@Override
	protected TestRepositoryFactoryTurtles getTestRepositoryFactory() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void inizialize() {
		if (roomPiscina == null)  {
			roomPiscina = new Room();
		}
		if (roomSalaAttesa == null) {
			roomSalaAttesa = new Room(); 
		}
		if (em == null) {
			testDaoFactory.getEm().getTransaction().begin();
			em = testDaoFactory.getEm();
		}
		roomRepository = new RoomRepository(new DAOFactoryTurtlesJPA(), em);
	} 
	
	@Test
	public void AtestCreate() throws Exception {
		try {
			roomPiscina.setCode("01");
			roomPiscina.setDescription("Piscina Interna");
				
			roomPiscina = roomRepository.create(roomPiscina);
							
			Assert.assertTrue(roomPiscina.getIdRoom() != 0);
						
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Test
	public void BtestFind() throws Exception {
		try {
								
			Room roomFind = roomRepository.find(roomPiscina.getIdRoom());
								
			Assert.assertTrue(roomFind.getIdRoom() == roomPiscina.getIdRoom());
			Assert.assertTrue(roomFind.getCode() == roomPiscina.getCode());
			Assert.assertTrue(roomFind.getDescription() == roomPiscina.getDescription());
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Test
	public void CtestReplace() throws Exception {
		try {
			
			roomPiscina.setDescription(roomPiscina.getDescription() + " AGGIORNATA");
			
			roomRepository.replace(roomPiscina);
						
			Room roomFind = roomRepository.find(roomPiscina.getIdRoom());
			Assert.assertTrue(roomFind.getDescription().equals(roomPiscina.getDescription()));
					
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void DtestCreate2() throws Exception {
		try {
			
			roomSalaAttesa.setCode("02");
			roomSalaAttesa.setDescription("Sala Attesa");
			
			roomRepository.create(roomSalaAttesa);
								
			Assert.assertTrue(roomSalaAttesa.getIdRoom() != 0);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	
	@Test
	public void EtestFindAll() throws Exception {
		try {
			
			List<? extends Room> listRooms = roomRepository.findAll();
			Assert.assertTrue(listRooms.size() != 0);
						
			listRooms.forEach(room-> {
				Assert.assertTrue(room.getIdRoom() == roomPiscina.getIdRoom() || room.getIdRoom() == roomSalaAttesa.getIdRoom());
				Assert.assertTrue(room.getCode().equals(roomPiscina.getCode()) || room.getCode().equals(roomSalaAttesa.getCode()));
				Assert.assertTrue(room.getDescription().equals(roomPiscina.getDescription()) || room.getDescription().equals(roomSalaAttesa.getDescription()));
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void FtestFindAllPaged() throws Exception {
		try {
			IOffset offset = new Offset(0,Integer.MAX_VALUE);
			IListPager<? extends Room> listRooms = roomRepository.findAllPaged(offset);
			Assert.assertTrue(listRooms.getTotalCount() != 0);
						
			listRooms.getResult().forEach(room-> {
				Assert.assertTrue(room.getIdRoom() == roomPiscina.getIdRoom() || room.getIdRoom() == roomSalaAttesa.getIdRoom());
				Assert.assertTrue(room.getCode().equals(roomPiscina.getCode()) || room.getCode().equals(roomSalaAttesa.getCode()));
				Assert.assertTrue(room.getDescription().equals(roomPiscina.getDescription()) || room.getDescription().equals(roomSalaAttesa.getDescription()));
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	@Test
	public void GtestDelete() throws Exception {
		try {
											
			roomRepository.delete(roomPiscina);
			roomRepository.delete(roomSalaAttesa);
			em.flush();
			em.getTransaction().rollback();
						
			List<? extends Room> listRooms = roomRepository.findAll();
			
			Assert.assertTrue(listRooms.size() == 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}






}
