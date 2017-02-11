package it.latartaruga.sensoryturtles.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import it.latartaruga.sensoryturtles.mplayer.IMPlayer;
import it.latartaruga.sensoryturtles.mplayer.MPlayerCmdEnum;
import it.latartaruga.sensoryturtles.mplayer.Omxplayer;
import it.latartaruga.sensoryturtles.util.PropertiesHelper;

@Path("/MPlayerResource")
public class MPlayerResource {
	private static final Logger logger = Logger.getLogger(MPlayerResource.class);
	private final IMPlayer player = Omxplayer.getInstance();
	private String filePath;
	
	public MPlayerResource() {
		filePath = PropertiesHelper.CFG_PATH + PropertiesHelper.getInstance().getP().getProperty("sensoryturtles.multimedia.dir");
	}
	
	@GET
	@Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    public Response start(@QueryParam("idTherapist")String idTherapist, @QueryParam("idMember")String idMember,@QueryParam("file")String file) {
		file = filePath + "/" + file;
		logger.info("cmd media player, start play " + file);
		try {
			player.play(file);	
		} catch (Exception ex) {
			ex.printStackTrace();
			String errMsg = ex.getMessage().replaceAll("\"", "");
			System.out.println(errMsg);
			return Response.status(Status.BAD_REQUEST).entity(errMsg).build();
		}
		return Response.ok("{}", MediaType.APPLICATION_JSON).build();						
	}

	@GET
	@Path("/invoke")
    @Produces(MediaType.APPLICATION_JSON)
    public Response invoke(@QueryParam("idTherapist")String idTherapist, @QueryParam("idMember")String idMember, @QueryParam("cmd")String cmd) throws Exception{
		logger.info("cmd media player, sending command ["+cmd+"]");
		boolean ret = false;
		try {
			if (cmd.equals(MPlayerCmdEnum.EXIT.toString())) player.exit();
			else if (cmd.equals(MPlayerCmdEnum.REWIND.toString())) player.rewind();
			else if (cmd.equals(MPlayerCmdEnum.FF.toString())) player.fastforward();
			else if (cmd.equals(MPlayerCmdEnum.BACK.toString())) player.back();
			else if (cmd.equals(MPlayerCmdEnum.FW.toString())) player.forward();			
			else if (cmd.equals(MPlayerCmdEnum.PR.toString())) player.pauseResume();
			else if (cmd.equals(MPlayerCmdEnum.VOLUP.toString())) player.volUp();
			else if (cmd.equals(MPlayerCmdEnum.VOLDOWN.toString())) player.volDown();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			String errMsg = e.getMessage().replaceAll("\"", "");
			return Response.status(Status.BAD_REQUEST).entity(errMsg).build();
		}
		return Response.ok("{}", MediaType.APPLICATION_JSON).build();
    }
	
}
