package it.framework.core.dao.impl.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.google.common.collect.Lists;

import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.ISortProperty;
import it.framework.core.dao.enums.Order;
import it.framework.core.dao.impl.StoredProcedureCall;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.dao.interf.IProperty;
import it.framework.core.dao.interf.IPropertyValue;


public class JpaFinder<E> {

	protected EntityManager em;
	protected Class<E> entityClass;

	
	public JpaFinder(EntityManager em, Class<E> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
	}

	protected List<E> find(String jpqlQuery, int startPosition, int maxResults) {
		TypedQuery<E> q = em.createQuery(jpqlQuery, entityClass);
		return q.setFirstResult(startPosition).setMaxResults(maxResults).getResultList();
	}

	protected List<E> find(CriteriaQuery<E> criteriaQuery, int startPosition, int maxResults) {
		TypedQuery<E> q = em.createQuery(criteriaQuery);
		return q.setFirstResult(startPosition).setMaxResults(maxResults).getResultList();
	}

	protected CriteriaQuery<E> createQuery() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		return cb.createQuery(entityClass);
	}

	protected TypedQuery<E> createJpqlQuery(String jpql) {
		return em.createQuery(jpql, entityClass);
	}

	protected TypedQuery<E> createNamedQuery(String name) {
		return em.createNamedQuery(name, entityClass);
	}

	protected TypedQuery<E> createNamedQueryForUpdate(String name) {
		TypedQuery<E> q = em.createNamedQuery(name, entityClass);
		q.setLockMode(LockModeType.PESSIMISTIC_WRITE);
		return q;
	}

	protected E singleOrNull(TypedQuery<E> query) {
		List<E> results = query.getResultList();
		if (results.isEmpty())
			return null;
		else if (results.size() == 1)
			return results.get(0);
		throw new NonUniqueResultException();
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return em.getCriteriaBuilder();
	}

	protected IListPager<E> getPager(IOffset offset,String jpqlQuery) {
		return new JpaPager<E>(em,entityClass,offset,jpqlQuery);
	}
	
	protected IListPager<E> getPager(IOffset offset,TypedQuery<E> query) {
		return new JpaPager<E>(em,entityClass,offset,query);
	}
	
	protected IListPager<E> getPager(Function<Root<E>, Expression<Boolean>> expressions) {
		return new JpaPager(em,entityClass,expressions);
	}


	protected IListPager<E> getPager(IOffset offset,Function<Root<E>, Expression<Boolean>> expressions) {
		return new JpaPager<E>(em,entityClass,offset,expressions);
	}

	public IListPager<? extends E> findAllPaged(IOffset offset) {
		return new JpaPager<E>(em,entityClass,offset);
	}

	public List<? extends E> findAll() {
		CriteriaQuery<E> q = createQuery();
		q.from(entityClass);
		return em.createQuery(q).getResultList();
	}

	
	public IListPager<E> findByPropertiesPaged(IOffset offset,
											   List<? extends IPropertyValue<?>> criteria,
											   List<? extends IProperty> projection) {
		return getPager(offset,r -> {
			if (criteria != null) {
				CriteriaBuilder cb = getCriteriaBuilder();
				List<Expression<Boolean>> transform = Lists.transform(criteria,
						i -> cb.equal(r.get(i.getName()), i.getValue()));
				return cb.and(transform.toArray(new Predicate[transform.size()]));
			}
			return null;
		});
	}

	protected StoredProcedureCall createStoredProcedureCall(String procedureName) {
		return new StoredProcedureCall(em.createStoredProcedureQuery(procedureName));
	}
}
