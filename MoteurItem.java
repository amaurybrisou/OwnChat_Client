package Own_chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import javax.swing.JWindow;




public  class MoteurItem  extends JWindow implements ActionListener, MouseListener {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton ok = Choose_srv.ok;

	public void actionPerformed (ActionEvent evt) {
		// TODO Auto-generated method stub
		JComponent event = (JComponent) evt.getSource();
		
		
		
		if (event == AffichageMain.quitter  ) {
			try {
				
				Connection.socket_tcp.close();
				
			} catch (NullPointerException e) {
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				javax.swing.JOptionPane.showMessageDialog(null, "Error during disconnection\n");

			} 
			
			System.exit(0);       
	
		} else if (event == AffichageMain.preferences){
			Choose_srv.wind.setVisible(true);
			
		} else if (event == AffichageMain.save){ // save session into a file
			JFileChooser fc = new JFileChooser("/home/erol/Documents/c/chat_server");
			int ret_val = fc.showSaveDialog(null);
			if(ret_val == JFileChooser.APPROVE_OPTION){
				try {
					BufferedWriter f_stream = new BufferedWriter(new FileWriter(fc.getSelectedFile()));
					f_stream.write(AffichageMain.salon_text.getText());
					f_stream.close();
				} catch (IOException e) {
					javax.swing.JOptionPane.showMessageDialog(fc, "Error Saving File\n");
				}
			}
			
		} else if ( event == ok){
			
			AffichageMain.salon_text.setText("");
			AffichageMain.srv = Choose_srv.srv.getText();
			try {
				AffichageMain.port = Integer.parseInt(Choose_srv.port.getText());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AffichageMain.name = Choose_srv.name.getText();
			
			if(Connection.socket_tcp != null){
				try {
					Connection.socket_tcp.shutdownOutput();
					Connection.srv_tcp.stop(); //this thread is totally independent 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					javax.swing.JOptionPane.showMessageDialog(null, "Error during disconnection\n");

				}
			}
			
			
			new Connection(AffichageMain.srv, AffichageMain.port);
			
			
		} 
}
		
	    


	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	
}
