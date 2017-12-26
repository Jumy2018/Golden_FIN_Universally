package com.finuniversally.model;

/**
 * 账户信息视图类
 * @author riseSun
 *
 * 2017年12月26日上午1:34:55
 */
public class AccountVo {
	
	
	//ID
	private String id;
	//用户名
	private String username;
	//平台名称
	private String platformName;
	//平台ID
	private String platformId;
	//密码
	private String password;

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
