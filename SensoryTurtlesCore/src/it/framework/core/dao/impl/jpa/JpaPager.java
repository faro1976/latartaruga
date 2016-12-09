package it.framework.core.dao.impl.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.ISortProperty;
import it.framework.core.dao.enums.Order;
import it.framework.core.dao.interf.IListPager;

public class JpaPager<E> implements IListPager<E>  {
		
	private EntityManager em;
	private Class<E> entityClass;
	private String jpqlQuery;
	private Function<Root<E>, Expression<Boolean>> expression;
	private IOffset offset;
	private List<? extends ISortProperty> sortProperties;

	JpaPager(EntityManager em,Class<E> entityClass,IOffset offset) {
		this.em = em;
		this.entityClass = entityClass;
		this.offset = offset;
		this.jpqlQuery = jpqlQuery;
	}
	
	JpaPager(EntityManager em,Class<E> entityClass,IOffset offset,String jpqlQuery) {
		this.em = em;
		this.entityClass = entityClass;
		this.offset = offset;
		this.jpqlQuery = jpqlQuery;
	}

	JpaPager(EntityManager em,Class<E> entityClass,IOffset offset,Function<Root<E>, Expression<Boolean>> expression) {
		this.em = em;
		this.entityClass = entityClass;
		this.offset = offset;
		this.expression = expression;
	}
	
	JpaPager(Function<Root<E>, Expression<Boolean>> expression) {
		this.expression = expression;
	}
	

	@Override
	public List<E> getResult() {
		TypedQuery<E> q;
		if (jpqlQuery != null) {
			StringBuilder sb = new StringBuilder(jpqlQuery);
			if (sortProperties != null) {
				sb.append(" order by");
				for (ISortProperty sortProperty : sortProperties) {
					sb.append(" ").append(sortProperty.getName()).append(" ")
							.append(sortProperty.getSortOrder().toString());
				}
			}
			q = em.createQuery(sb.toString(), entityClass);
		} else {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<E> cq = cb.createQuery(entityClass);
			Root<E> root = cq.from(entityClass);
			if (expression != null) {
				Expression<Boolean> exps = expression.apply(root);
				if (exps != null) {
					cq.where(exps);
				}
			}
			if (sortProperties != null) {
				List<javax.persistence.criteria.Order> orderBy = new ArrayList<>();
				for (ISortProperty sortProperty : sortProperties) {
					if (sortProperty.getSortOrder().equals(Order.ASC)) {
						orderBy.add(cb.asc(root.get(sortProperty.getName())));
					} else {
						orderBy.add(cb.desc(root.get(sortProperty.getName())));
					}
					cq.orderBy(orderBy);
				}
			}
			q = em.createQuery(cq);
		}
		return q.setFirstResult(offset.getStart()).setMaxResults(offset.getMaxResults()).getResultList();
	}

	@Override
	public Long getTotalCount() {
		if (jpqlQuery != null) {
			String q = "select count(*) from (" + jpqlQuery + ")";
			return em.createQuery(q, Long.class).getSingleResult();
		} else {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Long> cq = cb.createQuery(Long.class);
			Root<E> root = cq.from(entityClass);
			cq.select(cb.count(root));
			if (expression != null) {
				Expression<Boolean> exps = expression.apply(root);
				if (exps != null) {
					cq.where(exps);
				}
			}
			return em.createQuery(cq).getSingleResult();
		}
	}

	@Override
	public void setSortProperties(List<? extends ISortProperty> sortProperties) {
		this.sortProperties = sortProperties;
	}

	@Override
	public void setOffset(IOffset offset) {
		this.offset = offset;
		
	}
}
