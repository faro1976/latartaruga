package it.framework.client.service.inferf;

import java.util.List;

public interface IBaseFault extends IResultStatus {

	String getApplicationId();

	IExecutionContext getExecutionContext();

	IBaseFault getCause();

	String getSourceCode();

	String getSourceMessage();

	String getUserCode();

	String getUserMessage();

	String getErrorType();

	String getErrorSource();

	boolean isToNotify();

	boolean isPublished();

	List<IKeyValue> getParameters();
}
