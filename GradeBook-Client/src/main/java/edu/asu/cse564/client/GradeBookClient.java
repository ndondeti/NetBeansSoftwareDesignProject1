package edu.asu.cse564.client;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import edu.asu.cse564.gradebook.models.*;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GradeBookClient {

    private static final Logger LOG = LoggerFactory.getLogger(GradeBookClient.class);

    private Gson gson;
    private JsonParser jsonBuilder;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/GradeBook-Server/CSE564/gradebook/";

    public GradeBookClient() {
        LOG.info("Creating a Appointment_CRUD REST client");
        gson = new Gson();
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
    }

    public ClientResponse addClassPlan(SetWorkItem setWorkItem) throws UniformInterfaceException {
        LOG.info("Initiating a add class plan request");
        WebResource webResource;
        webResource = client.resource(BASE_URI).path("addClassPlan");
        String message = gson.toJson(setWorkItem);
        return webResource.type("application/json").post(ClientResponse.class, message);
    }

    public ClientResponse addGrade(Grade grade, String student, String workItem) throws UniformInterfaceException {
        LOG.info("Initiating a add grade request");
        LOG.debug("Student = " + student + "WorkItem = " + workItem);
        WebResource webResource;
        webResource = client.resource(BASE_URI).path("grade/" + student + "/" + workItem);
        String message = gson.toJson(grade);
        return webResource.type("application/json").post(ClientResponse.class, message);
    }

    public ClientResponse updateGrade(Grade grade, String student, String workItem) throws UniformInterfaceException {
        LOG.info("Initiating an Update request");
        LOG.debug("Student = " + student + "WorkItem = " + workItem);
        WebResource webResource;
        webResource = client.resource(BASE_URI).path("grade/" + student + "/" + workItem);
        String message = gson.toJson(grade);
        return webResource.type("application/json").put(ClientResponse.class, message);
    }

    public ClientResponse getGrade(String student, String workItem) throws UniformInterfaceException {
        LOG.info("Initiating a Retrieve request");
        LOG.debug("Student = " + student + "WorkItem = " + workItem);
        WebResource webResource;
        webResource = client.resource(BASE_URI).path("grade/" + student + "/" + workItem);
        return webResource.accept("application/json").get(ClientResponse.class);
    }

    public ClientResponse deleteGrade(String student, String workItem) throws UniformInterfaceException {
        LOG.info("Initiating a Retrieve request");
        LOG.debug("Student = " + student + "WorkItem = " + workItem);
        WebResource webResource;
        webResource = client.resource(BASE_URI).path("grade/" + student + "/" + workItem);
        return webResource.delete(ClientResponse.class);
    }

    public void close() {
        LOG.info("Closing the REST Client");
        client.destroy();
    }

}