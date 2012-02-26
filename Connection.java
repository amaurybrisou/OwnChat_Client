package Own_chat;

import java.net.Socket;

public class Connection {

	public static Socket socket_tcp;
	public static Moteur_Socket_TCP srv_tcp;
	private Alive alive;

	public Connection(String srv, int port) {
		// TODO Auto-generated constructor stub
		socket_tcp = Moteur_Socket_TCP.Create_Socket_TCP(srv, port);
		if( socket_tcp != null ){
			Moteur_Socket_TCP.Send_TCP(Connection.socket_tcp, AffichageMain.name);
			srv_tcp = new Moteur_Socket_TCP();
			srv_tcp.setDaemon(true);
			srv_tcp.start();
			Choose_srv.wind.dispose();
			
			alive = new Alive();
			alive.setDaemon(true);
			alive.start();
			
		}
	}
	
}
