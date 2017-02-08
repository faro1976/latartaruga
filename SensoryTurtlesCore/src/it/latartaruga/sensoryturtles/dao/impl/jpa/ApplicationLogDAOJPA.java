package it.latartaruga.sensoryturtles.dao.impl.jpa;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

import it.framework.core.dao.impl.jpa.JpaDao;
import it.latartaruga.sensoryturtles.dao.interf.IApplicationLogDAO;
import it.latartaruga.sensoryturtles.entity.ApplicationLogEntity;

@Dependent
public class ApplicationLogDAOJPA extends JpaDao<ApplicationLogEntity, Integer> implements IApplicationLogDAO<ApplicationLogEntity, Integer>{

	public ApplicationLogDAOJPA(EntityManager em, Class<ApplicationLogEntity> entityClass) {
		super(em, entityClass);
	}

}
