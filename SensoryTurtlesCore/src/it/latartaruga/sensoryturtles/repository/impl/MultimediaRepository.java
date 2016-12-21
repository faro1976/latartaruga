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
import it.latartaruga.sensoryturtles.dao.interf.IDeviceMultimediaDAO;
import it.latartaruga.sensoryturtles.entity.DeviceMultimediaEntity;
import it.latartaruga.sensoryturtles.entity.DeviceMultimediaEntityPK;
import it.latartaruga.sensoryturtles.model.DeviceKey;
import it.latartaruga.sensoryturtles.model.Multimedia;
import it.latartaruga.sensoryturtles.repository.interf.IMultimediaRepository;

public class MultimediaRepository extends AbstractRepository implements IMultimediaRepository {
	
	private IDeviceMultimediaDAO<DeviceMultimediaEntity,DeviceMultimediaEntityPK> deviceMultimediaDAO;
	
	public MultimediaRepository(IDAOFactoryTurtles daoFactoryTurtles, EntityManager em) {
		super();
		deviceMultimediaDAO = daoFactoryTurtles.getDeviceMultimediaDAO(em);
	}

	@Override
	public Multimedia  create(Multimedia t) {
		DeviceMultimediaEntity deviceMultimediaEntity = new DeviceMultimediaEntity();
		DeviceMultimediaEntityPK pk = new DeviceMultimediaEntityPK(); 
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceMultimediaEntity.setId(pk);
		deviceMultimediaEntity.setCode(t.getCode());
		deviceMultimediaEntity.setDescr(t.getDescription());
		deviceMultimediaEntity.setPath(t.getPath());
		
		deviceMultimediaDAO.persist(deviceMultimediaEntity);
		t.getDeviceKey().setIdDevice(deviceMultimediaEntity.getId().getIdDEVICE());
	
		return t;
	}

	@Override
	public void delete(Multimedia t) {
		DeviceMultimediaEntity deviceMultimediaEntity = new DeviceMultimediaEntity();
		DeviceMultimediaEntityPK pk = new DeviceMultimediaEntityPK();
		pk.setIdDEVICE(t.getDeviceKey().getIdDevice());
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceMultimediaEntity.setCode(t.getCode());
		deviceMultimediaEntity.setDescr(t.getDescription());
		deviceMultimediaEntity.setPath(t.getPath());
		deviceMultimediaDAO.delete(deviceMultimediaEntity);
	}

	@Override
	public void replace(Multimedia t) {
		DeviceMultimediaEntity deviceMultimediaEntity = new DeviceMultimediaEntity();
		DeviceMultimediaEntityPK pk = new DeviceMultimediaEntityPK();
		pk.setIdDEVICE(t.getDeviceKey().getIdDevice());
		pk.setIdROOM(t.getDeviceKey().getIdRoom());
		deviceMultimediaEntity.setCode(t.getCode());
		deviceMultimediaEntity.setDescr(t.getDescription());
		deviceMultimediaEntity.setPath(t.getPath());
		deviceMultimediaDAO.replace(deviceMultimediaEntity);
	}

	@Override
	public Multimedia find(DeviceKey key) {
		DeviceMultimediaEntityPK pk = new DeviceMultimediaEntityPK();
		pk.setIdDEVICE(key.getIdDevice());
		pk.setIdROOM(key.getIdRoom());
		DeviceMultimediaEntity deviceMultimediaEntity = deviceMultimediaDAO.find(pk);
		return createMultimedia(deviceMultimediaEntity);
	}

	@Override
	public IListPager<? extends Multimedia> findAllPaged(IOffset offset) throws RepositoryRuntimeException{
		IListPager<? extends DeviceMultimediaEntity> listDeviceMultimediaEntities = deviceMultimediaDAO.findAllPaged(offset);
		List<Multimedia> listMultimedia= new ArrayList<>();
		for (DeviceMultimediaEntity deviceMultimediaEntity : listDeviceMultimediaEntities.getResult()) {
			listMultimedia.add(createMultimedia(deviceMultimediaEntity));
		}
		ListPager<Multimedia> retValue = getPager(listMultimedia, listDeviceMultimediaEntities.getTotalCount());
		return retValue;
	}

	@Override
	public List<? extends Multimedia> findAll() {
		List<? extends DeviceMultimediaEntity> listDeviceMultimediaEntities = deviceMultimediaDAO.findAll();
		List<Multimedia> listMultimedia= new ArrayList<>();
		listDeviceMultimediaEntities.forEach(entity ->{
			listMultimedia.add(createMultimedia(entity));
		});
		return listMultimedia;
	}
	
	
	@Override
	public IListPager<? extends Multimedia> findByRoom(IOffset offset,Integer idRoom) {
		IListPager<? extends DeviceMultimediaEntity> listDeviceMultimediaEntities = deviceMultimediaDAO.findByRoom(offset,idRoom);
		List<Multimedia> listMultimedia= new ArrayList<>();
		for (DeviceMultimediaEntity deviceMultimediaEntity : listDeviceMultimediaEntities.getResult()) {
			listMultimedia.add(createMultimedia(deviceMultimediaEntity));
		}
		ListPager<Multimedia> retValue = getPager(listMultimedia, listDeviceMultimediaEntities.getTotalCount());
		return retValue;
	}

	
	private Multimedia createMultimedia(DeviceMultimediaEntity deviceMultimediaEntity) {
		DeviceKey deviceKey = new DeviceKey(deviceMultimediaEntity.getId().getIdROOM(), deviceMultimediaEntity.getId().getIdDEVICE());
		return new Multimedia(deviceKey,deviceMultimediaEntity.getCode(),deviceMultimediaEntity.getDescr(),deviceMultimediaEntity.getPath());
	}
}
