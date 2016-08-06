package it.latartaruga.sensoryturtles.zwave;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class ZWaveInvoker {
	private String host = "http://192.168.0.2:8083/ZWaveAPI";
	private String cmdSwitch ="/Run/devices[2].instances[0].Basic.";
	private String cmdRGBCtrl ="";
	private String username = "admin";
	private String password = "faro1976";
		
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

	public String invokeCmd (String value) throws Exception{
		URL url = new URL(host+cmdSwitch+value);
		System.out.println(url.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String authString = username + ":" + password;
		String authStringEnc = new String(Base64.getEncoder().encode(authString.getBytes()));
		conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new ZWaveException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("output from Razberry: ");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
		
		return output;
		
	}

	public class ZWaveException extends Exception{
		public ZWaveException(String message) {
			super(message);
		}		
	}
}
