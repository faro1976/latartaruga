package it.framework.core.dao.interf;

import java.util.List;

import it.framework.client.service.inferf.IOffset;
import it.framework.client.service.inferf.ISortProperty;

public interface IPager<R> {

	void setOffset(IOffset offset);

	void setSortProperties(List<? extends ISortProperty> sortProperties);

	R getResult();

	Long getTotalCount();

}
