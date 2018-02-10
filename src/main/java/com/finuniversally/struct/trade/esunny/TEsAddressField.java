package com.finuniversally.struct.trade.esunny;

/**
 * Struct for function-open connection
 * @author riseSun
 */
public class TEsAddressField {
	
	private int port; 		//端口号
	private String ip; 		//ip地址
	
	/**
	 * @param port
	 * @param ip
	 */
	public TEsAddressField(int port, String ip) {
		super();
		this.port = port;
		this.ip = ip;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
