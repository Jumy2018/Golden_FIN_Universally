package com.finuniversally.untils;

import java.io.InputStream;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * 接收TCP数据
 * @author riseSun
 *
 * 2017年12月10日上午7:06:23
 */
public class Client  implements ServletContextListener {

	private Pattern compile = Pattern.compile("[a-zA-Z]{4};");

	private final int MAX_SEMICOLONS = 11;

	// 连接到服务器
	public void go() {
		try(
			//Socket socket = new Socket("116.62.195.204", 12000);
			Socket socket = new Socket("127.0.0.1",5000);
			InputStream inputStream = socket.getInputStream();	
				){
			//HEAD;1000000;9000000;9000001;XAUUSD.e;50;1210.33;20171016162854;0;1;-2000; 
			int content = -1;
			StringBuilder sBuilder = new StringBuilder();
			int semicolons = 0;
			Matcher matcher = null ;
			while((content = inputStream.read()) != -1) {
				char ch = (char)content;
				if(ch == ';') semicolons++;
				sBuilder.append(ch);
				if(semicolons == MAX_SEMICOLONS) {
					matcher = compile.matcher(sBuilder);
					if(matcher.find()) {
						int start = matcher.start();
						if(start != 0) {
							sBuilder.delete(0, start);
							semicolons = 0;
							for(int i = 0; i < sBuilder.length() ;i ++) {
								if(sBuilder.charAt(i) == ';') 
									++semicolons;
							}
							continue;
						}else {
							//TODO sBuilder.toString()
							System.out.println(sBuilder.toString());
							semicolons = 0;
							sBuilder.delete(0, sBuilder.length());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		new Client().go();
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		new Client().go();
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("无法再次为您提供tcp数据!");
	}

}
