package it.latartaruga.sensoryturtles.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.repository.impl.AbstractRepository;
import it.framework.core.repository.impl.ListPager;
import it.framework.core.repository.impl.RepositoryRuntimeException;
import it.latartaruga.sensoryturtles.dao.interf.IDAOFactoryTurtles;
import it.latartaruga.sensoryturtles.dao.interf.IRoomDAO;
import it.latartaruga.sensoryturtles.entity.RoomEntity;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IRoomRepository;

public class RoomRepository extends AbstractRepository implements IRoomRepository {
	
	private IRoomDAO<RoomEntity, Integer> roomDAO;
	

	public RoomRepository(IDAOFactoryTurtles daoFactoryTurtles, EntityManager em) {
		super();
		roomDAO = daoFactoryTurtles.getRoomDAO(em);
	}

	@Override
	public Room create(Room t) {
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setCode(t.getCode());
		roomEntity.setDescr(t.getDescription());
		roomDAO.persist(roomEntity);
		
		t.setIdRoom(roomEntity.getIdROOM());;
		return t;
	}

	@Override
	public void delete(Room t) {
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setIdROOM(t.getIdRoom());
		roomEntity.setCode(t.getCode());
		roomEntity.setDescr(t.getDescription());
		roomDAO.delete(roomEntity);
	}

	@Override
	public void replace(Room t) {
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setIdROOM(t.getIdRoom());
		roomEntity.setCode(t.getCode());
		roomEntity.setDescr(t.getDescription());
		roomDAO.replace(roomEntity);
	}

	@Override
	public Room find(Integer key) {
		RoomEntity roomEntity = roomDAO.find(key);
		Room room = new Room(roomEntity.getIdROOM(),roomEntity.getCode(),roomEntity.getDescr());
		return room;
	}

	@Override
	public IListPager<? extends Room> findAllPaged(IOffset offset) throws RepositoryRuntimeException{
		IListPager<? extends RoomEntity> listRoomEntities = roomDAO.findAllPaged(offset);
		List<Room> listRooms= new ArrayList<>();
		for (RoomEntity roomEntity : listRoomEntities.getResult()) {
			listRooms.add(createRoom(roomEntity));
		}
		ListPager<Room> retValue = getPager(listRooms, listRoomEntities.getTotalCount());
		return retValue;
	}

	@Override
	public List<? extends Room> findAll() {
		List<? extends RoomEntity> listRoomEntities = roomDAO.findAll();
		List<Room> listRooms= new ArrayList<>();
		listRoomEntities.forEach(entity ->{
			listRooms.add(createRoom(entity));
		});
		return listRooms;
	}

	
	private Room createRoom(RoomEntity roomEntity) {
		return new Room(roomEntity.getIdROOM(),roomEntity.getCode(),roomEntity.getDescr());
	}
}
