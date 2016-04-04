/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.curd.gradebook;

import edu.asu.cse564.gradebook.models.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.asu.cse564.curd.gradebook.content.GradeBook;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

/**
 *
 * @author Vivek
 */
@Path("/gradebook")
public class RestEndPoint {

    private Gson gson;
    private JsonParser jsonBuilder;

    private static GradeBook gradeBook = new GradeBook();

    public RestEndPoint() {
        gson = new Gson();
        jsonBuilder = new JsonParser();
    }

    @POST
    @Path("addClassPlan")
    public Response addClassPlan(String classPlan) {
        JsonObject jsonData = jsonBuilder.parse(classPlan).getAsJsonObject();
        SetWorkItem setWorkItem = gson.fromJson(jsonData, SetWorkItem.class);
        try {
            for (WorkItem workItem : setWorkItem.workItems) {
                gradeBook.addGradingItem(workItem);
            }
            String success = "Added class plan";
            return Response.status(201).entity(success).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("grade/{studentName}/{workItem}")
    public Response addGrade(@PathParam("studentName") String studentName, 
                             @PathParam("workItem") String workItem, String addGrade) {
        JsonObject jsonData = jsonBuilder.parse(addGrade).getAsJsonObject();
        Grade gradeItem = gson.fromJson(jsonData, Grade.class);
        try {
            gradeBook.addGrade(studentName, gradeItem, workItem);
            String success = "Added grade";
            return Response.status(201).entity(success).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("grade/{studentName}/{workItem}")
    public Response removeGrade(@PathParam("studentName") String studentName,
            @PathParam("workItem") String workItem) {
        try {
            gradeBook.deleteGrade(studentName, workItem);
            String success = "Deleted grade";
            return Response.status(200).entity(success).build();
        } catch (Exception e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("grade/{studentName}/{workItem}")
    public Response updateGrade(@PathParam("studentName") String studentName,
            @PathParam("workItem") String workItem, String updateMessage) {
        JsonObject jsonData = jsonBuilder.parse(updateMessage).getAsJsonObject();
        Grade grade = gson.fromJson(jsonData, Grade.class);
        try {
            gradeBook.updateGrade(studentName, grade, workItem);
            String success = "Updated grade";
            return Response.status(201).entity(success).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
    
    @GET
    @Path("grade/{studentName}/{workItem}")
    public Response getGrade(@PathParam("studentName") String studentName,
            @PathParam("workItem") String workItem) {
        try{
            Grade grade = gradeBook.getGrade(studentName, workItem);
            String response = gson.toJson(grade);
            return Response.status(200).entity(response).build();
        } catch (Exception e){
            return Response.status(404).entity(e.getMessage()).build();
        }        
    }
}
