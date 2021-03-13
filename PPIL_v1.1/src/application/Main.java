package application;

import java.net.ServerSocket;
import java.net.Socket;

import server.Receiver;
import ui.Window;


public class Main {

	@SuppressWarnings({"resource"})
	public static void main(String[] args) {
		try {
			ServerSocket serveur;
			serveur = new ServerSocket(9111);
			System.out.println("Drawing server started : " +serveur);
			ThreadGroup groupe;
			groupe = new ThreadGroup("socketClients");
			int noConnexion = 0;
			while(true) {
				Socket nouveauClientSocket;
				Receiver nouveauClientThread;
				nouveauClientSocket = serveur.accept();
				++noConnexion;
				System.out.println("Successful connection n° : "+noConnexion);
				Window W = new Window();
				W.setVisible(true);
				nouveauClientThread = new Receiver(nouveauClientSocket, groupe, W);
				nouveauClientThread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
} 


