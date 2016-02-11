package ua.com.oa.pavlenko_e;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Shop {
	private String shopName;
	private List<Good> goodslist = new ArrayList<>() ;

	
	public List<Good> getGoodslist() {
		return goodslist;
	}
public String getShopName() {
		return shopName;
	}
	@XmlAttribute
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@XmlElementWrapper(name = "goodslist")
	@XmlElement (name = "good")
	public void setGoodslist(List<Good> goodslist2) {
		this.goodslist = goodslist2;
	}
public Shop(String shopName) {
	super();
	this.shopName = shopName;
}
public Shop() {
	super();
}
@Override
public String toString() {
	return "Shop [shopName=" + shopName + ", goodslist=" + goodslist + "]";
}




	
}
