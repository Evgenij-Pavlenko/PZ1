package ua.com.oa.pavlenko_e;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


//@XmlRootElement
@XmlType(propOrder = { "name", "price", "category", "description" })
public class Good {
	private int id;
	private String name;
	private float price;
	private String category;
	private String description;

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	@XmlElement
	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public Good() {
		super();
	}

	public Good(int id, String name, float price, String category, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nGood [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", description="
				+ description + "]";
	}

}
