package it.framework.client.service.inferf;

import java.util.List;

public interface IResponse<T> {
	List<IResultStatus> getResultStatus();
	T getResult();
}
