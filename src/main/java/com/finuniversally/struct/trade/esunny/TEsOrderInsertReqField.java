package com.finuniversally.struct.trade.esunny;

/**
 * struct for add order request field;
 * @author riseSun
 */
public class TEsOrderInsertReqField {

	private String ClientNo;
	private String CommodityNo;   			//商品代码         
	private String ContractNo;    			//合约代码
	private char OrderType;					//委托类型
	private char OrderWay;					//委托方式,单客户不用关注本字段
	private char OrderMode;					//委托模式
	private String ValidDateTime;			//有效日期(GTD情况下使用)
	private char IsRiskOrder;				//风险报单
	private char Direct;					//买入卖出
	private char Offset;					//开仓平仓
	private char Hedge;						//投机保值
	private double OrderPrice;				//委托价格
	private double TriggerPrice;			//触发价格
	private int OrderVol;					//委托数量
	private int MinMatchVol;				//最小成交量
	private char Randomise;					//冰山单是否随机量发出 2012-11-2
	private int MinClipSize;				//冰山单最小随机量
	private int MaxClipSize;				//冰山单最大随机量
	private int SaveInt;                 	//客户保留字段1
	private double SaveDouble;              //客户保留字段2
	private String SaveString;              //客户保留字段3
	
	/**
	 * @param clientNo
	 * @param commodityNo
	 * @param contractNo
	 * @param orderType
	 * @param orderWay
	 * @param orderMode
	 * @param validDateTime
	 * @param isRiskOrder
	 * @param direct
	 * @param offset
	 * @param hedge
	 * @param orderPrice
	 * @param triggerPrice
	 * @param orderVol
	 * @param minMatchVol
	 * @param randomise
	 * @param minClipSize
	 * @param maxClipSize
	 * @param saveInt
	 * @param saveDouble
	 * @param saveString
	 */
	public TEsOrderInsertReqField(String clientNo, String commodityNo, String contractNo, char orderType, char orderWay,
			char orderMode, String validDateTime, char isRiskOrder, char direct, char offset, char hedge,
			double orderPrice, double triggerPrice, int orderVol, int minMatchVol, char randomise, int minClipSize,
			int maxClipSize, int saveInt, double saveDouble, String saveString) {
		super();
		ClientNo = clientNo;
		CommodityNo = commodityNo;
		ContractNo = contractNo;
		OrderType = orderType;
		OrderWay = orderWay;
		OrderMode = orderMode;
		ValidDateTime = validDateTime;
		IsRiskOrder = isRiskOrder;
		Direct = direct;
		Offset = offset;
		Hedge = hedge;
		OrderPrice = orderPrice;
		TriggerPrice = triggerPrice;
		OrderVol = orderVol;
		MinMatchVol = minMatchVol;
		Randomise = randomise;
		MinClipSize = minClipSize;
		MaxClipSize = maxClipSize;
		SaveInt = saveInt;
		SaveDouble = saveDouble;
		SaveString = saveString;
	}
	
	public String getClientNo() {
		return ClientNo;
	}
	public void setClientNo(String clientNo) {
		ClientNo = clientNo;
	}
	public String getCommodityNo() {
		return CommodityNo;
	}
	public void setCommodityNo(String commodityNo) {
		CommodityNo = commodityNo;
	}
	public String getContractNo() {
		return ContractNo;
	}
	public void setContractNo(String contractNo) {
		ContractNo = contractNo;
	}
	public char getOrderType() {
		return OrderType;
	}
	public void setOrderType(char orderType) {
		OrderType = orderType;
	}
	public char getOrderWay() {
		return OrderWay;
	}
	public void setOrderWay(char orderWay) {
		OrderWay = orderWay;
	}
	public char getOrderMode() {
		return OrderMode;
	}
	public void setOrderMode(char orderMode) {
		OrderMode = orderMode;
	}
	public String getValidDateTime() {
		return ValidDateTime;
	}
	public void setValidDateTime(String validDateTime) {
		ValidDateTime = validDateTime;
	}
	public char getIsRiskOrder() {
		return IsRiskOrder;
	}
	public void setIsRiskOrder(char isRiskOrder) {
		IsRiskOrder = isRiskOrder;
	}
	public char getDirect() {
		return Direct;
	}
	public void setDirect(char direct) {
		Direct = direct;
	}
	public char getOffset() {
		return Offset;
	}
	public void setOffset(char offset) {
		Offset = offset;
	}
	public char getHedge() {
		return Hedge;
	}
	public void setHedge(char hedge) {
		Hedge = hedge;
	}
	public double getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		OrderPrice = orderPrice;
	}
	public double getTriggerPrice() {
		return TriggerPrice;
	}
	public void setTriggerPrice(double triggerPrice) {
		TriggerPrice = triggerPrice;
	}
	public int getOrderVol() {
		return OrderVol;
	}
	public void setOrderVol(int orderVol) {
		OrderVol = orderVol;
	}
	public int getMinMatchVol() {
		return MinMatchVol;
	}
	public void setMinMatchVol(int minMatchVol) {
		MinMatchVol = minMatchVol;
	}
	public char getRandomise() {
		return Randomise;
	}
	public void setRandomise(char randomise) {
		Randomise = randomise;
	}
	public int getMinClipSize() {
		return MinClipSize;
	}
	public void setMinClipSize(int minClipSize) {
		MinClipSize = minClipSize;
	}
	public int getMaxClipSize() {
		return MaxClipSize;
	}
	public void setMaxClipSize(int maxClipSize) {
		MaxClipSize = maxClipSize;
	}
	public int getSaveInt() {
		return SaveInt;
	}
	public void setSaveInt(int saveInt) {
		SaveInt = saveInt;
	}
	public double getSaveDouble() {
		return SaveDouble;
	}
	public void setSaveDouble(double saveDouble) {
		SaveDouble = saveDouble;
	}
	public String getSaveString() {
		return SaveString;
	}
	public void setSaveString(String saveString) {
		SaveString = saveString;
	}
}
