package edu.asu.cse564.messages;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SelectedFoodItems")
public class SelectedFoodItems extends BaseMessage{
	List<Integer> foodItem;

	public List<Integer> getFoodItem() {
		return foodItem;
	}
	//@XmlElementWrapper(name = "NewFoodItems")
	@XmlElement(name = "FoodItemId")
	public void setFoodItem(List<Integer> foodItem) {
		this.foodItem = foodItem;
	}	
}
