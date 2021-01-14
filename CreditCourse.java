//NAME: ARHUM SHAH
//STUDENT NUMBER: 500957220
public class CreditCourse extends Course
{
	private String semester;
	public double grade; 
	public boolean active;
	// add a constructor method with appropriate parameters
	// should call the super class constructor
	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		super(name,code,descr,fmt);
		this.semester = semester;
		this.grade = grade;
		active = true;
	}
	
	public boolean getActive()
	{
		return active; //return if Course is active
	}
	
	public void setActive()
	{
		active=true; //set active variable to true
	}
	
	public void setInactive()
	{
		active= false; //set active variable to false
	}

	public void setGrade(double grade1){
		grade = grade1; //set grade to whatever is entered
	}

	public double getGrade(){
		return grade; //retrns grade
	}
	
	public String displayGrade()
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		return super.getInfo() + " " + semester + " Grade " + convertNumericGrade(grade); //prints cour course info plus emester adn grae achived
	}
	
}