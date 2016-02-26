package edu.asu.cse564.messages;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NewFoodItems")
public class NewFoodItems extends BaseMessage{
	
	List<FoodItem> foodItem;

	public List<FoodItem> getFoodItem() {
		return foodItem;
	}

	//@XmlElementWrapper(name = "NewFoodItems")
	@XmlElement(name = "FoodItem")
	public void setFoodItem(List<FoodItem> foodItem) {
		this.foodItem = foodItem;
	}	
}
