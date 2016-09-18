package it.latartaruga.sensoryturtles.mplayer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class Omxplayer implements IMPlayer {
	private static final Logger logger = Logger.getLogger(Omxplayer.class);
	private static Omxplayer player = null;
	private Process p;
	private InputStream is;
	private OutputStream os;
	private InputStream es;
	
	
	//TODO ROB: spostare in factory
	public static final IMPlayer getInstance(){
		if (player==null) player = new Omxplayer();
		return player;
	}
	
	@Override
	public void play(String file)throws IOException {
		String fullPath = "/home/pi/tarta/media/" + file;
		logger.info("play file " + fullPath);
		p = Runtime.getRuntime().exec("omxplayer -o hdmi " + fullPath);
		logger.info("Omxplayer started");
		is = p.getInputStream();
		os = p.getOutputStream();
		es = p.getErrorStream();
	}

	@Override
	public void exit()  throws IOException {
		os.write("q".getBytes());
		os.flush();
		p.destroy();
	}

	@Override
	public void rewind() throws IOException {
		os.write("<".getBytes());
		os.flush();
	}

	@Override
	public void fastforward() throws IOException{
		os.write(">".getBytes());
		os.flush();
	}

	@Override
	public void pauseResume() throws IOException{
		os.write("p".getBytes());
		os.flush();
	}

	@Override
	public void volUp() throws IOException{
		os.write("+".getBytes());
		os.flush();


	}

	@Override
	public void volDown() throws IOException{
		os.write("-".getBytes());
		os.flush();


	}

	public static void main(String[] args) {
		try {
			IMPlayer player = Omxplayer.getInstance();
			player.play("IMG_0022.MOV");
			Thread.sleep(5000);
			player.pauseResume();
			Thread.sleep(5000);
			player.pauseResume();
			Thread.sleep(5000);
			player.exit();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
