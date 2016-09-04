package it.latartaruga.sensoryturtles.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import it.latartaruga.sensoryturtles.vo.ControllerRGBVO;
import it.latartaruga.sensoryturtles.vo.RelayVO;
import it.latartaruga.sensoryturtles.vo.ZWaveDeviceVO;
import it.latartaruga.sensoryturtles.zwave.ZWaveInvoker;
import it.latartaruga.sensoryturtles.zwave.ZWaveInvoker.ZWaveCmd;

@Path("/ZWaveDeviceResource")
public class ZWaveDeviceResource {
	private static final Logger logger = Logger.getLogger(ZWaveDeviceResource.class);
	ZWaveInvoker zwi = new ZWaveInvoker();
	
	@GET
	@Path("/readList")
    @Produces(MediaType.APPLICATION_JSON)
    public java.util.List<ZWaveDeviceVO> readList() {
		List<ZWaveDeviceVO> deviceList = new ArrayList<ZWaveDeviceVO>();
		deviceList.add(new ControllerRGBVO("cod1","ctrlrgb1","1"));
		deviceList.add(new ControllerRGBVO("cod2","ctrlrgb2","2"));
		deviceList.add(new RelayVO("cod3","relay1","3"));
		deviceList.add(new RelayVO("cod4","relay2","4"));
        return deviceList;
    }
	
	@GET
	@Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public RelayVO read(@QueryParam("deviceId")String deviceId) {
        return new RelayVO("cod3","relay1","3");
    }

	
	@GET
	@Path("/invoke")
    @Produces(MediaType.APPLICATION_JSON)
    public String invoke(@QueryParam("devId")String devId, @QueryParam("cmd")String cmd) throws Exception{
		System.out.println("devId:"+devId+";cmd:"+cmd+";");
		//return zwi.invokeCmd(devId, ZWaveCmd.valueOf(cmd));
		return "okrob";
    }
	
}
