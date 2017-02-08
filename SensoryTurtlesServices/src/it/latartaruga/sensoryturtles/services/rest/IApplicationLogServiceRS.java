package it.latartaruga.sensoryturtles.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import it.framework.client.service.inferf.IResponse;
import it.latartaruga.sensoryturtles.model.ApplicationLog;

@Path("ApplicationLog")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface IApplicationLogServiceRS {
	 	 	 
	 @POST
	 @Path("CreateLog")
	 public IResponse<ApplicationLog> createLog(ApplicationLog applciationLog);
	 
	 	

}
