package it.latartaruga.sensoryturtles.mplayer;

import java.io.IOException;

public interface IMPlayer {
	public void play(String file) throws IOException;
	public void exit() throws IOException;
	public void rewind()throws IOException;
	public void fastforward()throws IOException;
	public void pauseResume()throws IOException;
	public void volUp()throws IOException;
	public void volDown()throws IOException;
}
