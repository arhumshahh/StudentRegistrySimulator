//NAME: ARHUM SHAH
//STUDENT NUMBER: 500957220
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
 
public class ActiveCourse extends Course
{
	private ArrayList<Student> students; 
   private String             semester;
   private Integer startTime;
   private Integer duration;
   private String day; 
	
	   
   // Add a constructor method with appropriate parameters
   // should call super class constructor to initialize inherited variables
   // make sure to *copy* students array list being passed in into new arraylist of students
   // see class Registry to see how an ActiveCourse object is created and used
   public ActiveCourse(String name, String code, String descr, String fmt,String semester,ArrayList<Student> students, Integer startTime,Integer duration,String day)
   {
      super(name, code ,descr, fmt);//ccalls super class to get these variables
      this.semester=semester; // gets semester and assigns it to variable
      this.students = new ArrayList<Student>(students); // assigns this students arraylist to arraylist
      this.startTime=startTime;
      this.duration=duration;
      this.day=day;
   }
   
   public String getSemester()
   {
	   return semester; //returns semster
   }

   public Integer getStartTime()
   {
	   return startTime; //returns semster
   }
   
   public Integer getDuration()
   {
	   return duration; //returns semster
   }

   public String getDay()
   {
	   return day; //returns semster
   }
   
   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
      for(int x=0; x<students.size();x++){
         System.out.println(students.get(x).toString()); //cycles through the students arrayllist(class list) and prints their name
      }
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   // 
   public void printGrades(String courseCode)
   {
      for (int x=0; x<students.size();x++){
         System.out.print( students.get(x).getId() + " " + students.get(x).getName() + " "); //clylces though list of students in  course code and prints their grade
         students.get(x).printGrades(courseCode);
      }
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription()
   {
	   return super.getDescription() + " "  + semester + " Enrollment " + students.size() + "\n" ; //gets description of course
   }

   public String getDesc()
   {
	   return super.getDesc() ; //gets description of course (used in certain senerios where getDescription prints the wrong thing)
   }
    
   public void addStudent(Student e){
      students.add(e); //adds student to course list
   }


   public void removeStudent(Student e){
      students.remove(e);//removes student from course list
   }
   
   public void setStartTime(Integer st){
      startTime = st;
   }
   
   public void setDuration(Integer d){
      duration = d;
   }

   public void setDay(String da){
      day = da;
   }
   
   
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {
 	  Collections.sort(students,new NameComparator()); //sorts class list by name
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator<Student>
   {
   	public int compare(Student a, Student b) 
    { 
      return a.getName().compareTo(b.getName()); //sorts class list by name
    } 
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
      Collections.sort(students,new IdComparator()); //sorts class list by id
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator<Student>
   {
   	public int compare(Student c, Student d) 
    { 
      return c.getId().compareTo(d.getId()); // checks to see if the two student ids are the same for sorting
    } 
   }
}
