package it.latartaruga.sensoryturtles.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import it.latartaruga.sensoryturtles.zwave.ZWaveInvoker;

@Path("/ZWaveDeviceResource")
public class ZWaveDeviceResource {
	private static final Logger logger = Logger.getLogger(ZWaveDeviceResource.class);
	private ZWaveInvoker zwi = new ZWaveInvoker();
	

	@GET
	@Path("/invoke")
    @Produces(MediaType.APPLICATION_JSON)
    public String invoke(@QueryParam("idTherapist")String idTherapist, @QueryParam("idMember")String idMember, @QueryParam("devId")String devId, @QueryParam("type")String type, @QueryParam("cmd")String cmd) throws Exception{
		logger.info("devId:"+devId+";type:"+type+";cmd:"+cmd+";");
		String ret = zwi.invokeCmd(devId, type, cmd);
		return ret;
    }
	
}
