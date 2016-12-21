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
import it.latartaruga.sensoryturtles.dao.interf.IDeviceRelayDAO;
import it.latartaruga.sensoryturtles.dao.interf.IRoomDAO;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntityPK;
import it.latartaruga.sensoryturtles.entity.RoomEntity;
import it.latartaruga.sensoryturtles.model.DeviceKey;
import it.latartaruga.sensoryturtles.model.Relay;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IRelayRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRoomRepository;

public class RelayRepository extends AbstractRepository implements IRelayRepository {
	
	private IDeviceRelayDAO<DeviceRelayEntity,DeviceRelayEntityPK> deviceRelayDAO;
	

	public RelayRepository(IDAOFactoryTurtles daoFactoryTurtles, EntityManager em) {
		super();
		deviceRelayDAO = daoFactoryTurtles.getDeviceReleayDAO(em);
		
	}

	@Override
	public Relay  create(Relay t) {
		DeviceRelayEntity deviceRelayEntity = new DeviceRelayEntity();
		DeviceRelayEntityPK pk = new DeviceRelayEntityPK(); 
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceRelayEntity.setId(pk);
		deviceRelayEntity.setCode(t.getCode());
		deviceRelayEntity.setDescr(t.getDescription());
		deviceRelayEntity.setIdRaspBerry(t.getIdRaspBerry());
	
		deviceRelayDAO.persist(deviceRelayEntity);
		t.getDeviceKey().setIdDevice(deviceRelayEntity.getId().getIdDEVICE());
	
		return t;
	}

	@Override
	public void delete(Relay t) {
		DeviceRelayEntity deviceRelayEntity = new DeviceRelayEntity();
		DeviceRelayEntityPK pk = new DeviceRelayEntityPK();
		pk.setIdDEVICE(t.getDeviceKey().getIdDevice());
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceRelayEntity.setCode(t.getCode());
		deviceRelayEntity.setDescr(t.getDescription());
		deviceRelayEntity.setIdRaspBerry(t.getIdRaspBerry());
		deviceRelayDAO.delete(deviceRelayEntity);
	}

	@Override
	public void replace(Relay t) {
		DeviceRelayEntity deviceRelayEntity = new DeviceRelayEntity();
		DeviceRelayEntityPK pk = new DeviceRelayEntityPK();
		pk.setIdDEVICE(t.getDeviceKey().getIdDevice());
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceRelayEntity.setCode(t.getCode());
		deviceRelayEntity.setDescr(t.getDescription());
		deviceRelayEntity.setIdRaspBerry(t.getIdRaspBerry());
		deviceRelayDAO.replace(deviceRelayEntity);
	}

	@Override
	public Relay find(DeviceKey key) {
		DeviceRelayEntityPK pk = new DeviceRelayEntityPK();
		pk.setIdDEVICE(key.getIdDevice());
		pk.setIdROOM(key.getIdRoom());
		DeviceRelayEntity deviceRelayEntity = deviceRelayDAO.find(pk);
		return createRelay(deviceRelayEntity);
	}

	@Override
	public IListPager<? extends Relay> findAllPaged(IOffset offset) throws RepositoryRuntimeException{
		IListPager<? extends DeviceRelayEntity> listDeviceRelaysEntities = deviceRelayDAO.findAllPaged(offset);
		List<Relay> listRelays= new ArrayList<>();
		for (DeviceRelayEntity deviceRelayEntity : listDeviceRelaysEntities.getResult()) {
			listRelays.add(createRelay(deviceRelayEntity));
		}
		ListPager<Relay> retValue = getPager(listRelays, listDeviceRelaysEntities.getTotalCount());
		return retValue;
	}

	@Override
	public List<? extends Relay> findAll() {
		List<? extends DeviceRelayEntity> listDeviceRelayEntities = deviceRelayDAO.findAll();
		List<Relay> listRelays= new ArrayList<>();
		listDeviceRelayEntities.forEach(entity ->{
			listRelays.add(createRelay(entity));
		});
		return listRelays;
	}
	
	
	@Override
	public IListPager<? extends Relay> findByRoom(IOffset offset,Integer idRoom) {
		IListPager<? extends DeviceRelayEntity> listDeviceRelaysEntities = deviceRelayDAO.findByRoom(offset,idRoom);
		List<Relay> listRelays= new ArrayList<>();
		for (DeviceRelayEntity deviceRelayEntity : listDeviceRelaysEntities.getResult()) {
			listRelays.add(createRelay(deviceRelayEntity));
		}
		ListPager<Relay> retValue = getPager(listRelays, listDeviceRelaysEntities.getTotalCount());
		return retValue;
	}

	
	private Relay createRelay(DeviceRelayEntity deviceRelayEntity) {
		DeviceKey deviceKey = new DeviceKey(deviceRelayEntity.getId().getIdROOM(), deviceRelayEntity.getId().getIdDEVICE());
		return new Relay(deviceKey,deviceRelayEntity.getCode(),deviceRelayEntity.getDescr(),deviceRelayEntity.getIdRaspBerry());
	}
}
