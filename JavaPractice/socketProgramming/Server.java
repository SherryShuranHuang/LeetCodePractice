package socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int PORT = 10023;
	static ServerSocket serverSocket;
	public static void init() {
		try{
			serverSocket = new ServerSocket(PORT);
			while(true){
				Socket client = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(),true);
				String line = in.readLine();
				out.println("your input is"+line);
				out.close();
				in.close();
				//client.close();
			}
			
		}catch(Exception e){
			System.out.println("Server is not properly acting"+e.getMessage());
		}finally {    
			try{
				serverSocket.close();
			}catch(Exception e){
				System.out.println("Server is not properly acting"+e.getMessage());
			}
        }   
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.init();
	}

}
