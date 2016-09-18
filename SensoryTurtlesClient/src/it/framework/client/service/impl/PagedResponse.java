package it.framework.client.service.impl;

import it.framework.client.service.inferf.IPagedResponse;

public class PagedResponse<T> extends BusinessResponseDefault<T> implements IPagedResponse<T> {

	private Long totalCount;
	
	@Override
	public Long getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
}
