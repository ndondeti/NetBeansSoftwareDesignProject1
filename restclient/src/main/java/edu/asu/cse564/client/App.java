package edu.asu.cse564.client;

import edu.asu.cse564.messages.FoodItem;
import edu.asu.cse564.messages.NewFoodItems;
import edu.asu.cse564.messages.SelectedFoodItems;

import java.util.ArrayList;
import java.util.List;

public class App {
         
    public static void main( String[] args )
    {
        XmlFormatter xmlFormatter = new XmlFormatter();
        RestserviceClient restClient = new RestserviceClient();
        
        //First Example Getting a Food Item from the given FoodItems.xml
        System.out.println("Trying to get food items in the FoodItems.xml with id 105 and 106");
        List<Integer> foodItems = new ArrayList<>();
        foodItems.add(105);
        foodItems.add(106);
        SelectedFoodItems selected = new SelectedFoodItems();
        selected.setFoodItem(foodItems);
        
        String responseMessage = restClient.getSelectedFoodItem(selected);
        
        String formatted = xmlFormatter.format(responseMessage);
        System.out.println("The response is ");
        System.out.println(formatted);        
        
        //Second Example Adding a Food Item 
        System.out.println("Trying to add a new Food Item");
        FoodItem food = new FoodItem();
        food.setCategory("Dinner");
        food.setCountry("GB");
        food.setDescription("Tender cubes of steak, potatoes and swede wrapped"
                + " in flakey short crust pastry.  Seasoned with lots of pepper."
                + " Served with mashed potatoes, peas and a side of gravy");
        food.setPrice((float) 15.95);
        food.setName("Cornish Pasty");
        NewFoodItems newFoodItems = new NewFoodItems();
        List<FoodItem> listOfFoodItem = new ArrayList<>();
        listOfFoodItem.add(food);
        newFoodItems.setFoodItem(listOfFoodItem);
        
        responseMessage = restClient.addFoodItem(newFoodItems);
        formatted = xmlFormatter.format(responseMessage);
        System.out.println("The response is ");
        System.out.println(formatted);      
        
        //Third Example Trying to retrieve the newly added food Item
        System.out.println("Trying to get food items recently added with id 1001");
        foodItems = new ArrayList<>();
        foodItems.add(1001);
        selected = new SelectedFoodItems();
        selected.setFoodItem(foodItems);
        
        responseMessage = restClient.getSelectedFoodItem(selected);
        
        formatted = xmlFormatter.format(responseMessage);
        System.out.println("The response is ");
        System.out.println(formatted);   
        
        //Fourth Example Trying to Added the same food item again
        System.out.println("Trying to add a Food Item that already exists");
        food = new FoodItem();
        food.setCategory("Dinner");
        food.setCountry("GB");
        food.setDescription("Tender cubes of steak, potatoes and swede wrapped"
                + " in flakey short crust pastry.  Seasoned with lots of pepper."
                + " Served with mashed potatoes, peas and a side of gravy");
        food.setPrice((float) 15.95);
        food.setName("Cornish Pasty");
        newFoodItems = new NewFoodItems();
        listOfFoodItem = new ArrayList<>();
        listOfFoodItem.add(food);
        newFoodItems.setFoodItem(listOfFoodItem);
        
        responseMessage = restClient.addFoodItem(newFoodItems);
        formatted = xmlFormatter.format(responseMessage);
        System.out.println("The response is ");
        System.out.println(formatted);      
        
        
        //Fifth Example Trying to retrieve a food Item that does not exist
        System.out.println("Trying to get food items that does not exist");
        foodItems = new ArrayList<>();
        foodItems.add(1010);
        selected = new SelectedFoodItems();
        selected.setFoodItem(foodItems);
        
        responseMessage = restClient.getSelectedFoodItem(selected);
        
        formatted = xmlFormatter.format(responseMessage);
        System.out.println("The response is ");
        System.out.println(formatted);   
        
        //Sixth Exampple Trying to send an invalid message
        System.out.println("Trying to add an invalid food item where there is no description");
        food = new FoodItem();
        food.setCategory("Dinner");
        food.setCountry("GB");
        food.setPrice((float) 15.95);
        food.setName("Cornish Pasty");
        newFoodItems = new NewFoodItems();
        listOfFoodItem = new ArrayList<>();
        listOfFoodItem.add(food);
        newFoodItems.setFoodItem(listOfFoodItem);
        
        responseMessage = restClient.addFoodItem(newFoodItems);
        formatted = xmlFormatter.format(responseMessage);
        System.out.println("The response is ");
        System.out.println(formatted);      
    }    
}
