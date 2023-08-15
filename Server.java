package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<>(); // Contains all the Client sockets
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
//		Socket socket = serverSocket.accept();
		handleClientRequest();
	}
	
	//Multiple Client HandShaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket = serverSocket.accept(); // Handshaking
			// Per client per thread
			ServerWorker serverWorker = new ServerWorker(clientSocket,this);// Creating a New Worker/Thread
			workers.add(serverWorker);
			serverWorker.start();
			
		    }
	}
	
	
	/*Single client*/
	/*
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
	    System.out.println("Server Started and Waiting for the client Connection....");
	    Socket socket = serverSocket.accept();  /// Handshaking
		System.out.println("Client joins the server");
		InputStream in = socket.getInputStream(); // read bytes from the network
		byte arr[] = in.readAllBytes();
		String str = new String(arr); //Bytes convert into STRING
		System.out.println("Message Rec from the Client "+str);
		in.close();
		socket.close();
	}*/

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Server server = new Server();
	}

}
