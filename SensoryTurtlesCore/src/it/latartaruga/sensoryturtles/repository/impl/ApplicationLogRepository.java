package it.latartaruga.sensoryturtles.repository.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.repository.impl.AbstractRepository;
import it.latartaruga.sensoryturtles.dao.interf.IApplicationLogDAO;
import it.latartaruga.sensoryturtles.dao.interf.IDAOFactoryTurtles;
import it.latartaruga.sensoryturtles.entity.ApplicationLogEntity;
import it.latartaruga.sensoryturtles.model.ApplicationLog;
import it.latartaruga.sensoryturtles.repository.interf.IApplicationLogRepository;

@Dependent
public class ApplicationLogRepository extends AbstractRepository implements IApplicationLogRepository {
	
	private IApplicationLogDAO<ApplicationLogEntity, Integer> applicationLogDAO;
	private EntityManager em;


	public ApplicationLogRepository() {
		super();
	}

	public ApplicationLogRepository(IDAOFactoryTurtles daoFactoryTurtles, EntityManager em) {
		super();
		this.em = em;
		applicationLogDAO = daoFactoryTurtles.getApplicationLogDAO(em);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ApplicationLog create(ApplicationLog t) {
		try {

			ApplicationLogEntity applicationLogEntity = createApplicationLogEntity(t);
			applicationLogDAO.persist(applicationLogEntity);
			t.setId(applicationLogEntity.getIdAPPLICATIONLOG());;
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public void delete(ApplicationLog t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replace(ApplicationLog t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ApplicationLog find(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IListPager<? extends ApplicationLog> findAllPaged(IOffset offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends ApplicationLog> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private ApplicationLogEntity createApplicationLogEntity(ApplicationLog applicationLog) {
		ApplicationLogEntity applicationLogEntity = new ApplicationLogEntity();
		applicationLogEntity.setTherapist(applicationLog.getTherapist());
		applicationLogEntity.setMember(applicationLog.getMember());
		applicationLogEntity.setIdROOM(applicationLog.getIdRoom());
		applicationLogEntity.setIdDEVICE(applicationLog.getIdDevice());
		applicationLogEntity.setTypeDEVICE(applicationLog.getTypeDevice());
		applicationLogEntity.setCmdDEVICE(applicationLog.getCmdDevice());
		return applicationLogEntity;
	}

}
