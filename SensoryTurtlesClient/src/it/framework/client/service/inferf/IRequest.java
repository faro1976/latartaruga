package it.framework.client.service.inferf;

public interface IRequest<T> {
	IRequestContext getContext();
	void setContext(IRequestContext requestContext);
}
