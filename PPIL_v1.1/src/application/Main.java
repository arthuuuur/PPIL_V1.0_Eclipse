package application;

import java.net.ServerSocket;
import java.net.Socket;
import Server.ReceveurEnvoyeur;
import graphics2D.Window;


public class Main {

	@SuppressWarnings({"resource"})
	public static void main(String[] args) {
		try {
			
			ServerSocket serveur;
			serveur = new ServerSocket(9111);
			System.out.println("Serveur de dessin demarre : " +serveur);
			ThreadGroup groupe;
			groupe = new ThreadGroup("socketClients");
			int noConnexion = 0;
			while(true) {
				Socket nouveauClientSocket;
				ReceveurEnvoyeur nouveauClientThread;
				nouveauClientSocket = serveur.accept();
				++noConnexion;
				System.out.println("Connexion reussie n° : "+noConnexion);
				Window W = new Window();
				W.setVisible(true);
				nouveauClientThread = new ReceveurEnvoyeur(nouveauClientSocket, groupe, noConnexion, W);
				nouveauClientThread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}


