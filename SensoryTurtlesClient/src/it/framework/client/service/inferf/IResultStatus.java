package it.framework.client.service.inferf;

import java.util.Date;

import it.framework.client.service.enums.SeverityLevelEnum;

public interface IResultStatus {

	String getMessage();

	String getCode();

	Date getDateTimestamp();

	SeverityLevelEnum getSeverity();


}
