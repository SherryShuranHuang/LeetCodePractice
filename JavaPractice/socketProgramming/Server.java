package socketProgramming;

import java.io.BufferedReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int PORT = 10022;
	static ServerSocket serverSocket;
	static Socket client;
	public static void init() {
		try{
			serverSocket = new ServerSocket(PORT);
			while(true){
				client = serverSocket.accept();
				DataInputStream input = new DataInputStream(client.getInputStream()); 
				String clientInputStr = input.readUTF();//����Ҫע��Ϳͻ����������д������Ӧ,������� EOFException  
                // ����ͻ�������    
                System.out.println("�ͻ��˷�����������:" + clientInputStr);
                // ��ͻ��˻ظ���Ϣ    
                DataOutputStream out = new DataOutputStream(client.getOutputStream());    
                System.out.print("������:\t");    
                // ���ͼ��������һ��    
                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();    
                out.writeUTF(s);    
                  
                out.close();    
                input.close();    

			}
			
		}catch(Exception e){
			System.out.println("Server is not properly acting"+e.getMessage());
		}finally {    
			if (client != null) {    
                try {    
                    client.close();    
                } catch (Exception e) {    
                	client = null;    
                    System.out.println("����� finally �쳣:" + e.getMessage());    
                }    
            }   
        }   
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.init();
	}

}
