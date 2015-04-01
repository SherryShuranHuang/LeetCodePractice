package socketProgramming;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * multi-threaded socket server
 * 
 * http://blog.csdn.net/fjseryi/article/details/12677803
 * @author yellow
 *
 */
public class Server {
	public static final int PORT = 12323;
	static ServerSocket serverSocket;
	static Socket client;
	public static void init() {
		try{
			//System.out.println("close server works!");
			serverSocket = new ServerSocket(PORT);
			while(true){
				client = serverSocket.accept();
				new HandlerThread(client);

			}
			
		}catch(Exception e){
			System.out.println("Server is not properly acting"+e.getMessage());
		}
		finally{
			System.out.println("close server");
			try {  
				serverSocket.close();  
			} catch (IOException e) {  
				serverSocket = null;   
				System.out.println("¿Í»§¶Ë finally Òì³£:" + e.getMessage());   
			}  

		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.init();
	}

}
