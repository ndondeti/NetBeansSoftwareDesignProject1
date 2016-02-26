package edu.asu.cse564.storage;

import edu.asu.cse564.messages.*;

public interface IFoodItemStorage {
	public int addFoodItem(FoodItem foodItem);
	public FoodItem getFoodItem(int foodItemId);
	public int foodItemExist(FoodItem foodItem);
}
