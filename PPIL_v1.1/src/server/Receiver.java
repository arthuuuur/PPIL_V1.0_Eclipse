package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import corDetector.CircleDetector;
import corDetector.ShapeDetector;
import corDetector.PolygonDetector;
import corDetector.SegmentDetector;
import ui.Window;

/**
 * This class responsible for the conversation with a client. 
 * This class runs in a separate thread. 
 * For each new client that connects, a new instance of this class is created. 
 */
public class Receiver extends Thread {
	
	/**
	 * The socket for the communication between client and server
	 */
	private Socket socket;
	
	/**
	 * InputStream to receive message from the client
	 */
	private BufferedReader fluxEntrant;
	
	/**
	 * The window created for the client in which we will display these requests
	 * 
	 * @see #Window
	 */
	private Window W;
	
	/**
	 * The reponsability's chain to process the requets of the client
	 * 
	 * @see #ShapeDetector
	 */
	private ShapeDetector cor;
	
	/**
	 * ReceiverSender's constructor
	 * 
	 * @param socket The socket between client and server
	 * @param groupe the ThreadGroup
	 * @param W The window of the client
	 * 
	 * @throws IOException
	 */
	public Receiver(Socket socket, ThreadGroup groupe, Window W) throws IOException {
		super(groupe,"ReceveurEnvoyeur");
		this.socket = socket;
		this.W = W;
		fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		initCor();
	}
	
	/**
	 * Add a new ShapeDetector in the responsability's chain
	 * 
	 * @param d the new ShapeDetector
	 */
	public void ajouterDetecteur(ShapeDetector d) {
		d.setSuivant(cor);
		cor = d;
	}
	
	/**
	 * Getter of cor
	 * 
	 * @return The responsability's chain
	 */
	public ShapeDetector getCor() {
		return this.cor;
	}
	
	/**
	 * Initialize the responsability's chain with all the ShapeDetector
	 */
	public void initCor() {
		ajouterDetecteur(new SegmentDetector());
		ajouterDetecteur(new CircleDetector());
		ajouterDetecteur(new PolygonDetector());
	}
	
	/**
	 * Send to the responsability's chain the request of the client 
	 * 
	 * @param requete the request to be processed
	 * 
	 * @see ShapeDetector
	 */
	public void traiterRequete(String requete) {
		String[] data = requete.split(";");
		getCor().detecter(data, W);
	}
	
	/**
	 * The run method of this thread which permanently listening data from the client and processing them 
	 */
	public void run() {
		String requete;
		try {
			while(!isInterrupted()) {
				requete = fluxEntrant.readLine();
				System.out.println("Client request : " + requete);
				traiterRequete(requete);
				sleep(5);
			}
		} 
		catch(InterruptedException erreur) {}
		catch(IOException erreur) {System.out.println("Cannot read the socket coming from the client");}
	}
}

