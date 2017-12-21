package com.finuniversally.untils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TempClient{
	//客户端
	class Client implements Runnable{
		@Override
		public void run() {
			try {
				Socket socket = new Socket("127.0.0.1",12010);
				InputStream inputStream = socket.getInputStream();
				while(true) {
					int read = inputStream.read();
					Thread thread = new Thread(new TempClient().new Server(read));
					thread.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//服务端
	class Server implements Runnable{
		private int read = -1;
		public Server(int read) {
			this.read = read;
		}
		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(12013);
				while(true) {
					Socket accept = serverSocket.accept();
					OutputStream outputStream = accept.getOutputStream();
					outputStream.write(read);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		TempClient tempClient = new TempClient();
		Client client = tempClient.new Client();
		Thread clientThread = new Thread(client);
		clientThread.start();
	}
}
