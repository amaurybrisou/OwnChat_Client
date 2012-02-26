package Own_chat;


public class Alive extends Thread implements Runnable{

	public Alive(){
	
	}
	public void run(){
		while(true){
				
			
				
				if( (Moteur_Socket_TCP.Send_TCP(Moteur_Socket_TCP.socket, "\0")) == 0){
					try {
						sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
				
				//AffichageMain.reftime = System.currentTimeMillis();
	    	}
		}
	}

