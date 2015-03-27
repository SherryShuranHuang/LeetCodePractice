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
				String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException  
                // 处理客户端数据    
                System.out.println("客户端发过来的内容:" + clientInputStr);
                // 向客户端回复信息    
                DataOutputStream out = new DataOutputStream(client.getOutputStream());    
                System.out.print("请输入:\t");    
                // 发送键盘输入的一行    
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
                    System.out.println("服务端 finally 异常:" + e.getMessage());    
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
