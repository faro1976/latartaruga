package it.latartaruga.sensoryturtles.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import it.framework.client.service.impl.RestFault;
import it.framework.client.service.inferf.IPagedResponse;
import it.framework.client.service.inferf.IResponse;
import it.latartaruga.sensoryturtles.model.ControllerRGB;
import it.latartaruga.sensoryturtles.model.Multimedia;
import it.latartaruga.sensoryturtles.model.Relay;
import it.latartaruga.sensoryturtles.model.Room;

@Path("Configuration")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface IRoomServiceRS {
	
	 @GET
	 @Path("Rooms")
	 public IPagedResponse<List<? extends Room>> getRooms()  throws RestFault;

	 @GET
	 @Path("Room/{idRoom}")
	 public IResponse<Room> getRoom(@PathParam("idRoom") String idRoom);
	 
	 @GET
	 @Path("Room/{idRoom}/Relays")
	 public IPagedResponse<List<? extends Relay>> getRelaysByRoom(@PathParam("idRoom") String idRoom);
	 
	 @GET
	 @Path("Room/{idRoom}/ControllersRGB")
	 public  IPagedResponse<List<? extends ControllerRGB>> getControllerRGBByRoom(@PathParam("idRoom") String idRoom);
	 
	 @GET
	 @Path("Room/{idRoom}/Multimedia")
	 public IPagedResponse<List<? extends Multimedia>> getMultimediaByRoom(@PathParam("idRoom") String idRoom);
	 	 
	 @POST
	 @Path("CreateRoom")
	 public Room createRoom(Room room);
	 
	 @PUT
	 @Path("ReplaceRoom")
	 public Room replaceRoom(Room room);
	 
	 @DELETE
	 @Path("DeleteRoom/{idRoom}")
	 public void deleteRoom(@PathParam("idRoom") int idRoom);
	 
	 @POST
	 @Path("Room/{idRoom}/CreateRelay")
	 public Room createRelayByRoom(@PathParam("idRoom") int idRoom ,Relay relay);
	 
	 @POST
	 @Path("Room/{idRoom}/ReplaceRelay")
	 public Room replaceRelayByRoom(@PathParam("idRoom") int idRoom ,Relay relay);
	 
	 @POST
	 @Path("Room/{idRoom}/DeleteRelay/{idRelay}")
	 public Room deleteRelayByRoom(@PathParam("idRoom") int idRoom ,@PathParam("idRelay") int idRelay);
	 
	 @POST
	 @Path("Room/{idRoom}/CreateControllersRGB")
	 public Room createControllersRGBByRoom(@PathParam("idRoom") int idRoom ,ControllerRGB controllerRGB);
	 
	 @POST
	 @Path("Room/{idRoom}/ReplaceControllersRGB")
	 public Room replaceControllersRGBByRoom(@PathParam("idRoom") int idRoom ,ControllerRGB controllerRGB);
	 
	 @POST
	 @Path("Room/{idRoom}/DeleteControllersRGB/{idControllerRGB}")
	 public Room deleteControllersRGBByRoom(@PathParam("idRoom") int idRoom ,@PathParam("idControllerRGB") int idControllerRGB);
	 
	 @POST
	 @Path("Room/{idRoom}/Multimedia")
	 public Room createMultimediaByRoom(@PathParam("idRoom") int idRoom ,Multimedia multimedia);
	 
	 @POST
	 @Path("Room/{idRoom}/ReplaceMultimedia")
	 public Room replaceMultimediaByRoom(@PathParam("idRoom") int idRoom ,Multimedia multimedia);
	 
	 @POST
	 @Path("Room/{idRoom}/DeleteMultimedia/{idMultimedia}")
	 public Room deleteMultimediaBByRoom(@PathParam("idRoom") int idRoom ,@PathParam("idMultimedia") int idMultimedia);
	 
	 
	

}
