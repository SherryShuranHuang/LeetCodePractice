package socketProgramming;

import java.io.*;
import java.net.*;

public class Client {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	public Client() throws IOException
	{
		try
		{
			socket = new Socket("hostname", 10023);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
			out.println(line.readLine());
			line.close();
			out.close();
			in.close();
			socket.close();
		}
		catch (UnknownHostException e){
			System.err.println("Don't know about host: hostname");
		}catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Client();
	}

}
