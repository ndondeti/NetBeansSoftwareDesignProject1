Software Design Assignment - 1
Author - Vivek Narsimha Dondeti

The client, server and the models are all Maven project. The CRUD-GradeBook-vdondeti-NetBeans is the parent project(POM project)
The server is built using NetBeans and can be run on the glassfish server that comes along with NetBeans.
The server endpoints are 
1) http://localhost/GradeBook-Server/CSE564/Gradebook/student
2) http://localhost/GradeBook-Server/CSE564/Gradebook/addClassPlan
3) http://localhost/GradeBook-Server/CSE564/Gradebook/grade/{studentName}/{workItemName}
The first endpoint supports GET and POST, the second supports only POST and the third one supports GET, PUT, POST, DELETE

Instructions for running the project.
1) Load all projects onto NetBeans.
2) Build the CRUD-GradeBook-vdondeti-NetBeans parent project. This will build all the other projects.
3) The server has to be started first on the glassfish server.
   This can be done directly from NetBeans by right clicking on the GradeBook-Server project.
4) The client can be run as a java application. The main method is in the class GradeBookFrame.java.

The following actions can be done by the user using the client
1) Add students - Enter the student name in the top right Text field and click on the Add student to add a student.
2) Add class plan - You can add as many work items as you want but there total must be 100%. Clicking on the "Add work item" 
   will add the work item you have entered to a list. You can submit the workitem list by clicking on the submit button next to "Add work item".
3) By choosing any on of the 4 operations you can add, update, get or remove grade.
   * For Adding and Updating a grade you need all the 4 information - Workitem name, student name, grade(float value), feedback.
   * For getting and removing grade you need the student name and the workitem name.
4) The HTTP response code and the Success/Failure message are displayed at the bottom. 
   For Get grade the grade and the feedback are populated in the corresponsing text field.
5) By clicking on the "Get Student Total Score" you can get the summed up score of the student for all the submissions he has made.
