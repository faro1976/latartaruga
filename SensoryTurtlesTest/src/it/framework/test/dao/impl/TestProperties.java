package it.framework.test.dao.impl;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	private final Properties properties;

	public TestProperties(String path) {
		properties = new Properties();
		try {
			properties.load(TestProperties.class.getResourceAsStream(path));
		} catch (IOException e) {
			throw new TestRuntimeException(e);
		}
	}

	public String getJdbcUrl() {
		return properties.getProperty("jdbcUrl");
	}

	public String getJdbcUser() {
		return properties.getProperty("jdbcUser");
	}

	public String getJdbcPassword() {
		return properties.getProperty("jdbcPassword");
	}
}
