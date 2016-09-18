package it.framework.client.service.inferf;

public interface IPagedResponse<T> extends IResponse<T> {
	Long getTotalCount();
}
