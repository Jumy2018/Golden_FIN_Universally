package com.finuniversally.vo;

import com.finuniversally.untils.SocketDataReceiveClient;
import com.finuniversally.untils.ThreadPoolUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

/**
 * 该类用于启动所有TCP数据监听
 *
 * @author riseSun
 *         <p>
 *         2017年12月12日下午8:50:57
 */
public class InitSocketDataReceiveListener implements ServletContextListener {

    private ExecutorService fixedThreadPool  ;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    //初始化所有的TCP数据监听
    @Override
    public void contextInitialized(ServletContextEvent sce) {
		//75平台
		//Socket socket75 = null;
            //获取香港操宝盘的76平台交易数据
            //SocketDataReceiveClient socketDataReceiveClient76 = new SocketDataReceiveClient(new PlatformSocket(socket76,"orders76"));

            //启用数据监听
           // SocketDataReceiveClient socketDataReceiveClient75 = new SocketDataReceiveClient(new PlatformSocket(socket75, "orders75"));
            //获取香港操宝盘的75平台交易数据

     SocketDataReceiveClient socketDataReceiveClient75 = new SocketDataReceiveClient();

           // fixedThreadPool.execute(socketDataReceiveClient75);
        ThreadPoolUtil.getInstance().getThreadPoole().execute(socketDataReceiveClient75);
       /* }*/
    }

    //销毁所有TCP监听
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        fixedThreadPool.shutdownNow();
    }
}
