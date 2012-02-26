package Own_chat;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class MoteurAudio
{

	
		private AudioClip song; // Sound player
		private URL songPath; // Sound path
		
		MoteurAudio(String filename)
		{
			try
			{
				songPath = getClass().getResource(filename); // Get the Sound URL
				song = Applet.newAudioClip(songPath); // Load the Sound
			}
			catch(Exception e){} // Satisfy the catch
		}
		public void playSound()
		{
			song.loop(); // Play 
		}
		public void stopSound()
		{
			song.stop(); // Stop
		}
		public void playSoundOnce()
		{
			song.play(); // Play only once
		}
		
		
}