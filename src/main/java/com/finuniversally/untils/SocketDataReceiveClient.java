package com.finuniversally.untils;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.finuniversally.service.impl.DealServiceImpl;
/**
 * 
 * 接收TCP数据
 * @author riseSun
 *
 * 2017年12月10日上午7:06:23
 */
public class SocketDataReceiveClient  implements Runnable {
	//由香港提供的数据是固定以HEAD;开头的
	private Pattern compile = Pattern.compile("HEAD;");
	//一条完整的交易数据的分号数量是11个
	private final int MAX_SEMICOLONS = 11;
	//平台套接字对象
	private PlatformSocket platformSocket;

	//初始化5个线程执行对应的下单(与否)操作
	private ExecutorService madeOrderThreadPool = Executors.newCachedThreadPool();

	public SocketDataReceiveClient(PlatformSocket platformSocket) {
		super();
		this.platformSocket = platformSocket;
	}

	@Override
	public void run() {
		try(InputStream inputStream = platformSocket.getSocket().getInputStream();){
			//HEAD;1000000;9000000;9000001;XAUUSD.e;50;1210.33;20171016162854;0;1;-2000; 
			int content = -1;
			StringBuilder sBuilder = new StringBuilder();
			int semicolons = 0;
			Matcher matcher = null ;
			while((content = inputStream.read()) != -1) {
				char ch = (char)content;
				System.out.println(ch);
				if(ch == ';') {
					++semicolons;
				}
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
						}
						if(start == 0 || semicolons == MAX_SEMICOLONS) {
							//System.out.println(sBuilder.toString());
							//完成一次交易数据的监听,将数据交于其他线程处理
							madeOrderThreadPool.execute(new DealServiceImpl(sBuilder.toString(),platformSocket.getPlatformName()));
							semicolons = 0;
							sBuilder.delete(0, sBuilder.length());
						}
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
