/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.client;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import edu.asu.cse564.messages.*;

public class RestserviceClient {

    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/restservices/rest";

    public RestserviceClient() {
        client = ClientBuilder.newClient();
        
    }

    public String getSelectedFoodItem(SelectedFoodItems selected) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = client.target(BASE_URI).path("GetFoodItem");
        return resource.request(MediaType.TEXT_XML).post(Entity.entity(selected,MediaType.TEXT_XML), String.class);
    }
    
    public String addFoodItem(NewFoodItems newFoodItems){
        WebTarget resource = client.target(BASE_URI).path("AddFoodItem");
        return resource.request(MediaType.TEXT_XML).post(Entity.entity(newFoodItems,MediaType.TEXT_XML), String.class);
    }

    public void close() {
        client.close();
    }
    
}
