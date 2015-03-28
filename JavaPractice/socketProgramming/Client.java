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
		System.out.println("客户端启动...");    
        System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");
		try
		{
			socket = new Socket(IP_ADDR,PORT);
			if(socket.isConnected()) System.out.println("Connected to the localhost");
			DataInputStream input = new DataInputStream(socket.getInputStream()); 
			DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
			System.out.print("请输入: \t");    
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();    
            out.writeUTF(str); 
            
            String ret = input.readUTF();     
            System.out.println("服务器端返回过来的是: " + ret);    
            
            // 如接收到 "OK" 则断开连接    
            if ("OK".equals(ret)) {    
                System.out.println("客户端将关闭连接");    
                //Thread.sleep(500);    
                //break;    
            }else{
            	System.out.println("客户端连接");  
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
                    System.out.println("客户端 finally 异常:" + e.getMessage());   
                }  
            }  
        }
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Client();
	}

}
