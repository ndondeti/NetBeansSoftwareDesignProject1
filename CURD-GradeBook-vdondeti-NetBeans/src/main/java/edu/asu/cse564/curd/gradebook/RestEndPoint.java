/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.curd.gradebook;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.asu.cse564.curd.gradebook.models.GradeBook;
import edu.asu.cse564.curd.gradebook.models.GradeItem;
import edu.asu.cse564.curd.gradebook.models.SetWorkItem;
import edu.asu.cse564.curd.gradebook.models.WorkItem;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

/**
 *
 * @author Vivek
 */
@Path("/gradebook")
public class RestEndPoint {

    private Gson gson;
    private JsonParser jsonBuilder;

    @Inject
    GradeBook gradeBook;

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
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("addGrade/{studentName}")
    public Response addGrade(@PathParam("studentName") String studentName, String addGrade) {
        JsonObject jsonData = jsonBuilder.parse(addGrade).getAsJsonObject();
        GradeItem gradeItem = gson.fromJson(jsonData, GradeItem.class);
        try {
            gradeBook.addGrade(studentName, gradeItem);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("removeGrade/{studentName}/{workItem}")
    public Response removeGrade(@PathParam("studentName") String studentName,
            @PathParam("workItem") String workItem) {
        try {
            gradeBook.deleteGrade(studentName, workItem);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("updateGrade/{studentName}/{workItem}")
    public Response removeGrade(@PathParam("studentName") String studentName,
            @PathParam("workItem") String workItem, String updateMessage) {
        JsonObject jsonData = jsonBuilder.parse(updateMessage).getAsJsonObject();
        GradeItem gradeItem = gson.fromJson(jsonData, GradeItem.class);
        try {
            gradeBook.updateGrade(studentName, gradeItem);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}
