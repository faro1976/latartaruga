package it.framework.core.exposer.impl;

import it.framework.client.service.impl.RestFault;
import it.framework.client.service.impl.ServiceException;


public class RestExposer extends Exposer {
	protected RestFault createRestExeption(ServiceException e) {
		return new RestFault(toBaseFaultType(e, "WLS"), e);
	}


}
