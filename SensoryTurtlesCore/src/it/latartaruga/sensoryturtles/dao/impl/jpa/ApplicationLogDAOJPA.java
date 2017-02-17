package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.framework.client.service.impl.SearchCriteriaApplicationLog;
import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.impl.jpa.JpaDao;
import it.framework.core.dao.interf.IListPager;
import it.latartaruga.sensoryturtles.dao.interf.IApplicationLogDAO;
import it.latartaruga.sensoryturtles.entity.ApplicationLogEntity;
import it.latartaruga.sensoryturtles.entity.DeviceControllerRgbEntity;
import it.latartaruga.sensoryturtles.entity.DeviceRelayEntity;

@Dependent
public class ApplicationLogDAOJPA extends JpaDao<ApplicationLogEntity, Integer> implements IApplicationLogDAO<ApplicationLogEntity, Integer>{

	public ApplicationLogDAOJPA(EntityManager em, Class<ApplicationLogEntity> entityClass) {
		super(em, entityClass);
	}

	@Override
	public IListPager<ApplicationLogEntity> findByRoomTherapistMember(IOffset offset,SearchCriteriaApplicationLog criteria) {
		
		TypedQuery<ApplicationLogEntity> q  = em.createNamedQuery("ApplicationLogEntity.findByRoomTherapistMember", ApplicationLogEntity.class);
		q.setParameter("idROOMValue", criteria.getIdRoom());
		q.setParameter("THERAPISTValue", criteria.getTherapist());
		q.setParameter("MEMBERValue", criteria.getMember());
		return  getPager(offset,q);	
	}
	
}
