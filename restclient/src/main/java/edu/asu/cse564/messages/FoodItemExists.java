package edu.asu.cse564.messages;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FoodItemExists extends BaseMessage{
	List<Integer> foodItem;

	public List<Integer> getFoodItem() {
		return foodItem;
	}
	@XmlElement(name = "FoodItemId")
	public void setFoodItem(List<Integer> foodItem) {
		this.foodItem = foodItem;
	}
}