package cn.edu.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 售饭数据bean
 * @author Z7M-SL7D2
 *
 */
public class Canteen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//饭卡号
	private int mealCardId;
	 //食堂ID
	private int canteenId;
	 //售饭机号
	private int deviceId;
	 //消费金额
	private float consumeMoney;
	 //消费时间
	private long consumeTime;
	
	
	public int getMealCardId() {
		return mealCardId;
	}
	public void setMealCardId(int mealCardId) {
		this.mealCardId = mealCardId;
	}
	public int getCanteenId() {
		return canteenId;
	}
	public void setCanteenId(int canteenId) {
		this.canteenId = canteenId;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public float getConsumeMoney() {
		return consumeMoney;
	}
	public void setConsumeMoney(float consumeMoney) {
		this.consumeMoney = consumeMoney;
	}
	public long getConsumeTime() {
		return consumeTime;
	}
	public void setConsumeTime(long consumeTime) {
		this.consumeTime = consumeTime;
	}
	
}
