# Final Project: Database Connected Application
### Submitted by Group 20:
Marc Edison Estaca <br>
Lexter Paule <br>
Dylan Dang <br>
Reiner Justin

### Date Completed
December 14, 2025

### Description:
An Employee Management System written in java that utilizes interfaces, inheritance, programming patterns (singleton, builder, factory), and generics. 

### Features
 • Add an employee to the database <br>
 • Edit an employee from the database <br>
 • Delete an employee from the database <br>
 • Display all employees <br>
 • Add a department to the database <br>
 • Edit a department from the database <br>
 • Delete a department from the database <br>
 • Display all departments <br>
 • Uses MariaDb for persistence <br>
 • Custom error messages for repository and user input <br>
 • Query builder class <br>
 • Robust database class that handles fetch(), exeuteQuery(), and executeNonQuery()<br>

### Scenario:
Choose one of the following topics, or propose a topic of your own, and create an application connected to a database using Object Oriented programming concepts:
1.	Learning Management System
2.	Restaurant Management System 
3.	Salaries Management System
4.	Library Management System
5.	Gym Management System
6.	Hospital Management System
7.	House Utilities Management System
8.	Mechanic shop Management System
9.	Employee Management System
10.	Events Management System

### Chosen Scenario:
Employee Management System

### Instructions

## Part A: Analysis and requirements gathering. 

1.	Choose one of the topics above and create a UML class diagram, that represents the classes and their relationships, to plan for your project before implementation. <br>
  a.	Your project must use Software Ideas Modeler (SIM) as the CASE tool for this project.
2.	The UML diagram should include: <br>
a.	Classes, attributes, and methods <br>
b.	Relationships between classes <br>
c.	Use of inheritance, interfaces, and abstract classes (if applicable) <br>
d.	Visibility modifiers for attributes and methods (public, private, protected)
3.	After planning your UML diagram: begin creating your classes in Eclipse to transition smoothly from planning to implementation. <br>
Deliverables: <br>
•	Create a word document titled ‘CPRG211 Final Project PART A’ with the following structure: <br>
o	Title page: listing Group members name and student id number. <br>
o	UML Diagrams: Export your SIM diagrams into this document. One diagram per page. <br>
o	Project files: with partial class.

Class Diagram
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/EmployeeManagement.png)

#### Submission: 
Submit both your Word document and SIM project to Brightspace under ‘Assignments/FinalProject’. 

### Part B: Design and Prototyping 
1.	Using Java, create a prototype that MUST implement the following functionalities: <br>
•	CRUD Operations: Implement the ability to: <br>
o	Create: Add new data entries. <br>
o	Read: Display data based on user choices. <br>
o	Update: Modify existing data. <br>
o	Delete: Remove data from the system. <br>
•	Database Integration: <br>
o	Establish a database connection to store, retrieve, and update data. <br>
o	Ensure the application is capable of handling data persistence. <br>
•	Exception Handling <br>
o	Custom Exceptions: Create user-defined exceptions to handle specific error cases

Deliverables: <br>
•	Project code - Include all the necessary code files for your project.

#### Submission: 
Submit zipped Project folder including all necessary coding files under ‘Assignments/FinalProject’. 

Part C: Recorded Video Presentation
Presentation should include the following sections:
1.	Introduction:
•	Briefly introduce the project and its purpose.
•	Mention the technologies used in the project such as classes, interfaces, abstract classes and exceptions.
•	Provide an overview of the project's goals and functionality.
2.	Functionality:
•	Describe the core functionality of the project.
•	Detail how classes, interfaces, and abstract classes are used to achieve this functionality.
•	Discuss how exceptions are handled and used in the project.
3.	Classes and Inheritance:
•	Define the classes that are used in the project.
•	Explain how inheritance is used to create a hierarchy of classes.
•	Describe how interfaces/abstract classes are implemented in the project.
4.	Command Line / Terminal-Based UI (CLI):
•	Show the key components of your application’s command-line interface.
•	Explain the functionalities of the components, such as menu options, data entry, and display features.
5.	Exception Handling:
•	Describe how exceptions are managed in the project.
•	Provide examples of how exceptions are used in the project.
6.	Database Integration:
•	Explain how the database connection is established.
•	Discuss data storage, retrieval, and updates.
•	Show examples of SQL queries used for CRUD operations
7.	Conclusion:
•	Summarize the main points of the rubric.
•	Reiterate the project's goals and functionality.
•	Provide any final considerations or suggestions.

Submission 
1.	Write a program that meets the requirements described above.
2.	Test your code against the expected requirements.
3.	Check your program against the detailed marking criteria at the end of this document.
4.	Submit the following to Brightspace as a group (Only one copy is required per group, and any of the group members may submit):
•	Readme file to explain the project functionality and problem that it solves and a brief description of how the system works.
•	Project code - Include all the necessary code files for your project.
•	Presentation of the project explanation (IMPORTANT) - Each participant       MUST      contribute   to this video, explaining their individual part within the project. This includes discussing the functionality they implemented and presenting the corresponding code.
•	Github URL for your program code
•	Screenshots of application output (.doc file)/screenshots(.jpeg) - Attach a copy of the output in a .txt file or include screenshots demonstrating the project's features.
•	Peer Assessment document.
Peer Assessment
Each student must complete a peer assessment of their group members. Your instructor will provide further submission details.

## Sample Output
### Main Menu 
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image.jpg)
### Display Employees
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(1).jpg)
### Add Employee
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(2).jpg)
### Edit Employee
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(3).jpg)
### Delete Employee
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(4).jpg)
### Department Menu
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(5).jpg)
### Display Department
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(6).jpg)
### Add Department
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(7).jpg)
### Edit Department
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(8).jpg)
### Dekete Department
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(9).jpg)
### Exit Application
![alt text](https://github.com/dylandangt/group20_finalproject/blob/main/EmployeeManagement/image%20(10).jpg)



