package it.framework.core.repository.interf;

import java.util.List;

import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;

public interface IRepository<T, K> {
	T create(T t);

	void delete(T t);
	
	void replace(T t);

	T find(K key);

	IListPager<? extends T> findAllPaged(IOffset offset);

	List<? extends T> findAll();
}
