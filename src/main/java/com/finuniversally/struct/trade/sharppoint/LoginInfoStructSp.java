package com.finuniversally.struct.trade.sharppoint;

import com.finuniversally.struct.trade.AbstractLoginInfoStruct;

/**
 * Sp接口登录用的结构体
 * @author riseSun
 *
 * 2018年2月10日下午9:09:29
 */
public class LoginInfoStructSp extends AbstractLoginInfoStruct{
	
	private String host; 			//服务器地址
	private int port; 				//连接端口
	private String license;			//许可加密字符串
	private String appId;			//应用编号 
	private String userId;			//用户名
	private String password;		//用户密码
	
	public LoginInfoStructSp(String host, int port, String license, String appId, String userId, String password) {
		super();
		this.host = host;
		this.port = port;
		this.license = license;
		this.appId = appId;
		this.userId = userId;
		this.password = password;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
