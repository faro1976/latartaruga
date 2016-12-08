package it.latartaruga.sensoryturtles.rest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import it.latartaruga.sensoryturtles.util.PropertiesHelper;

@Path("/MediaFileResource")
public class MediaFileResource {
	private static final Logger logger = Logger.getLogger(MediaFileResource.class);
	
	@GET
	@Path("/readList")
    @Produces(MediaType.APPLICATION_JSON)
    public java.util.List<String> readList() {
		String filePath = PropertiesHelper.CFG_PATH + PropertiesHelper.getInstance().getP().getProperty("sensoryturtles.multimedia.dir");
		logger.info("media file directory: " + filePath);
		List<String> fileList = new ArrayList<String>();
		
		File folder = new File(filePath);
		File[] files = folder.listFiles();
	    for (int i = 0; i < files.length; i++) {
	      if (files[i].isFile()) {
	    	  fileList.add(files[i].getName());
	      } else if (files[i].isDirectory()) {
	      }
	    }

        return fileList;
    }
}
