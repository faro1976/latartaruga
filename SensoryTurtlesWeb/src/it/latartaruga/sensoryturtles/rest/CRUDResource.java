package it.latartaruga.sensoryturtles.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import it.latartaruga.sensoryturtles.model.CRUDResult;
import it.latartaruga.sensoryturtles.vo.RelayVO;

@Path("/CRUDResource")
public class CRUDResource {
	private static final Logger logger = Logger.getLogger(CRUDResource.class);
	
	@POST
	@Path("/DeviceRelayList")
    @Produces(MediaType.APPLICATION_JSON)
    public CRUDResult readList() {
		List<RelayVO> ret = new ArrayList<RelayVO>();
		ret.add(new RelayVO("code1","descr1", "idzwave1"));
		return new CRUDResult(CRUDResult.OK, ret);
    }
	
}
