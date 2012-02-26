package Own_chat;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;



public class Moteur_Socket_TCP extends Thread implements Runnable{

	final static int port_c = 9500;
	static int taille = 1024;
	static byte buffer[] = new byte[taille];
	static  Socket socket = null;
	
	long t;

	
	
	
	

	public Moteur_Socket_TCP(){
		
		

	}
	public static Socket Create_Socket_TCP(String srv, int port){
		
		socket = new Socket(); 
		try {
				socket.setKeepAlive(true);
				socket.connect(new InetSocketAddress(srv, port), 10000);
				
			} catch (IllegalArgumentException e) {
				
				javax.swing.JOptionPane.showMessageDialog(null, "Illegal Arguments\n");
				return(null);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				
				javax.swing.JOptionPane.showMessageDialog(null, "Unknow Host\n");
				return(null);
			} catch (InterruptedIOException e){
				
				javax.swing.JOptionPane.showMessageDialog(null, "Timeout\n");
				return(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				javax.swing.JOptionPane.showMessageDialog(null, "Error during connection\nServer may be down\n");
				return(null);
			}
		
		return(socket);

	}
	
	public static int Send_TCP(Socket socket, String message) {
			// TODO Auto-generated constructor stub
			
			
		try {
			BufferedWriter outToServer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream(), "ISO-8859-1"));
			outToServer.write(message);
			outToServer.flush();
		} catch (InterruptedIOException e) {
			// TODO Auto-generated catch block
			
			javax.swing.JOptionPane.showMessageDialog(null, "Timeout\n");
			return (-1);

		}catch (IOException e) {
			// TODO Auto-generated catch block
			
			javax.swing.JOptionPane.showMessageDialog(null, "Error sending data\n");
			return (-1);
			
		}
		return (0);
	
	 }
	

 
	
	public void run(){
		
		for(;;){
			
			try {
			    
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(),"ISO-8859-1"));
			    
				String donnees = inFromServer.readLine();
				
				
				taille = donnees.length();
			    
			    AffichageMain.salon_text.append(donnees+"\n");	
			    AffichageMain.salon_text.setCaretPosition(AffichageMain.salon_text.getDocument().getLength()); 
			    
			    
			    
			    // play sound each 5 messages received when windows is not focused and sound is not already playing 
			    if(!AffichageMain.cadreaffichagemain.isFocused()  && ( ( (System.currentTimeMillis()) - (AffichageMain.t)) > 10000) 
			    			&& (!AffichageMain.mute.isSelected()) ){
			    	MoteurAudio s = new MoteurAudio("message2.wav");
			    	s.playSoundOnce();
			    	AffichageMain.t = System.currentTimeMillis();   	
			    }
			    
			    
			    
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				
				javax.swing.JOptionPane.showMessageDialog(null, "Connection with server reset\n");
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				javax.swing.JOptionPane.showMessageDialog(null, "Error Reading data\n");
				break;
			} 
			    
			
		}	
	}
}
