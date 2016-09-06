package it.framework.core.exposer.interf;

import it.framework.client.service.impl.type.ResultStatusType;
import it.framework.client.service.inferf.IResultStatus;

public interface IResultStatusConverter {
	ResultStatusType convert(IResultStatus resultStatus);
}
