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
import it.latartaruga.sensoryturtles.dao.interf.IDeviceControllerRGBDAO;
import it.latartaruga.sensoryturtles.dao.interf.IDeviceRelayDAO;
import it.latartaruga.sensoryturtles.dao.interf.IRoomDAO;
import it.latartaruga.sensoryturtles.entity.DeviceControllerRgbEntity;
import it.latartaruga.sensoryturtles.entity.DeviceControllerRgbEntityPK;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntityPK;
import it.latartaruga.sensoryturtles.entity.RoomEntity;
import it.latartaruga.sensoryturtles.model.ControllerRGB;
import it.latartaruga.sensoryturtles.model.DeviceKey;
import it.latartaruga.sensoryturtles.model.Relay;
import it.latartaruga.sensoryturtles.model.Room;
import it.latartaruga.sensoryturtles.repository.interf.IControllerRGBRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRelayRepository;
import it.latartaruga.sensoryturtles.repository.interf.IRoomRepository;

public class ControllerRGBRepository extends AbstractRepository implements IControllerRGBRepository {
	
	private IDeviceControllerRGBDAO<DeviceControllerRgbEntity,DeviceControllerRgbEntityPK> deviceControllerRGBDAO;
	
	public ControllerRGBRepository(IDAOFactoryTurtles daoFactoryTurtles, EntityManager em) {
		super();
		deviceControllerRGBDAO = daoFactoryTurtles.getDeviceControllerRGBDAO(em);

	}

	@Override
	public ControllerRGB  create(ControllerRGB t) {
		DeviceControllerRgbEntity deviceControllerRgbEntity = new DeviceControllerRgbEntity();
		DeviceControllerRgbEntityPK pk = new DeviceControllerRgbEntityPK(); 
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceControllerRgbEntity.setId(pk);
		deviceControllerRgbEntity.setCode(t.getCode());
		deviceControllerRgbEntity.setDescr(t.getDescription());
		deviceControllerRgbEntity.setIdRaspBerry(t.getIdRaspBerry());
	
		deviceControllerRGBDAO.persist(deviceControllerRgbEntity);
		t.getDeviceKey().setIdDevice(deviceControllerRgbEntity.getId().getIdDEVICE());
	
		return t;
	}

	@Override
	public void delete(ControllerRGB t) {
		DeviceControllerRgbEntity deviceControllerRgbEntity = new DeviceControllerRgbEntity();
		DeviceControllerRgbEntityPK pk = new DeviceControllerRgbEntityPK();
		pk.setIdDEVICE(t.getDeviceKey().getIdDevice());
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceControllerRgbEntity.setCode(t.getCode());
		deviceControllerRgbEntity.setDescr(t.getDescription());
		deviceControllerRgbEntity.setIdRaspBerry(t.getIdRaspBerry());
		deviceControllerRGBDAO.delete(deviceControllerRgbEntity);
	}

	@Override
	public void replace(ControllerRGB t) {
		DeviceControllerRgbEntity deviceControllerRgbEntity = new DeviceControllerRgbEntity();
		DeviceControllerRgbEntityPK pk = new DeviceControllerRgbEntityPK();
		pk.setIdDEVICE(t.getDeviceKey().getIdDevice());
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceControllerRgbEntity.setCode(t.getCode());
		deviceControllerRgbEntity.setDescr(t.getDescription());
		deviceControllerRgbEntity.setIdRaspBerry(t.getIdRaspBerry());
		deviceControllerRGBDAO.replace(deviceControllerRgbEntity);
	}

	@Override
	public ControllerRGB find(DeviceKey key) {
		DeviceControllerRgbEntityPK pk = new DeviceControllerRgbEntityPK();
		pk.setIdDEVICE(key.getIdDevice());
		pk.setIdROOM(key.getIdRoom());
		DeviceControllerRgbEntity deviceControllerRgbEntity = deviceControllerRGBDAO.find(pk);
		return createControllerRGB(deviceControllerRgbEntity);
	}

	@Override
	public IListPager<? extends ControllerRGB> findAllPaged(IOffset offset) throws RepositoryRuntimeException{
		IListPager<? extends DeviceControllerRgbEntity> listDeviceControllerRGBEntities = deviceControllerRGBDAO.findAllPaged(offset);
		List<ControllerRGB> listControllersRGB= new ArrayList<>();
		for (DeviceControllerRgbEntity deviceControllerRGBEntity : listDeviceControllerRGBEntities.getResult()) {
			listControllersRGB.add(createControllerRGB(deviceControllerRGBEntity));
		}
		ListPager<ControllerRGB> retValue = getPager(listControllersRGB, listDeviceControllerRGBEntities.getTotalCount());
		return retValue;
	}

	@Override
	public List<? extends ControllerRGB> findAll() {
		List<? extends DeviceControllerRgbEntity> listDeviceControllerRGBEntities = deviceControllerRGBDAO.findAll();
		List<ControllerRGB> listControllersRGB= new ArrayList<>();
		listDeviceControllerRGBEntities.forEach(entity ->{
			listControllersRGB.add(createControllerRGB(entity));
		});
		return listControllersRGB;
	}
	
	
	@Override
	public IListPager<? extends ControllerRGB> findByRoom(IOffset offset,Integer idRoom) {
		IListPager<? extends DeviceControllerRgbEntity> listDeviceControllerRGBEntities = deviceControllerRGBDAO.findByRoom(offset,idRoom);
		List<ControllerRGB> listControllersRGB= new ArrayList<>();
		for (DeviceControllerRgbEntity deviceControllerRGBEntity : listDeviceControllerRGBEntities.getResult()) {
			listControllersRGB.add(createControllerRGB(deviceControllerRGBEntity));
		}
		ListPager<ControllerRGB> retValue = getPager(listControllersRGB, listDeviceControllerRGBEntities.getTotalCount());
		return retValue;
	}

	
	private ControllerRGB createControllerRGB(DeviceControllerRgbEntity deviceControllerRgbEntity) {
		DeviceKey deviceKey = new DeviceKey(deviceControllerRgbEntity.getId().getIdROOM(), deviceControllerRgbEntity.getId().getIdDEVICE());
		return new ControllerRGB(deviceKey,deviceControllerRgbEntity.getCode(),deviceControllerRgbEntity.getDescr(),deviceControllerRgbEntity.getIdRaspBerry());
	}
}
