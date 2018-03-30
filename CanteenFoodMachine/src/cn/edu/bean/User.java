package cn.edu.bean;

/**
 * 用户的饭卡id和余额
 * @author Z7M-SL7D2
 *
 */
public class User {
	int mealCardId;
	String userName;
	float balence;
	
	public int getMealCardId() {
		return mealCardId;
	}
	public void setMealCardId(int mealCardId) {
		this.mealCardId = mealCardId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getBalence() {
		return balence;
	}
	public void setBalence(float balence) {
		this.balence = balence;
	}
	
}
