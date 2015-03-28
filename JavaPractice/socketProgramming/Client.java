package socketProgramming;

import java.io.*;
import java.net.*;

public class Client {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public static final String IP_ADDR = "localhost";
	public static final int PORT = 12349;

	public Client() throws IOException
	{
		System.out.println("�ͻ�������...");    
        System.out.println("�����յ����������ַ�Ϊ \"OK\" ��ʱ��, �ͻ��˽���ֹ\n");
		try
		{
			socket = new Socket(IP_ADDR,PORT);
			if(socket.isConnected()) System.out.println("Connected to the localhost");
			DataInputStream input = new DataInputStream(socket.getInputStream()); 
			DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
			System.out.print("������: \t");    
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();    
            out.writeUTF(str); 
            
            String ret = input.readUTF();     
            System.out.println("�������˷��ع�������: " + ret);    
            
            // ����յ� "OK" ��Ͽ�����    
            if ("OK".equals(ret)) {    
                System.out.println("�ͻ��˽��ر�����");    
                //Thread.sleep(500);    
                //break;    
            }else{
            	System.out.println("�ͻ�������");  
            }
              
            out.close();  
            input.close();  

		}
		catch (UnknownHostException e){
			System.err.println("Don't know about host: hostname");
		}catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname  " + e.getMessage());
        }finally {  
            if (socket != null) {  
                try {  
                    socket.close();  
                } catch (IOException e) {  
                    socket = null;   
                    System.out.println("�ͻ��� finally �쳣:" + e.getMessage());   
                }  
            }  
        }
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Client();
	}

}
