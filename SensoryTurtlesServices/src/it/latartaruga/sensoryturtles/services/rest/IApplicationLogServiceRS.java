package it.latartaruga.sensoryturtles.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IResponse;
import it.latartaruga.sensoryturtles.model.ApplicationLog;
import it.latartaruga.sensoryturtles.model.CRUDResult;

@Path("ApplicationLog")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface IApplicationLogServiceRS {
	 	 	 
	 @POST
	 @Path("CreateLog")
	 public IResponse<ApplicationLog> createLog(ApplicationLog applciationLog);
	 
	 
	 @GET
	 @Path("Logs/{idRoom}")
	public IPagedResponse<List<? extends ApplicationLog>> getLogs(	@PathParam("idRoom")  String idRoom,
																	@QueryParam("therapist") String therapist,
																	@QueryParam("member") String member );
	 
	 @POST
	 @Path("CRUDLogs/{idRoom}")
	 public CRUDResult readLogs(	@PathParam ("idRoom") String idRoom,
									@QueryParam("therapist") String therapist,
									@QueryParam("member") String member );
	 
	 	

}
