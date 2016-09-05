package it.latartaruga.sensoryturtles.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.service.impl.Offset;
import it.framework.test.dao.impl.BaseTest;
import it.framework.test.repository.impl.TestRepositoryFactoryTurtles;
import it.latartaruga.sensoryturtles.dao.interf.IRoomDAO;
import it.latartaruga.sensoryturtles.entity.RoomEntity;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomJPADaoTest extends BaseTest<TestDaoFactoryTurtles,TestRepositoryFactoryTurtles>  {
	
	private IRoomDAO<RoomEntity, Integer> roomDAO;
	private static RoomEntity roomEntityPiscina = null; 
	private static RoomEntity roomEntitySalaAttesa = null; 
	

	@Override
	protected TestDaoFactoryTurtles getTestDAOFactory() {
		return new TestDaoFactoryTurtles();
	}

	@Override
	protected TestRepositoryFactoryTurtles getTestRepositoryFactory() {
		return null;
	}


	@Override
	protected void inizialize() {
		if (roomEntityPiscina == null)  {
			roomEntityPiscina = new RoomEntity();
		}
		if (roomEntitySalaAttesa == null) {
			roomEntitySalaAttesa = new RoomEntity(); 
		}
		
	} 
	
	@Test
	public void AtestCreate() throws Exception {
		try {
			roomDAO = testDaoFactory.getRoomDAO(testDaoFactory.getEm());
			roomEntityPiscina.setCode("01");
			roomEntityPiscina.setDescr("Piscina Interna");
			
			testDaoFactory.getEm().getTransaction().begin();
			roomDAO.persist(roomEntityPiscina);
			testDaoFactory.getEm().flush();
						
			Assert.assertTrue(roomEntityPiscina.getIdROOM() != 0);
			
			testDaoFactory.getEm().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Test
	public void BtestFind() throws Exception {
		try {
			roomDAO = testDaoFactory.getRoomDAO(testDaoFactory.getEm());
					
			RoomEntity roomEntityFind = roomDAO.find(roomEntityPiscina.getIdROOM());
								
			Assert.assertTrue(roomEntityFind.getIdROOM() == roomEntityPiscina.getIdROOM());
			Assert.assertTrue(roomEntityFind.getCode() == roomEntityPiscina.getCode());
			Assert.assertTrue(roomEntityFind.getDescr() == roomEntityPiscina.getDescr());
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Test
	public void CtestReplace() throws Exception {
		try {
			roomDAO = testDaoFactory.getRoomDAO(testDaoFactory.getEm());
			roomEntityPiscina.setDescr(roomEntityPiscina.getDescr() + " AGGIORNATA");
			
			testDaoFactory.getEm().getTransaction().begin();
			roomDAO.replace(roomEntityPiscina);
			testDaoFactory.getEm().flush();
			
			RoomEntity roomEntityFind = roomDAO.find(roomEntityPiscina.getIdROOM());
			Assert.assertTrue(roomEntityFind.getDescr().equals(roomEntityPiscina.getDescr()));
						
			
			testDaoFactory.getEm().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void DtestCreate2() throws Exception {
		try {
			roomDAO = testDaoFactory.getRoomDAO(testDaoFactory.getEm());
			roomEntitySalaAttesa.setCode("02");
			roomEntitySalaAttesa.setDescr("Sala Attesa");
			
			testDaoFactory.getEm().getTransaction().begin();
			roomDAO.persist(roomEntitySalaAttesa);
			testDaoFactory.getEm().flush();
						
			Assert.assertTrue(roomEntitySalaAttesa.getIdROOM() != 0);
			
			testDaoFactory.getEm().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	
	@Test
	public void EtestFindAll() throws Exception {
		try {
			roomDAO = testDaoFactory.getRoomDAO(testDaoFactory.getEm());
			List<? extends RoomEntity> listRooms = roomDAO.findAll();
			Assert.assertTrue(listRooms.size() != 0);
						
			listRooms.forEach(room-> {
				Assert.assertTrue(room.getIdROOM() == roomEntityPiscina.getIdROOM() || room.getIdROOM() == roomEntitySalaAttesa.getIdROOM());
				Assert.assertTrue(room.getCode().equals(roomEntityPiscina.getCode()) || room.getCode().equals(roomEntitySalaAttesa.getCode()));
				Assert.assertTrue(room.getDescr().equals(roomEntityPiscina.getDescr()) || room.getDescr().equals(roomEntitySalaAttesa.getDescr()));
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Test
	public void FtestFindPaged() throws Exception {
		try {
			roomDAO = testDaoFactory.getRoomDAO(testDaoFactory.getEm());
			IOffset offset = new Offset(1, Integer.MAX_VALUE);
			IListPager<? extends RoomEntity> listRooms = roomDAO.findAllPaged(offset);
			Assert.assertTrue(listRooms.getTotalCount() != 0);
			List<? extends RoomEntity> listRoomEntity = listRooms.getResult();			
			listRoomEntity.forEach(room-> {
				Assert.assertTrue(room.getIdROOM() == roomEntityPiscina.getIdROOM() || room.getIdROOM() == roomEntitySalaAttesa.getIdROOM());
				Assert.assertTrue(room.getCode().equals(roomEntityPiscina.getCode()) || room.getCode().equals(roomEntitySalaAttesa.getCode()));
				Assert.assertTrue(room.getDescr().equals(roomEntityPiscina.getDescr()) || room.getDescr().equals(roomEntitySalaAttesa.getDescr()));
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Test
	public void GtestDelete() throws Exception {
		try {
			roomDAO = testDaoFactory.getRoomDAO(testDaoFactory.getEm());
					
			testDaoFactory.getEm().getTransaction().begin();
			roomDAO.delete(roomEntityPiscina);
			roomDAO.delete(roomEntitySalaAttesa);
			testDaoFactory.getEm().flush();
			testDaoFactory.getEm().getTransaction().commit();
			
			List<? extends RoomEntity> listRooms = roomDAO.findAll();
			
			Assert.assertTrue(listRooms.size() == 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}





}
