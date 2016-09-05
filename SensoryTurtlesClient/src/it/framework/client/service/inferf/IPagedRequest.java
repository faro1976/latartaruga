package it.framework.client.service.inferf;

import java.util.List;

public interface IPagedRequest<T> extends IRequestParameter<T> {
	IOffset getOffset();

	List<? extends ISortProperty> getSortProperties();
}
