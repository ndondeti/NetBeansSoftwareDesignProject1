/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.curd.gradebook.models;

import java.util.HashMap;
/**
 *
 * @author Vivek
 */
public class Student{
    String name;
    HashMap<String, GradeItem> gradeItems;

    Student(String string) {
        this.name = name;
        gradeItems = new HashMap<>();
    }
    
    public void addGradeItem(String gradeItem){
        this.gradeItems.put(gradeItem, null);
    }
    
    public void addGrade(GradeItem gradeItem)throws Exception{
        if(gradeItems.containsKey(gradeItem.workItemName)){
            if(gradeItems.get(gradeItem.workItemName) != null){
                throw new Exception("WorkItemExists");
            }
            this.gradeItems.put(gradeItem.workItemName, gradeItem);
        }
        else {
            throw new Exception("NoWorkItem");
        }
    }
    
    public void updateGrade(GradeItem gradeItem)throws Exception{
        if(gradeItems.containsKey(gradeItem.workItemName)){
            throw new Exception("NoWorkItem");
        }
        else{
            gradeItems.put(gradeItem.workItemName, gradeItem);
        }
    }
    
    public GradeItem getGrade(String workItemName) throws Exception{
        GradeItem item = gradeItems.get(workItemName);
        if(item == null){
            throw new Exception("NoWorkItem");
        }
        else{
            return item;
        }
    }
    
    public void deleteGrade(String workItemName) throws Exception{
        GradeItem item = gradeItems.get(workItemName);
        if(item == null){
            throw new Exception("NoWorkItem");
        }
        gradeItems.put(workItemName, null);
    }
}
