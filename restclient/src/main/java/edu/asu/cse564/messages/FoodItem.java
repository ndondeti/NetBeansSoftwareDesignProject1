package edu.asu.cse564.messages;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "FoodItem")
public class FoodItem extends BaseMessage{
	int id;
	String name;
	String description;
	String category;
	float price;
	String country;
	
	@XmlElement
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@XmlElement
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@XmlAttribute
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean compareTo(FoodItem foodItem){
		if(this.name.equals(foodItem.getName()) && this.country.equals(foodItem.getCountry())
		   && this.price == foodItem.getPrice() && this.category.equals(foodItem.getCategory()))
			return true;
		return false;
	}
	
}
