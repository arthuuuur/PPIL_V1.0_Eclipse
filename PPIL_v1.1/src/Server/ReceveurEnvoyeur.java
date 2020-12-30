package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import graphics2D.Window2D;

public class ReceveurEnvoyeur extends Thread {
	
	private Socket socket;
	private BufferedReader fluxEntrant;
	private PrintStream fluxSortant;
	private Window2D W;
	
	public ReceveurEnvoyeur(Socket socket, ThreadGroup groupe, int noConnexion, Window2D W) throws IOException {
		super(groupe,"ReceveurEnvoyeur");
		this.socket = socket;
		this.W = W;
		fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		fluxSortant = new PrintStream(this.socket.getOutputStream());
	}
	
	public void traiterRequete(String requete) {
		W.getCor().detecter(requete, W);
	}
	
	public void run() {
		String requete;
		String reponse;
		try {
			while(!isInterrupted()) {
				requete = fluxEntrant.readLine();
				System.out.println("Requete client : " + requete);
				traiterRequete(requete);
				reponse = "Requete bien recu";
				fluxSortant.println(reponse);
				sleep(5);
			}
		} 
		catch(InterruptedException erreur) {}
		catch(IOException erreur) {System.out.println("On ne peut pas lire le socket provenant du client");}
	}
}

