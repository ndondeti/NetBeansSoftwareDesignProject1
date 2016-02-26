package edu.asu.cse564;

import edu.asu.cse564.messages.*;
import edu.asu.cse564.storage.*;

import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@ApplicationScoped
public class RestEndpoint {

	@Inject
	private IFoodItemStorage foodItemStorage;
	

	@POST
	@Path("AddFoodItem/")
	@Produces(MediaType.TEXT_XML)
	public BaseMessage addFoodItem(NewFoodItems newFoodItems) {
		List<FoodItem> foodItem = newFoodItems.getFoodItem();
		List<Integer> newIds = new ArrayList<Integer>();
		List<Integer> existingIds = new ArrayList<Integer>();
		for(FoodItem food : foodItem){
			if(food.getCountry() == null || food.getDescription() == null
			   || food.getCategory() == null || food.getName() == null || food.getPrice() == 0){
				return new InvalidMessage();
			}
			int id = foodItemStorage.foodItemExist(food); 
			if(id == 0){
				newIds.add(foodItemStorage.addFoodItem(food));
			}
			else{
				existingIds.add(id);
			}
		}
		if(newIds.size() != 0){
			FoodItemAdded foodItemAdded = new FoodItemAdded();
			foodItemAdded.setFoodItem(newIds);
			return foodItemAdded;
		}
		FoodItemExists foodItemExists = new FoodItemExists();
		foodItemExists.setFoodItem(existingIds);
		return foodItemExists;
	}
	
	@POST
	@Path("GetFoodItem/")
	@Produces(MediaType.TEXT_XML)
	public BaseMessage getFoodItem(SelectedFoodItems selectedFoodItems){
		List<Integer> foodItemId = selectedFoodItems.getFoodItem();
		if(foodItemId == null || foodItemId.size() == 0){
			return new InvalidMessage();
		}
		List<FoodItem> foodItems = new ArrayList<FoodItem>();
		List<Integer> invalidFoodItems = new ArrayList<Integer>();
		FoodItem food;
		for(Integer foodId : foodItemId){
			food = foodItemStorage.getFoodItem(foodId);
			if(food != null){
				foodItems.add(food);
			}
			else{
				invalidFoodItems.add(foodId);
			}
		}
		RetrievedFoodItems retrievedFoodItems = new RetrievedFoodItems();
		retrievedFoodItems.setFoodItem(foodItems);
		retrievedFoodItems.setInvalidFoodItem(invalidFoodItems);
		
		return retrievedFoodItems;
	}
}