package it.latartaruga.sensoryturtles.zwave;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.apache.log4j.Logger;



public class ZWaveInvoker {
	private String host = "http://192.168.0.2:8083/ZWaveAPI";
	private String cmdSwitch ="/Run/devices[2].instances[0].Basic.";
	private String cmdRGBCtrl ="";
	private String username = "admin";
	private String password = "faro1976";
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

	public String invokeCmd (String devId, ZWaveCmd cmd) throws Exception{
		URL url = new URL(String.format("%s/Run/devices[%s].instances[0].%s", host, devId, cmd.getCmd()));
		logger.info("execute ZWave command [" + url.toString() + "]");
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
		SWITCH_ON("Basic.Set(255)"),
		SWITCH_OFF("Basic.Set(0)"),
		SET_RGB("");
		
		private String cmd;
		public String getCmd() {
			return cmd;
		}
		private ZWaveCmd(String cmd) {
			this.cmd=cmd;
		}
	}
	
	public class ZWaveException extends Exception{
		public ZWaveException(String message) {
			super(message);
		}		
	}
}
