package Own_chat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Choose_srv{

	static JFrame wind = new JFrame("Server Information");
	static JPanel pan = new JPanel();
	static JButton ok;
	static JTextField srv;
	static JTextField port;
	static JTextField name;
	static JTextField proxy;
	static JTextField proxy_port;
	
	public Choose_srv() {
		
		// TODO Auto-generated constructor stub
		wind.setSize(300, 150);
		wind.setLocationRelativeTo(null);
		
		name = new JTextField("username", 12);
		srv = new JTextField("www.coeurhacker.org", 20);
		proxy = new JTextField("proxy_server", 20);
		proxy_port = new JTextField("proxy_port", 6);
		port = new JTextField("9500", 6);
		ok = new JButton("Valider");
		
		pan.add(name);
		name.setHorizontalAlignment(JTextField.CENTER);
		pan.add(srv);
		srv.setHorizontalAlignment(JTextField.CENTER);
		pan.add(port);
		port.setHorizontalAlignment(JTextField.CENTER);
		pan.add(ok);
		
		ok.addActionListener(new MoteurItem());
		wind.add(pan);
		wind.setVisible(true);
	}
}
