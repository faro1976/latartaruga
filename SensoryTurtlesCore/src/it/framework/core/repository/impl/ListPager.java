package it.framework.core.repository.impl;

import java.util.List;

import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.ISortProperty;
import it.framework.core.dao.interf.IListPager;

public class ListPager<T> implements IListPager<T> {

	@Override
	public void setOffset(IOffset offset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSortProperties(List<? extends ISortProperty> sortProperties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
