/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.curd.gradebook.models;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
/**
 *
 * @author Vivek
 */
@ApplicationScoped
public class GradeBook{
    private final HashMap<String, Float> gradingItems;
    private static float totalPercentage = 0;
    private final HashMap<String, Student> students;
    
    public GradeBook(){
        gradingItems = new HashMap<>();
        students = new HashMap<>();
        students.put("1", new Student("1"));
        students.put("2", new Student("2"));
        students.put("3", new Student("3"));
        students.put("4", new Student("4"));
    }
    public void addGradingItem(WorkItem workItem) throws Exception{
        if((totalPercentage + workItem.percentage) <= 100){
            gradingItems.put(workItem.workItemName, workItem.percentage);
            totalPercentage += workItem.percentage;
            List<Student> studentList = new ArrayList(students.values());
            for(Student student : studentList){
                student.addGradeItem(workItem.workItemName);
            }
        }
        else{
            totalPercentage = 0;
            throw new Exception("Exceeds100");
        }
    }
    
    public void addGrade(String studentName, GradeItem gradeItem) throws Exception{
        Student student = students.get(studentName);
        if(student == null){
            throw new Exception("NoStudent");
        }
        else{
            student.addGrade(gradeItem);
        }
    }
    
    public void updateGrade(String studentName, GradeItem gradeItem) throws Exception{
        Student student = students.get(studentName);
        if(student == null){
            throw new Exception("NoStudent");
        }
        else{
            student.updateGrade(gradeItem);
        }
    }
    
    public Student getStudent(String studentName) throws Exception{
        Student student = students.get(studentName);
        if(student == null){
            throw new Exception("NoStudent");
        }
        return student;
    }
    
    public GradeItem getGrade(String studentName, String workItemName) throws Exception{
        Student student = students.get(studentName);
        if(student == null){
            throw new Exception("NoStudent");
        }
        else{
            return student.getGrade(workItemName);
        }
    }
    
    public void deleteGrade(String studentName, String workItemName) throws Exception{
        Student student = students.get(studentName);
        if(student == null){
            throw new Exception("NoStudent");
        }
        else{
            student.deleteGrade(workItemName);
        }
    }
}
