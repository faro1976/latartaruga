package it.latartaruga.sensoryturtles.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {
	private static PropertiesHelper ph = null;
	private Properties p=null;
	public static final String CFG_PATH = System.getProperty("user.home") + "/sensoryturtles/";
	
	public static final PropertiesHelper getInstance(){
		if (ph==null) ph = new PropertiesHelper();
		return ph;
	}
	
	public PropertiesHelper() {
		p = new Properties();
		try {
			p.load(new FileInputStream(new File(CFG_PATH +"sensoryturtles.properties")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Properties getP() {
		return p;
	}
}
