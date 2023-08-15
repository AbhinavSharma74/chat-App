package com.brainmentors.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

// Thread == Worker
// Worker need a Job to Perform
// For Job u give runnable
// Once job is created via Runnable so write the job logic inside a run function
// Assign the job to a Thread

public class ServerWorker extends Thread{
	private static Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	
	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		this.server = server;
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream(); // Client Data Read
		out = clientSocket.getOutputStream(); // Client Data Write
		System.out.println("New Client comes ");
	}

//public class ServerWorker implements Runnable { // RUNNABLE is used when your class inherits another class

//public class ServerWorker extends Thread{   // Thread can be used instead of Runnable because Thread INTERNALLY implements "Runnable".
	
	@Override
	public void run() {
		//Read Data from the client and broadcast the data to all
		BufferedReader br = new BufferedReader(new InputStreamReader(in)); // Line by Line read
		String line;
		try {
		while(true) {
			line = br.readLine();
			System.out.println("Line read..." + line);
				if (line.equalsIgnoreCase("quit")) {
					break; //Client chat End
				}
//				out.write(line.getBytes()); //Client send
				//Broadcast to all client
				for(ServerWorker serverWorker : server.workers) {
					line = line + "\n";
					serverWorker.out.write(line.getBytes());
				}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		finally {
			try {
			if (br!=null) {
				br.close();
			}
			if (in!=null) {
				in.close();
			}
			if (out!=null) {
				out.close();
			}
			if (clientSocket!=null) {
				clientSocket.close();
			}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}	
		}
		
		
		// Job to be Performed
		// Logic
		for(int i = 1; i<=5; i++) {
			System.out.println("RUN I is "+i+" "+Thread.currentThread());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			}
//	public static void main(String[] args) {
////		ServerWorker job = new ServerWorker();          //Job is created in this 
//		ServerWorker worker = new ServerWorker(clientSocket, server);       // We can directly start the worker using Thread
//		worker.start();
//		// Assign the job to a thread/Worker            //there is no need to make a worker and assign job when using extend Thread
////		Thread worker = new Thread(job,"Worker1");
////		worker.start(); // Internally it call run()
//		for(int j=1; j<=5; j++) {
//			System.out.println("Main "+j+ " "+Thread.currentThread());
//		}
//	}

}
