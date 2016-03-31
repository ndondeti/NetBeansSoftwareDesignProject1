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
public class Student {

    String name;
    HashMap<String, Grade> gradeItems;

    Student(String string) {
        this.name = name;
        gradeItems = new HashMap<>();
    }

    public void addGradeItem(String gradeItem) {
        this.gradeItems.put(gradeItem, null);
    }

    public void addGrade(Grade gradeItem, String workItem) throws Exception {
        if (gradeItems.containsKey(workItem)) {
            if (gradeItems.get(workItem) != null) {
                throw new Exception("WorkItemExists");
            }
            this.gradeItems.put(workItem, gradeItem);
        } else {
            throw new Exception("NoWorkItem");
        }
    }

    public void updateGrade(String workItem, Grade grade) throws Exception {
        if (!gradeItems.containsKey(workItem)) {
            throw new Exception("NoWorkItem");
        } else {
            if (gradeItems.get(workItem) == null) {
                throw new Exception("NoSubmission");
            }
            gradeItems.put(workItem, grade);
        }
    }

    public Grade getGrade(String workItemName) throws Exception {
        Grade item = gradeItems.get(workItemName);
        if (item == null) {
            throw new Exception("NoWorkItem");
        } else {
            return item;
        }
    }

    public void deleteGrade(String workItemName) throws Exception {
        Grade item = gradeItems.get(workItemName);
        if (item == null) {
            throw new Exception("NoWorkItem");
        }
        gradeItems.put(workItemName, null);
    }
}
