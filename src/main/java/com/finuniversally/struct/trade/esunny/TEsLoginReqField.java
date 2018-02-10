package com.finuniversally.struct.trade.esunny;

/**
 * struct for login request field;
 * @author riseSun
 */
public class TEsLoginReqField {

	public static final char IS_CALOGIN_CA_LOGIN = 'Y';
	public static final char IS_CALOGIN_NOT_CA_LOGIN = 'N';

	private char IsCaLogin; 		//是否CA认证
	private char Identity;			//登录身份类型,目前只支持单客户
	private char IsForcePwd;		//是否强制修改密码
	private String ClientNo;		//客户号,代理客户号
	private String OperatorNo;		//操作员号,代理操作员号
	private String LoginPwd;		//登录密码
	private String NewPwd;			//强制修改密码登录时,新修改密码
	private String OtpPass;			//otp认证密码
	private int CaLen;				//CA信息长度，IsCaLogin为'Y'时，本字段有效
	private char CaInfo;			//CA登录时填写,IsCaLogin为'Y'时，本字段有效
	
	/**
	 * @param isCaLogin
	 * @param identity
	 * @param isForcePwd
	 * @param clientNo
	 * @param operatorNo
	 * @param loginPwd
	 * @param newPwd
	 * @param otpPass
	 * @param caLen
	 * @param caInfo
	 */
	public TEsLoginReqField(char isCaLogin, char identity, char isForcePwd, String clientNo, String operatorNo,
			String loginPwd, String newPwd, String otpPass, int caLen, char caInfo) {
		super();
		IsCaLogin = isCaLogin;
		Identity = identity;
		IsForcePwd = isForcePwd;
		ClientNo = clientNo;
		OperatorNo = operatorNo;
		LoginPwd = loginPwd;
		NewPwd = newPwd;
		OtpPass = otpPass;
		CaLen = caLen;
		CaInfo = caInfo;
	}
	
	public char getIsCaLogin() {
		return IsCaLogin;
	}
	public void setIsCaLogin(char isCaLogin) {
		IsCaLogin = isCaLogin;
	}
	public char getIdentity() {
		return Identity;
	}
	public void setIdentity(char identity) {
		Identity = identity;
	}
	public char getIsForcePwd() {
		return IsForcePwd;
	}
	public void setIsForcePwd(char isForcePwd) {
		IsForcePwd = isForcePwd;
	}
	public String getClientNo() {
		return ClientNo;
	}
	public void setClientNo(String clientNo) {
		ClientNo = clientNo;
	}
	public String getOperatorNo() {
		return OperatorNo;
	}
	public void setOperatorNo(String operatorNo) {
		OperatorNo = operatorNo;
	}
	public String getLoginPwd() {
		return LoginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}
	public String getNewPwd() {
		return NewPwd;
	}
	public void setNewPwd(String newPwd) {
		NewPwd = newPwd;
	}
	public String getOtpPass() {
		return OtpPass;
	}
	public void setOtpPass(String otpPass) {
		OtpPass = otpPass;
	}
	public int getCaLen() {
		return CaLen;
	}
	public void setCaLen(int caLen) {
		CaLen = caLen;
	}
	public char getCaInfo() {
		return CaInfo;
	}
	public void setCaInfo(char caInfo) {
		CaInfo = caInfo;
	}
	public static char getIsCaloginCaLogin() {
		return IS_CALOGIN_CA_LOGIN;
	}
	public static char getIsCaloginNotCaLogin() {
		return IS_CALOGIN_NOT_CA_LOGIN;
	}
}
