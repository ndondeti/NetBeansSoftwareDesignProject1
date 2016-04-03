/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.client;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fcalliss
 */
@XmlRootElement
@XmlType(propOrder={
    "id",
    "title",
    "priority"})
public class Appointment {
    
    private static final Logger LOG = LoggerFactory.getLogger(Appointment.class);
    
    private String      title;
    private int         priority;
    private int        id;

    public Appointment() {
        LOG.info("Creating an Appointment object");
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        LOG.info("Setting the title to {}", title);
        
        this.title = title;
        
        LOG.debug("The updated appointment = {}", this);
    }

    public int getPriority() {
        return priority;
    }

    @XmlElement
    public void setPriority(int priority) {
        LOG.info("Setting the priority to {}", priority);
        
        this.priority = priority;
        
        LOG.debug("The updated appointment = {}", this);
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        LOG.info("Setting the id to {}", id);
        
        this.id = id;
        
        LOG.debug("The updated appointment = {}", this);
    }

    @Override
    public String toString() {
        return "Appointment{" + "title=" + title + ", priority=" + priority + ", id=" + id + '}';
    }
    
}
