package it.framework.client.service.inferf;

import java.util.Date;

public interface IResultStatus {

	String getMessage();

	String getCode();

	Date getTimestamp();

	Severity getSeverity();

	enum Severity {
		SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST
	}
}
