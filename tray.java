package Own_chat;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;


import javax.swing.JFrame;

	public class tray {
		/**
		 * 
		 */
		
		public tray(JFrame s) {
			
			SystemTray tray = SystemTray.getSystemTray();
			
			
			URL imgUrl = getClass().getResource("tray.png");
			
			Image img = Toolkit.getDefaultToolkit().getImage(imgUrl);
			
			PopupMenu popup = new PopupMenu();
			MenuItem Item1 = new MenuItem("Quitter");
		
			Item1.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					// TODO Auto-generated method stub
					try {
						
						Connection.socket_tcp.close();
						
					} catch (NullPointerException e) {
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						
						javax.swing.JOptionPane.showMessageDialog(null, "Error during disconnection\n");

					} 
					System.exit(0);       
			
				}
			});
		
			
			popup.add(Item1);

			TrayIcon trayicon = new TrayIcon(img, "OwnChat", popup);
			trayicon.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					AffichageMain.cadreaffichagemain.setVisible(true);
					
				}
			});
			
			try {
					tray.add(trayicon);
			} catch (AWTException e) {
					System.err.println("Problem loading Tray icon");
			}
		}

		


			
}
