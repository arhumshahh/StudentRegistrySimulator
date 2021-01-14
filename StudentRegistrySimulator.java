//NAME: ARHUM SHAH
//STUDENT NUMBER: 500957220
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistrySimulator 
{
  public static void main(String[] args)
  {	 
	Registry registry = null;
	Scheduler sch = null;
	  try{
		registry = new Registry();
		sch = new Scheduler(registry.getCourses());
	  }
		catch (BadFileException e){
			System.out.println(e.getMessage());
		}
		catch (FileNotFoundException e){
			System.out.println("student.txt File Not Found");
		}
		catch(Exception e){
			System.out.println("");
		}
	  
	  Scanner scanner = new Scanner(System.in);
	  System.out.print(">");

	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) continue;
		  
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  registry.printAllStudents();
		  }
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
			  return;
		  
		  else if (command.equalsIgnoreCase("REG"))
		  {
			  // register a new student in registry
			  // get name and student id string 
			  // e.g. reg JohnBoy 74345
			  // Checks:
			  //  ensure name is all alphabetic characters
			  //  ensure id string is all numeric characters
			  try{ // does this if eveything works without an exception
			  String namee = commandLine.next();
			  String idd = commandLine.next();
			  if (isStringOnlyAlphabet(namee) && isNumeric(idd)){ //  if name is alapabetic and id is numeric 
					registry.addNewStudent(namee, idd); // add new student
			  }
			  else if ((isStringOnlyAlphabet(namee) == false)){
				  System.out.println("Invalid Charecters in Name " + namee); // if name isnt alapabetic print error msg
			  }
			  else if ((isNumeric(idd) == false)){
				System.out.println("Invalid Charecters in ID " + idd); // if id isnt numric print error msg
			  }
			}
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("DEL"))
		  {
			  try{
			  // delete a student from registry
			  String id = commandLine.next();// get student id
			  if(isNumeric(id)){// ensure numeric
				  registry.removeStudent(id);// remove student from registry
			  }
			}
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  
		  else if (command.equalsIgnoreCase("ADDC"))
		  {
			  try{
			 // add a student to an active course
			 String id = commandLine.next(); //gets id
			 String courseCode = commandLine.next(); //gets coursecode
			 registry.addCourse(id, courseCode); // add student to course (see class Registry)
			  }
			  catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
			  
		  }
		  else if (command.equalsIgnoreCase("DROPC"))
		  { try{
			  // get student id and course code strings
			 String id = commandLine.next(); //gets id
			 String courseCode = commandLine.next(); //gets cousecode
			 registry.dropCourse(id, courseCode);// drop student from course (see class Registry)
		  }
		  catch(Exception e){ //if there is an exception it prints another blank line
			System.out.print("");
		} 
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
			  // print all active courses
			  registry.printActiveCourses();
			  
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			try {
			  String courseCode = commandLine.next(); // gets course code string
			  registry.printClassList(courseCode); // print class list (i.e. students) for this course
			  }
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
			try{
			  String courseCode = commandLine.next(); // gets course code string
			  registry.printGrades(courseCode); // prints name, id and grade of all students in active course
			  }
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			try{
			  // get student id string
			  // print all credit courses of student
			  String id = commandLine.next();
			  registry.printStudentCourses(id);
			}
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
			try {
			  String id = commandLine.next(); // gets student id string
			  registry.printStudentTranscript(id); // prints student transcript
			  }
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
			try{
			  // set final grade of students
			  String courseCode = commandLine.next(); //gets course code
			  String id = commandLine.next(); //gets id
			  double grade2 = commandLine.nextDouble(); //gets grade
			  registry.setFinalGrade(courseCode, id, grade2); // uses registry to set final grade of this student
			  }
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {	  
			try{
			  // sort list of students in course by name (i.e. alphabetically)
			  String courseCode = commandLine.next();// get course code
			  registry.sortCourseByName(courseCode); // sorts list of students in course by name (i.e. alphabetically)
			  }
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
			  
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
		try{
			// sort list of students in course by student id
			String courseCode = commandLine.next(); // gets course code
			registry.sortCourseById(courseCode); // sorts list of students in course by student id
			  }
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("PSCH"))
		  {
		try{
				// sort list of students in course by student id
				sch.printSchedule(); // sorts list of students in course by student id
			  }
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.print("");
			} 
		  }
		  else if (command.equalsIgnoreCase("SCH"))
		  {
			// sort list of students in course by student id
			String courseCode = commandLine.next(); //gets course code
			String day = commandLine.next(); //gets course code
			Integer time = commandLine.nextInt(); //gets course code
			Integer duration = commandLine.nextInt(); //gets course code
			try{
			sch.setDayAndTime(courseCode,day,time,duration); // sorts list of students in course by student id
			  }
			catch(UnknownCourseException e){ //if there is an exception it prints another blank line
				System.out.println("Unknown Course: " + courseCode);
			} 
			catch(InvalidDayException e){ //if there is an exception it prints another blank line
				System.out.println("Invalid Lecture Day");
			} 
			catch(InvalidTimeException e){ //if there is an exception it prints another blank line
				System.out.println("Invalid Lecture Start Time");
			} 
			catch(InvalidDurationException e){ //if there is an exception it prints another blank line
				System.out.println("Invalid Lecture Duration");
			} 
			catch(LectureTimeCollisionException e){ //if there is an exception it prints another blank line
				System.out.println("Lecture Time Collision");
			}
			catch(Exception e){ //if there is an exception it prints another blank line
				System.out.println("");
			}
		  }
		  else if (command.equalsIgnoreCase("CSCH"))
		  {
			try{
				String courseCode = commandLine.next(); //gets course code
					// sort list of students in course by student id
					sch.clearSchedule(courseCode); // sorts list of students in course by student id
				}
				catch(Exception e){ //if there is an exception it prints another blank line
					System.out.print("");
				} 
			}

			else if (command.equalsIgnoreCase("ASCH"))
		  {
			try{
				String courseCode = commandLine.next(); //gets course code
				Integer duration = commandLine.nextInt(); //gets course code

				sch.autoAdd(courseCode, duration);
				}
				catch(NoAvailibleTimeException e){ //if there is an exception it prints another blank line
					System.out.print(e.getMessage());
				} 
			}
		System.out.print("\n>");
		}
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