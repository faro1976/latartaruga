package it.framework.core.dao.impl.jpa;

import javax.persistence.EntityManager;

import it.framework.core.dao.impl.StoredProcedureCall;
import it.framework.core.dao.interf.IDao;

public class JpaDao<E, K> extends JpaFinder<E> implements IDao<E, K> {

	public JpaDao(EntityManager em, Class<E> entityClass) {
		super(em, entityClass);
	}
	

	@Override
	public void persist(E t) {
		em.persist(t);
		em.flush();
	}

	@Override
	public void replace(E t) {
		em.merge(t);
		em.flush();
	}
	
	@Override
	public void delete(E t) {
	    E entityRemove = em.merge(t);
		em.remove(entityRemove);
		em.flush();
	}

	public void flush() {
		em.flush();
	}

	@Override
	public E find(K key) {
		return em.find(entityClass, key);
	}

	protected StoredProcedureCall createStoredProcedureCall(String procedureName) {
		return new StoredProcedureCall(em.createStoredProcedureQuery(procedureName));
	}


}
