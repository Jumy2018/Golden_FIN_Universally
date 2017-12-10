package com.finuniversally.untils;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest{
	private String testData = ";XAUUSD.e;50;1210.33;20171016162854;0;1;-2000"
			+ ";HEAD;1000000;9000000;9000001;XAUUSD.e;50;1210.33;"
			+ "20171016162854;0;1;-2000;HEAD;1000000;9000000;9000"
			+ "001;XAUUSD.e;50;1210.33;20171016162854;0;1;-2000;HE"
			+ "AD;1000000;9000000;9000001;XAUUSD.e;50;1210.33;20171"
			+ "016162854;0;1;-2000;HEAD;1000000;9000000;9000001;XAUU"
			+ "SD.e;50;1210.33;20171016162854;0;1;-2000;";
	public void go(){
		try{
			ServerSocket ss = new ServerSocket(5000);
			//进入无限循环等待用户的链接
			while(true){
				//进行监听，接受客户端套接字的链接
				Socket socket = ss.accept();
				PrintStream ps  =  new PrintStream(socket.getOutputStream());
				while(true){
					ps.println(testData);
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new ServerTest().go();
	}

}
