package Own_chat;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.Socket;

public class MoteurTextArea implements KeyListener {

	


	private Socket socket_tcp;

	@Override
	public void keyPressed(KeyEvent e) {
		
		// init local variables
		
		
		this.socket_tcp = Connection.socket_tcp;
		
		String message = AffichageMain.textwrite.getText(); //get written message into the Textfield
		 if(e.getKeyCode() == KeyEvent.VK_ENTER ){ //if enter is pressed 
			 if(message.isEmpty());// if message if empty do nothin 
			 else {				//else write message variable  textarea from the currently selected tab
			 
				 AffichageMain.textwrite.setText("");  //clear JTextfield
				 Moteur_Socket_TCP.Send_TCP(socket_tcp, message);
				 
			 	}
		 }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
