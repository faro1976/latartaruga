package it.latartaruga.sensoryturtles.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import it.latartaruga.sensoryturtles.mplayer.IMPlayer;
import it.latartaruga.sensoryturtles.mplayer.MPlayerCmdEnum;
import it.latartaruga.sensoryturtles.mplayer.Omxplayer;

@Path("/MPlayerResource")
public class MPlayerResource {
	private static final Logger logger = Logger.getLogger(MPlayerResource.class);
	private final IMPlayer player = Omxplayer.getInstance(); 
	
	@GET
	@Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    public void start(@QueryParam("file")String file) throws Exception{
		logger.info("cmd media player, start play " + file);
		player.play(file);				
	}

	@GET
	@Path("/invoke")
    @Produces(MediaType.APPLICATION_JSON)
    public void invoke(@QueryParam("cmd")String cmd) throws Exception{
		logger.info("cmd media player, sending command ["+cmd+"]");
		try {
			if (cmd.equals(MPlayerCmdEnum.EXIT.toString())) player.exit();
			else if (cmd.equals(MPlayerCmdEnum.REWIND.toString())) player.rewind();
			else if (cmd.equals(MPlayerCmdEnum.FF.toString())) player.fastforward();
			else if (cmd.equals(MPlayerCmdEnum.PR.toString())) player.pauseResume();
			else if (cmd.equals(MPlayerCmdEnum.UP.toString())) player.volUp();
			else if (cmd.equals(MPlayerCmdEnum.DOWN.toString())) player.volDown();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
    }
	
}
