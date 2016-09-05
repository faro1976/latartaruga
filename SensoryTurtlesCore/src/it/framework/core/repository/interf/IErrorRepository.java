package it.framework.core.repository.interf;

import java.util.Map;

public interface IErrorRepository {
	String getMessage(String errorCode, Map<String, Object> parameters);
}
