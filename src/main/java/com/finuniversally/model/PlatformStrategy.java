package com.finuniversally.model;
/**
 * 平台跟单
 * @author riseSun
 *
 * 2017年12月23日上午1:11:29
 */
public class PlatformStrategy {

	private Long id;
	//平台
	private CustomerPlatform platform;
	//品种
	private Variety variety;
	//跟单账号
	private Account account;
	//正向跟单/反向跟单
	private int direction;
	//净头寸基值
	private Double baseNetPosition;
	//净头寸变化频率
	private Double netPositionChangedFrequency;
	//跟单手数
	private Double followingCount;
	//单笔止盈
	private Double singleProfitLimit;
	//单笔止损
	private Double singleLoseLimit;
	//跟单止损
	private Double orderLostLimit;
	
	
	
	
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
	public Variety getVariety() {
		return variety;
	}
	public void setVariety(Variety variety) {
		this.variety = variety;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public Double getBaseNetPosition() {
		return baseNetPosition;
	}
	public void setBaseNetPosition(Double baseNetPosition) {
		this.baseNetPosition = baseNetPosition;
	}
	public Double getNetPositionChangedFrequency() {
		return netPositionChangedFrequency;
	}
	public void setNetPositionChangedFrequency(Double netPositionChangedFrequency) {
		this.netPositionChangedFrequency = netPositionChangedFrequency;
	}
	public Double getFollowingCount() {
		return followingCount;
	}
	public void setFollowingCount(Double followingCount) {
		this.followingCount = followingCount;
	}
	public Double getSingleProfitLimit() {
		return singleProfitLimit;
	}
	public void setSingleProfitLimit(Double singleProfitLimit) {
		this.singleProfitLimit = singleProfitLimit;
	}
	public Double getSingleLoseLimit() {
		return singleLoseLimit;
	}
	public void setSingleLoseLimit(Double singleLoseLimit) {
		this.singleLoseLimit = singleLoseLimit;
	}
	public Double getOrderLostLimit() {
		return orderLostLimit;
	}
	public void setOrderLostLimit(Double orderLostLimit) {
		this.orderLostLimit = orderLostLimit;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
