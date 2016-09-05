package it.framework.core.dao.interf;

import java.util.List;

import it.framework.client.service.inferf.IOffset;

public interface IDao<E, K> {
	void persist(E t);

	void delete(E t);
	
	void replace(E t);

	E find(K key);

	IListPager<? extends E> findAllPaged(IOffset offset);

	List<? extends E> findAll();
}
