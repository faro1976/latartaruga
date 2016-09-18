package it.framework.core.repository.impl;

import java.util.List;

import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.ISortProperty;

public abstract class AbstractRepository {
	
	protected <T> ListPager<T> getPager(final List<T> t, final Long totalResult) {

		return new ListPager<T>() {
			
			public void setSortProperties(List<? extends ISortProperty> sortProperties) {
				// TODO Auto-generated method stub
			}

			public void setOffset(IOffset offset) {
				// TODO Auto-generated method stub

			}

			public Long getTotalCount() {
				return totalResult;
			}

			public List<T> getResult() {
				// TODO Auto-generated method stub
				return t;
			}

		};
	}

}
