//NAME: ARHUM SHAH
//STUDENT NUMBER: 500957220
import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student implements Comparable<Student>
{
  private String name;
  private String id;
  public  ArrayList<CreditCourse> courses;
  
  
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  public String getId()
  {
	  return id; //returns id
  }
  
  public String getName()
  {
	  return name; //returns name
  }

  
  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
	  // create a CreditCourse object
	  // set course active
    // add to courses array list
    CreditCourse c = new CreditCourse(courseName,courseCode,descr,format,sem,grade);
    c.setActive();
    courses.add(c);
  }

//sets student grade in a coursecode
  public void setGrade(double grade1, String courseCode)
  {
    for(int x=0 ;x<courses.size();x++ ){
       if (courses.get(x).getCode().equalsIgnoreCase(courseCode)){ //if course code is the same aas the entered one
          courses.get(x).setGrade(grade1); //set grade to what is enterd
          courses.get(x).setInactive(); //set course to inactive
       }
    }
  }

  //checks too ses if student has taken course
  public Boolean hasTaken(String code){
    for(int x = 0; x<courses.size();x++){
      if(courses.get(x).getCode().equalsIgnoreCase(code)){ //cycles through students courses and if the course code matches the one entered returns tru
        return true;
      }
    }
    return false; //else returns false
  }
  
  
  
  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript()
  {
	  for (int x=0;x<courses.size();x++){
      if (courses.get(x).getActive()== false){ //goes through courses of a student ptints all non active ones
         System.out.println(courses.get(x).displayGrade());
      }
    }
  }
  
  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses()
  {
	 for (int x=0;x<courses.size();x++){
     if (courses.get(x).getActive()== true){ //goes through courses of a student ptints all  active ones
        System.out.println(courses.get(x));
     }
   }
  }
  
  // Drop a course (given by courseCode)
  // Find the credit course in courses arraylist above and remove it
  // only remove it if it is an active course
  public void removeActiveCourse(String courseCode)
  {
    for (int x=0;x<courses.size();x++){
      if (courses.get(x).getActive()== true && courses.get(x).getCode().equalsIgnoreCase(courseCode)){ //goes through courses of a student id course is active and coursecode mathce sthe one given than it removes the course for mactive courses list
         courses.remove(x);
      }
    }
	 
  }

  //prints all credit couses
  public void printCreditCourses(){
    for(int x =0; x<courses.size();x++){
      System.out.println(courses.get(x).getDescription()); // cycles through courses and description of all of them
    }
  }
  // prints all grades of a course code
  public void printGrades(String courseCode){
    for(int x =0; x<courses.size();x++){
      if(courses.get(x).getCode().equalsIgnoreCase(courseCode)){// cycles through courses, sees if it matches course code than prints grades and names of students in that course
        System.out.println(courses.get(x).getGrade()); 
      }
    }
  }
  
  
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name; //prints student id and name of sutudent
  }
  

   	public int compareTo(Student a) 
    { 
      return (this.name.compareTo(a.getName())); //sorts class list by name
    } 
  
  
  // override equals method inherited from superclass Object
  // if student names are equal *and* student ids are equal (of "this" student
  // and "other" student) then return true
  // otherwise return false
  // Hint: you will need to cast other parameter to a local Student reference variable
  public boolean equals(Student other){
    boolean result;
    if((other == null) || (getClass() != other.getClass())){
        result = false;
    } // end if
    else{
        Student otherStudent = (Student)other;
        result = name.equals(other.name) &&  id.equals(other.id);
    } // end else

    return result;
} // end equals
  }
  
  

