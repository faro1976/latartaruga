package it.latartaruga.sensoryturtles.zwave;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.apache.log4j.Logger;

import it.latartaruga.sensoryturtles.util.PropertiesHelper;



public class ZWaveInvoker {
	private String host;
	//private String cmdSwitch ="ZWaveAPI/Run/devices[%s].instances[0].Basic.Set(%s)";
	private String cmdSwitch ="/ZAutomation/api/v1/devices/%s/command/%s";
//	private String cmdRGBCtrl ="/Run/devices[3].instances[0].commandClasses[51].";
	private String cmdRGBCtrl ="/ZAutomation/api/v1/devices/%s/command/exact?%s";
	//http://192.168.0.2:8083/ZAutomation/api/v1/devices/ZWayVDev_zway_3-0-51-rgb/command/exact?red=255&green=0&blue=0
	//http://192.168.2.4:8083/ZAutomation/api/v1/devices/ZWayVDev_zway_2-0-37/command/off
	//http://192.168.0.2:8083/ZWave.zway/Run/devices[3].instances[0].commandClasses[51].Set(3,123)
//	Color Capability
//	 (0) Soft White
//	 (2) Red
//	 (3) Green
//	 (4) Blue	
	private String username;
	private String password;
	private final PropertiesHelper ph = PropertiesHelper.getInstance();
	private final Logger logger = Logger.getLogger(ZWaveInvoker.class);
		
	//http://YOURIP:8083/ZWaveAPI/Data/*	intero albero
	//http://YOURIP:8083/ZWaveAPI/Run/devices[*].*	device
	//http://YOURIP:8083/ZWaveAPI/Run/devices[x].instances[y].*	instance of device (i.e. socket strip)
	//http://YOURIP:8083/ZWaveAPI/Run/devices[x].instances[y].commandClasses[z].*	single command
		
		
	// /ZWaveAPI/Run/<command>	esegue comando
	// /ZWaveAPI/InspectQueue	ispeziona coda job
	// /ZWaveAPI/Data/<timestamp>	ritorna array dati cambiamenti da timestamp
		
	//example to switch ON a device no 2 using the command class BASIC (The ID of the command class BASIC is 0x20
	///ZWaveAPI/Run/devices[2].instances[0].commandClasses[0x20].Set(255)
	//or
	///ZWaveAPI/Run/devices[2].instances[0].Basic.Set(255) 		ON
	///ZWaveAPI/Run/devices[2].instances[0].Basic.Set(0) 		OFF

	public ZWaveInvoker() {		
		username = ph.getP().getProperty("sensoryturtles.zwave.uid");
		password = ph.getP().getProperty("sensoryturtles.zwave.pwd");
		host = ph.getP().getProperty("sensoryturtles.zwave.url");
	}
	
	public String invokeCmd (String devId, String type, String cmd) throws Exception{
		String urlStr = host + (type.equals(ZWaveCmd.RGB.toString()) ? cmdRGBCtrl : cmdSwitch);
		urlStr = String.format(urlStr, devId, cmd);
		URL url = new URL(urlStr);
		logger.info("execute ZWave command by URL [" + url.toString() + "]");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String authString = username + ":" + password;
		String authStringEnc = new String(Base64.getEncoder().encode(authString.getBytes()));
		conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			String errStr = "Failed ZWave command "+url.toString()+"; HTTP error code : "+ conn.getResponseCode();
			logger.error(errStr);
			throw new ZWaveException(errStr);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		logger.info("output from Razberry for command ["+cmd+"]: ");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
		
		return output;
		
	}

	
	public enum ZWaveCmd{
		SWITCH,
		RGB;
	}
	
	public class ZWaveException extends Exception{
		public ZWaveException(String message) {
			super(message);
		}		
	}
}
