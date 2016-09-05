package it.latartaruga.sensoryturtles.properties;

import it.framework.core.executor.impl.BaseExecutor.CoreExecutorParameters;

public class TurtlesProperties extends CoreExecutorParameters {
	public TurtlesProperties() {
		super(applicationId);
	}

	private static final String applicationId = "TURTLES";
	private String errorSource = "WLS";

	public String getApplicationId() {
		return applicationId;
	}

	public String getErrorSource() {
		return errorSource;
	}

}
