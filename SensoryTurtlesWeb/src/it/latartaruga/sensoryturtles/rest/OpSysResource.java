package it.latartaruga.sensoryturtles.rest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

@Path("/OpSysResource")
public class OpSysResource {
	private static final Logger logger = Logger.getLogger(OpSysResource.class);
	

	
	@GET
	@Path("/invoke")
    @Produces(MediaType.APPLICATION_JSON)
    public String invoke(@QueryParam("cmd")String cmd) {		
		StringBuffer sb=new StringBuffer();
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";			
			while ((line = reader.readLine())!= null) {
				sb.append(line + "\n");
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			String errMsg = ex.getMessage().replaceAll("\"", "");
			System.out.println(errMsg);
			return Response.status(Status.BAD_REQUEST).entity(errMsg).build().toString();
		}
		logger.info("invoking cmd:"+cmd+"; result:\n"+sb.toString());
		return sb.toString();
    }
	
}
