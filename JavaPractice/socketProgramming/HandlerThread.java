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
			// ��ȡ�ͻ�������    
			DataInputStream input = new DataInputStream(client.getInputStream());  
			// ��ͻ��˻ظ���Ϣ    
			//DataOutputStream out = new DataOutputStream(client.getOutputStream());    
			PrintStream out = new PrintStream(client.getOutputStream());  
			System.out.print("������:\t");    
			// ���ͼ��������һ��    
			//String s = new BufferedReader(new InputStreamReader(System.in)).readLine();   
			String clientInputStr = input.readUTF();//����Ҫע��Ϳͻ����������д������Ӧ,������� EOFException  
			// ����ͻ�������    
			System.out.println("�ͻ��˷�����������:" + clientInputStr);    
			//out.writeUTF(s);   
			out.println("Your input is"+clientInputStr);

			out.close();    
			input.close();    
		} catch (Exception e) {    
			System.out.println("������ run �쳣: " + e.getMessage());    
		} finally {    
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

	}

}
