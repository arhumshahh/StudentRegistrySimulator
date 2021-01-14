//NAME: ARHUM SHAH
//STUDENT NUMBER: 500957220
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;
import javax.print.DocFlavor.URL;

import java.util.Map;
import java.util.Set;
import java.nio.file.Paths;

public class Registry
{
   private TreeMap<String , Student> students1;
   private TreeMap<String , ActiveCourse> courses1;

   public Registry() throws FileNotFoundException
   {
	students1 = new TreeMap<String , Student>();
	courses1 = new TreeMap<String , ActiveCourse>();
	

	// Add some students
	   // in A2 we will read from a file
				String filename = "C:\\Users\\shaha\\Desktop\\a2\\students.txt";
				File s = new File(filename);
			    Scanner sc = new Scanner (s);
			   
			   while (sc.hasNext()) {
					String name = sc.next();
					String id = sc.next();
				if(isStringOnlyAlphabet(name)== false || isNumeric(id)==false){
					throw new BadFileException ("Bad File Format students.txt");
				}
				Student stu = new Student(name,id);
				if (students1.containsValue(stu) == false){
					students1.put(id,stu);
				}
				else{
					System.out.println( name  + " already exists");
				}
			  }
			  sc.close();

	   // sort the students alphabetically - see class Student
	   ArrayList<Student> list = new ArrayList<Student>();

	    // CPS209
		String courseName = "Computer Science II";
		String courseCode = "CPS209";
		String descr = "Learn how to write complex programs!";
		String format = "3Lec 2Lab";
		students1.get("38467").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		students1.get("98345").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		students1.get("57643").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		list.add(students1.get("38467")); list.add(students1.get("98345")); list.add(students1.get("57643"));
		courses1.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list,0,0,""));
		// CPS511
		list.clear();
		courseName = "Computer Graphics";
		courseCode = "CPS511";
		descr = "Learn how to write cool graphics programs";
		format = "3Lec";
		students1.get("34562").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		students1.get("25347").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		students1.get("46532").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		list.add(students1.get("34562")); list.add(students1.get("25347")); list.add(students1.get("46532"));
		courses1.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list,0,0,""));
		// CPS643
		list.clear();
		courseName = "Virtual Reality";
		courseCode = "CPS643";
		descr = "Learn how to write extremely cool virtual reality programs";
		format = "3Lec 2Lab";
		students1.get("34562").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		students1.get("38467").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		students1.get("57643").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		students1.get("46532").addCourse(courseName, courseCode, descr, format, "W2020", 0);
		list.add(students1.get("34562")); list.add(students1.get("38467")); list.add(students1.get("57643"));list.add(students1.get("46532"));
		courses1.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list,0,0,""));
		// CPS706
		list.clear();
		courseName = "Computer Networks";
		courseCode = "CPS706";
		descr = "Learn about Computer Networking";
		format = "3Lec 1Lab";
		courses1.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list,0,0,""));
		// CPS616
		courseName = "Algorithms";
		courseCode = "CPS616";
		descr = "Learn about Algorithms";
		format = "3Lec 1Lab";
		courses1.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list,0,0,""));
	   
   }
   
   // Add new student to the registry (students arraylist above) 
   public boolean addNewStudent(String name, String id)
   {
	   // Create a new student object
	   // check to ensure student is not already in registry
	   // if not, add them and return true, otherwise return false
	   // make use of equals method in class Student
	   Student s = new Student(name,id);
	   if (students1.containsValue(s) == false){
			students1.put(id, s);
			return true;
	   }
	   else{
			System.out.println("Student " + s.getName() + " already registered");
	   }
	   
	   return false;
   }
   // Remove student from registry 
   public boolean removeStudent(String studentId)
   {
	   // Find student in students arraylist
	   // If found, remove this student and return true
		if (students1.containsKey(studentId)){
			students1.remove(studentId);
			return true;
		}
	return false;  
   }
   
   // Print all registered students
   public void printAllStudents()
   {
	//get all keys
	Set<String> keys = students1.keySet();
        
	//using for loop
	for(String key : keys){
		System.out.println("ID: " + key + " Name: " + students1.get(key).getName() );   //cycles through students list and prints all students	
	}
   }
   
   // Given a studentId and a course code, add student to the active course
   public void addCourse(String studentId, String courseCode)
   {
	   // Find student object in registry (i.e. students arraylist)
	   // Check if student has already taken this course in the past Hint: look at their credit course list
	   // If not, then find the active course in courses array list using course code
	   // If active course found then check to see if student already enrolled in this course
	   // If not already enrolled
	   //   add student to the active course
	   //   add course to student list of credit courses with initial grade of 0

	   if(students1.containsKey(studentId)==true){
		   if (students1.get(studentId).hasTaken(courseCode)==false){
			   if (courses1.containsKey(courseCode.toUpperCase())){
				   courses1.get(courseCode.toUpperCase()).addStudent(students1.get(studentId));
				   students1.get(studentId).addCourse(courses1.get(courseCode.toUpperCase()).getName(), courses1.get(courseCode.toUpperCase()).getCode(),courses1.get(courseCode.toUpperCase()).getDesc(), courses1.get(courseCode.toUpperCase()).getFormat(), courses1.get(courseCode.toUpperCase()).getSemester(),0);
			   }
		   }
	   }   
   }
   
   // Given a studentId and a course code, drop student from the active course
   public void dropCourse(String studentId, String courseCode)
   {
	   // Find the active course
	   // Find the student in the list of students for this course
	   // If student found:
	   //   remove the student from the active course
	   //   remove the credit course from the student's list of credit courses


	   if(students1.containsKey(studentId)==true){
		if (students1.get(studentId).hasTaken(courseCode)){
			if (courses1.containsKey(courseCode.toUpperCase())){
				courses1.get(courseCode.toUpperCase()).removeStudent(students1.get(studentId));
				students1.get(studentId).removeActiveCourse(courseCode);
			}
		}
	}   
   }
   
   // Print all active courses
   public void printActiveCourses()
   {
	   //get all keys
	Set<String> keys = courses1.keySet();
        
	//using for loop
	for(String key : keys){
		System.out.println(courses1.get(key).getDescription() );   //cycles through students list and prints all students	
	}
   }			
   
   // Print the list of students in an active course
   public void printClassList(String courseCode)
   {
	   if(courses1.containsKey(courseCode.toUpperCase())){
		   courses1.get(courseCode.toUpperCase()).printClassList();
	   }
   }
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseByName(String courseCode)
   {
	   if(courses1.containsKey(courseCode.toUpperCase())){
		   courses1.get(courseCode.toUpperCase()).sortByName();
	   }   
   }
   
   // Given a course code, find course and sort class list by student id
   public void sortCourseById(String courseCode)
   {
	if(courses1.containsKey(courseCode.toUpperCase())){
		courses1.get(courseCode.toUpperCase()).sortById();
	}
   }
   
   // Given a course code, find course and print student names and grades
   public void printGrades(String courseCode)
   {
	   if(courses1.containsKey(courseCode.toUpperCase())){
		   courses1.get(courseCode.toUpperCase()).printGrades(courseCode);
	   }
   }
   
   // Given a studentId, print all active courses of student
   public void printStudentCourses(String studentId)
   {
	   if(students1.containsKey(studentId)){
		   students1.get(studentId).printCreditCourses();
	   }
   }
   
   // Given a studentId, print all completed courses and grades of student
   public void printStudentTranscript(String studentId)
   {
	if(students1.containsKey(studentId)){
		students1.get(studentId).printTranscript();
	}	   
   }
   
   // Given a course code, student id and numeric grade
   // set the final grade of the student
   public void setFinalGrade(String courseCode, String studentId, double grade2)
   {
	   // find the active course
	   // If found, find the student in class list
	   // then search student credit course list in student object and find course
	   // set the grade in credit course and set credit course inactive
	   if (courses1.containsKey(courseCode.toUpperCase())){
		   if (students1.containsKey(studentId) && students1.get(studentId).hasTaken(courseCode)){
			   students1.get(studentId).setGrade(grade2, courseCode);
		   }
	   }
	   
	   
   }

   public TreeMap<String,ActiveCourse> getCourses()
  {
	  return courses1; //returns treemap
  }

  private static boolean isStringOnlyAlphabet(String str) 
  { //checks too see if the sting inputted is only alpabetical
	return ((!str.equals("")) 
            && (str != null) 
            && (str.matches("^[a-zA-Z]*$")));
  } 
  
  public static boolean isNumeric(String str)
  {
      //  checks if string str contains only numeric characters
	  for (int i = 0; i < str.length(); i++) {
		if (!Character.isDigit(str.charAt(i)))
		  return false;
	  }
	  return true;
  }
  
}
