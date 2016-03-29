Software Design Assignment - 1
Author - Vivek Narsimha Dondeti

Both the server and Client are Maven Projects. 
The server is built using NetBeans and can be run on the glassfish server that comes along with NetBeans.
The server endpoints are 
1) http://localhost/restservices/AddFoodItem
2) http://localhost/restservices/GetFoodItem

Instructions for running the project.
1) The server has to be started first on the glassfish server.
   This can be done directly from NetBeans by right clicking on the restservice project.
2) The client can be run as a java application. The main method is in the class App.java.

The client has a series of test cases. They make requests to the server and print the xml recieved from the server on the console.
The following are the test cases run by the client.
1) Get a FoodItem that exists in the FoodItems.xml file.
2) Adding a new FoodItem
3) Getting the FoodItem previously added.
4) Trying to add the same FoodItem again.
5) Trying to get a FoodItem that does not exist.
6) Trying to add an invalid FoodItem.

The server can also be tested by directly hitting the Endpoint from tools like Fiddler that allow one to create Http request messages.
Sample Http request message
POST http://localhost:8080/restservices/AddFoodItem
User-Agent: Fiddler
Accept: text/xml
Content-Type: text/xml
Host: localhost:8080
Content-Length: 315

<NewFoodItems xmlns="http://cse564.asu.edu/PoxAssignment">
    <FoodItem country="GB">
        <name>Cornish Pasty</name>
        <description>Tender cubes of steak, potatoes and swede wrapped in flakey short crust pastry.  Seasoned with lots of pepper.  Served with mashed potatoes, peas and a side of gravy</description>
        <category>Dinner</category>
        <price>15.95</price>
    </FoodItem>
</NewFoodItems >
