package it.latartaruga.sensoryturtles.rest;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

@Path("/CRUDResource")
public class CRUDResource {
	private static final Logger logger = Logger.getLogger(CRUDResource.class);
//	
//	@POST
//	@Path("/DeviceRelayList")
//    @Produces(MediaType.APPLICATION_JSON)
//    public CRUDResult readList() {
//		List<RelayVO> ret = new ArrayList<RelayVO>();
//		ret.add(new RelayVO("code1","descr1", "idzwave1"));
//		return new CRUDResult(CRUDResult.OK, ret);
//    }
	
}
