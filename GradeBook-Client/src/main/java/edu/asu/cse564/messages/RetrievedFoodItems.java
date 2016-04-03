package edu.asu.cse564.messages;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NewFoodItems")
public class RetrievedFoodItems extends BaseMessage{
	
	List<FoodItem> foodItem;

	public List<FoodItem> getFoodItem() {
		return foodItem;
	}
	
	@XmlElement(name = "FoodItem")
	public void setFoodItem(List<FoodItem> foodItem) {
		this.foodItem = foodItem;
	}	
	
	List<Integer> invalidFoodItem;

	public List<Integer> getInvalidFoodItem() {
		return invalidFoodItem;
	}
	@XmlElementWrapper(name = "InvalidFoodItems")
	@XmlElement(name = "FoodItemId")
	public void setInvalidFoodItem(List<Integer> invalidFoodItem) {
		this.invalidFoodItem = invalidFoodItem;
	}        
}