package it.framework.core.error.impl;

import java.util.HashMap;
import java.util.Map;

import it.framework.core.error.interf.IErrorRepository;

public class ErrorRepository implements IErrorRepository {

	private Map mapMessage = null;

	
	public ErrorRepository() {
		super();
		mapMessage = new HashMap<String, String>();
		mapMessage.put("RUNTIME","Errore di Runtime : ");
	}


	@Override
	public String getMessage(String errorCode, Map<String, Object> parameters) {
		String message = null;
		message = (String) mapMessage.get(errorCode);
		if (message == null) {
			message = "Descrizione del messaggio di errore non trovato : ";
		} 
		if (parameters != null) {
			while (parameters.keySet().iterator().hasNext()) {
				String key = parameters.keySet().iterator().next();
				Object value = parameters.get(key);
				if (value != null) {
					message = message + " " + key + ": " +  value + "\n";
				}
			}
		}
		return message;
	}

}
