package socketProgramming;

import java.io.BufferedReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HandlerThread implements Runnable{
	private Socket client;    
	public HandlerThread(Socket client) {    
		this.client = client;    
		new Thread(this).start();    
	}    

	public void run() {    
		try {    
			// 读取客户端数据    
			DataInputStream input = new DataInputStream(client.getInputStream());  
			// 向客户端回复信息    
			//DataOutputStream out = new DataOutputStream(client.getOutputStream());    
			PrintStream out = new PrintStream(client.getOutputStream());  
			System.out.print("请输入:\t");    
			// 发送键盘输入的一行    
			//String s = new BufferedReader(new InputStreamReader(System.in)).readLine();   
			String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException  
			// 处理客户端数据    
			System.out.println("客户端发过来的内容:" + clientInputStr);    
			//out.writeUTF(s);   
			out.println("Your input is"+clientInputStr);

			out.close();    
			input.close();    
		} catch (Exception e) {    
			System.out.println("服务器 run 异常: " + e.getMessage());    
		} finally {    
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

	}

}
