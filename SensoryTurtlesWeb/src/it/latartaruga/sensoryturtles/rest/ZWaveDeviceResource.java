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
	ZWaveInvoker zwi = new ZWaveInvoker();
	
//	@GET
//	@Path("/readList")
//    @Produces(MediaType.APPLICATION_JSON)
//    public java.util.List<ZWaveDeviceVO> readList() {
//		List<ZWaveDeviceVO> deviceList = new ArrayList<ZWaveDeviceVO>();
//		deviceList.add(new ControllerRGBVO("ZWayVDev_zway_3-0-51-rgb","led_piscina_dx","3"));
//		deviceList.add(new ControllerRGBVO("cod4","led_piscina_sx","4"));
//		deviceList.add(new RelayVO("cod1","luce_stroboscopica","1"));
//		deviceList.add(new RelayVO("ZWayVDev_zway_2-0-37","sparabolle","2"));
//        return deviceList;
//		
//    }
//	
//	@GET
//	@Path("/read")
//    @Produces(MediaType.APPLICATION_JSON)
//    public RelayVO read(@QueryParam("deviceId")String deviceId) {
//        return new RelayVO("cod3","relay1","3");
//    }

	
	@GET
	@Path("/invoke")
    @Produces(MediaType.APPLICATION_JSON)
    public String invoke(@QueryParam("devId")String devId, @QueryParam("type")String type, @QueryParam("cmd")String cmd) throws Exception{
		logger.info("devId:"+devId+";type:"+type+";cmd:"+cmd+";");
		return zwi.invokeCmd(devId, type, cmd);
//		return "okrob";
    }
	
}
