package com.finuniversally.model;

/**
 * 系统登陆用户
 * @author riseSun
 *
 * 2017年12月23日下午5:51:17
 */
public class User {
	private Long id;
	//平台
	private CustomerPlatform platform;
	//账户名
	private String userName;
	//盐码
	private String keyWord;
	//密文
	private String pwd;
	//手机号
	private String phoneNum;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CustomerPlatform getPlatform() {
		return platform;
	}
	public void setPlatform(CustomerPlatform platform) {
		this.platform = platform;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
