package Own_chat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class AffichageMain extends JPanel {

	/**
	 * 
	 */
	
	static long t;
	 
	private static final long serialVersionUID = 1L;
	
	static JFrame cadreaffichagemain = new JFrame("OwnChat");

	/*Menu */
	static JMenuBar menubarre = new JMenuBar();

	static JMenu fichier = new JMenu("Fichier");
	static JMenu options = new JMenu("Options");

	static JMenuItem quitter = new JMenuItem("Quitter");
	static JMenuItem preferences = new JMenuItem("Préférences");
	static JMenuItem save = new JMenuItem("Save session");
	
	/* END MENU */
	
	static JButton send = new JButton("Send");
	static JCheckBox mute = new JCheckBox("mute");

	static JTabbedPane PanneauAffChat = new JTabbedPane(1, JTabbedPane.SCROLL_TAB_LAYOUT);

	private MoteurItem moteuritem = new MoteurItem();
	private MoteurBoutons moteurboutons =  new MoteurBoutons();
	private MoteurTextArea moteurtextarea = new MoteurTextArea();

	static JPanel salon = new JPanel(new BorderLayout(0,0));
	
	private JScrollPane zoneScrolable;
	static JTextArea salon_text = new JTextArea();

	private JPanel write = new JPanel(new BorderLayout(0,0));

	
	static JTextField textwrite = new JTextField(70);
	
	
	
	static String srv = "127.0.0.1";
	static int port = 9500;
	static String name;

	
	
	

	
	
	
AffichageMain() throws IOException {

		
		
		super(new BorderLayout(5,5));
	    
		t = System.currentTimeMillis();
		
		//Create a menubar
		menubarre.add(fichier);
			fichier.add(quitter);
				quitter.addActionListener(moteuritem);
		menubarre.add(options);
			options.add(preferences);
				preferences.addActionListener(moteuritem);
			options.add(save);
				save.addActionListener(moteuritem);

		cadreaffichagemain.setJMenuBar(menubarre);
		
		
		add("Center",PanneauAffChat);
		
		write.add("West",textwrite);
		write.add("Center", mute);
		write.add("East",send);
		
		zoneScrolable=new JScrollPane(salon_text);
		salon.add(zoneScrolable,BorderLayout.CENTER);
		
		salon.add("South", write);
		
		
		
		send.addActionListener(moteurboutons );
		textwrite.addKeyListener(moteurtextarea );
		
		
		
		//add main room "salon" and set it non editable
		PanneauAffChat.addTab("Salon", salon);
		AffichageMain.salon_text.setEditable(false);
		
		PanneauAffChat.addFocusListener(moteurboutons);

		// set the frame content/ min/max size /center in the screen and finally set it visible
		cadreaffichagemain.setContentPane(this);
		cadreaffichagemain.setMinimumSize(new Dimension(300,300));
		cadreaffichagemain.setMaximumSize(new Dimension(300,300));
		cadreaffichagemain.pack();
		cadreaffichagemain.setLocationRelativeTo(null);
		cadreaffichagemain.setVisible(true);
		cadreaffichagemain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//new Connection("localhost", 9500);
		cadreaffichagemain.setDefaultCloseOperation(JFrame.ICONIFIED);
		new tray(cadreaffichagemain);
		new Choose_srv();
		
	}

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new AffichageMain();
	}

}
