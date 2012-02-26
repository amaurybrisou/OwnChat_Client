package Own_chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.Socket;


import javax.swing.JTextField;




public class MoteurBoutons implements ActionListener,  FocusListener {


	private JTextField TextWrite;
	private Socket socket_tcp;

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// init local variables

		this.TextWrite = AffichageMain.textwrite;
		this.socket_tcp = Connection.socket_tcp;
		
		String message = TextWrite.getText();
		 
		 if(message.isEmpty());// if message if empty do nothin 
		 else { 				//else write message variable  textarea from the currently selected tab
		 
			 AffichageMain.textwrite.setText("");  //clear JTextfield
			 
			 
			 
			
			 //for( int i = 0; i < AffichageMain.nb_user ; i++){
				 
					 Moteur_Socket_TCP.Send_TCP(socket_tcp, message);
				  
			// }
			 
		 }
	}
	

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
