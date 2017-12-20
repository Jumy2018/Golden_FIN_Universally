package com.finuniversally.listeners;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.finuniversally.untils.ConfigUtil;
import com.finuniversally.untils.SocketDataReceiveClient;

/**
 * 该类用于启动所有TCP数据监听
 * @author riseSun
 *
 * 2017年12月12日下午8:50:57
 */
public class InitSocketDataReceiveListener implements ServletContextListener{

	private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

	//初始化所有的TCP数据监听
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if(!ConfigUtil.getBoolValue(ConfigUtil.INIT_SOCKETDATA_RECEIVE_LISTENER_ENABLE)) {
			return ;
		}
		//75平台
		Socket socket75 = null;
		//76平台
		Socket socket76 = null;
		try {

			socket75 = new Socket("116.62.195.204",12000);

			socket76 = new Socket("116.62.195.204",12001);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		SocketDataReceiveClient socketDataReceiveClient75 = new SocketDataReceiveClient(socket75); 

		SocketDataReceiveClient socketDataReceiveClient76 = new SocketDataReceiveClient(socket76);

		fixedThreadPool.execute(socketDataReceiveClient75);

		fixedThreadPool.execute(socketDataReceiveClient76);
	}

	//销毁所有TCP监听
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		fixedThreadPool.shutdownNow();
	}
}
