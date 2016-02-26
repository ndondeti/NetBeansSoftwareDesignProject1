package edu.asu.cse564.storage;

import java.io.File;
import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.asu.cse564.messages.FoodItem;
import java.util.logging.Logger;

@ApplicationScoped
public class FoodItemStorage implements IFoodItemStorage {

	private List<FoodItem> foodItems;
	public static int idCounter = 1000;
        
        private static final Logger LOGGER = Logger.getLogger(FoodItemStorage.class.getName());

	public FoodItemStorage() {
		foodItems = new ArrayList<FoodItem>();
		loadFoodItems("FoodItems.xml");
	}

	public void loadFoodItems(String fileName){
		try{
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(FoodItemStorage.class.getClassLoader().getResource(fileName).toURI());
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("FoodItem");
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					FoodItem foodItem = new FoodItem();
					foodItem.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
					foodItem.setCategory(eElement.getElementsByTagName("category").item(0).getTextContent());
					foodItem.setCountry(eElement.getAttribute("country"));
					foodItem.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
					foodItem.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
					foodItem.setPrice(Float.parseFloat(eElement.getElementsByTagName("price").item(0).getTextContent()));
					foodItems.add(foodItem);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public int addFoodItem(FoodItem foodItem) {
		foodItem.setId(++idCounter);
		foodItems.add(foodItem);
		return idCounter;
	}

	public FoodItem getFoodItem(int foodItemId) {
		for (FoodItem food : foodItems) {
			if (food.getId() == foodItemId)
				return food;
		}
		return null;
	}

	public int foodItemExist(FoodItem foodItem) {
		for (FoodItem food : foodItems) {
			if (food.compareTo(foodItem)) {
				return food.getId();
			}
		}
		return 0;
	}
}
