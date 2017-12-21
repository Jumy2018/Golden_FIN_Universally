package com.finuniversally.untils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ThirdClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",12013);
			InputStream inputStream = socket.getInputStream();
			while(true) {
				int read = inputStream.read();
				System.out.println("接收到的值:["+(char)read+"]");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
