package it.latartaruga.sensoryturtles.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.latartaruga.sensoryturtles.vo.ControllerRGBVO;
import it.latartaruga.sensoryturtles.vo.RelayVO;
import it.latartaruga.sensoryturtles.vo.ZWaveDeviceVO;

@Path("/ZWaveDeviceResource")
public class ZWaveDeviceResource {
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
}
