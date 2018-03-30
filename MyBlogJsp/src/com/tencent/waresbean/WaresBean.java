package com.tencent.waresbean;

public class WaresBean {
	//商品ID
	String waresId;
	//商品的图片
	String img;
	//商品的标题
	String title;
	//商品的价格
	String price;
	//商品的数量
	int count;
	//商品的描述信息
	String description;
	
	
public WaresBean() {
		super();
	}

public WaresBean(String waresId, String title, String price, int count, String description,
		 String img) {
		this.waresId = waresId;
		this.img = img;
		this.title = title;
		this.price = price;
		this.count = count;
		this.description = description;
	}

	public String getWaresId() {
	return waresId;
}

public void setWaresId(String wareId) {
	this.waresId = wareId;
}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
