import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Scheduler 
{
    // In main() after you create a Registry object, create a Scheduler object and pass in the students ArrayList/TreeMap
	// If you do not want to try using a Map then uncomment
	// the line below and comment out the TreeMap line
	
	private TreeMap<String,ActiveCourse> schedule;
	private String [][] table;
	private TreeMap<String,Integer> days;
	private TreeMap<Integer,String> days1;
		
	public Scheduler(TreeMap<String,ActiveCourse> courses)
	{
	  schedule = courses;
	  table= new String[10][6];
	  days = new TreeMap<String , Integer>();
	  days.put("MON", 1);
	  days.put("TUE", 2);
	  days.put("WED", 3);
	  days.put("THU", 4);
	  days.put("FRI", 5);

	  days1 = new TreeMap<Integer , String>();
	  days1.put(1,"MON");
	  days1.put(2,"TUE");
	  days1.put(3,"WED");
	  days1.put(4,"THU");
	  days1.put(5,"FRI");  
	}
	
	public void setDayAndTime(String courseCode, String day, int startTime, int duration)
	{
		// see assignment doc
		if(schedule.containsKey(courseCode.toUpperCase() )== false) {
			throw new UnknownCourseException ("The given courseCode cannot not be found");
		}

		if(days.containsKey(day.toUpperCase()) == false) {
			throw new InvalidDayException("The String perameter should be on of Mon , Tue, Wed, Thu, Fri");
		}

		if(duration !=1 ) {
			if(duration !=2 ){
				if(duration !=3 ){
					throw new InvalidDurationException("the lecture duration should be 1, 2 or 3 hours.");
				}
			}
		}

		if(startTime < 800 || (startTime + (duration*100)) > 1700) {
			throw new InvalidTimeException("The startTime parameter should not be less than 0800 (8 am) and the end time of the lecture (based on the duration parameter) should not be greater than 1700 (5pm). Use a 24 hour clock.");
		}

		Set<String> keys = schedule.keySet();

		for(String key : keys){
			if(schedule.get(key).getDay().equalsIgnoreCase(day)){
				for ( Integer i= schedule.get(key).getStartTime(); i< ((schedule.get(key).getDuration()*100) + schedule.get(key).getStartTime()); i+=100){
					for(Integer j= startTime; j< ((duration*100) + startTime); j+=100 ){
						if(j.equals(i)){ 
							throw new LectureTimeCollisionException("The day, startTime, and duration should be such that it does not create any overlap with another");
						}
					}
				}
			}
			}

			schedule.get(courseCode.toUpperCase()).setDay(day);
			schedule.get(courseCode.toUpperCase()).setDuration(duration);
			schedule.get(courseCode.toUpperCase()).setStartTime(startTime);;
	}
	
	
	
	public void clearSchedule(String courseCode)
	{
		if(schedule.containsKey(courseCode.toUpperCase())){
			schedule.get(courseCode.toUpperCase()).setDay("");
			schedule.get(courseCode.toUpperCase()).setStartTime(0);
			schedule.get(courseCode.toUpperCase()).setDuration(0);
		}

		else{
			System.out.println("");
		}
		
	}

	public void autoAdd(String courseCode , Integer duration){
		for(int x=0; x< table.length; x++){
			for (int y=0;y<table[x].length;y++){
				if (y==0)
				{
					table[x][y] = Integer.toString((x+7)*100) + "    ";
					if (x==0){
						table[x][y] = "|     ";
					}
					else if (x > 2){
						table[x][y] = Integer.toString((x+7)*100) + "   ";
					}
				}
				else{
					table[x][y] = "        ";
					table[0][1] = "  Mon   ";
					table[0][2] = "  Tue   ";
					table[0][3] = "  Wed   ";
					table[0][4] = "  Thu   ";
					table[0][5] = "  Fri   ";
				}
			}
		  }
	
		Set<String> keys = schedule.keySet();
	
		for(String key : keys){
			if (schedule.get(key).getDay() != "" && schedule.get(key).getDuration() != 0 && schedule.get(key).getStartTime() != 0){
				if(schedule.get(key).getDuration() == 1){
					table[((schedule.get(key).getStartTime())/100)-7][days.get(schedule.get(key).getDay().toUpperCase())] = schedule.get(key).getCode() + "  ";
				}
			else{
				for(int i=0 ; i< schedule.get(key).getDuration(); i++){
					table[((schedule.get(key).getStartTime())/100)-7+i][days.get(schedule.get(key).getDay().toUpperCase())] =  schedule.get(key).getCode()  + "  " ;
				}
			}
			}
		}

		for(int x=0; x< table.length; x++){
			System.out.print("\n");
			for (int y=0;y<table[x].length;y++){
				if(table[x][y].equalsIgnoreCase("        ")){
					for(int h = 0; h<duration; h++){
						if ( table[x][y+h].equalsIgnoreCase("        ")){
							if (h == (duration-1)){
								setDayAndTime(courseCode.toUpperCase(), days1.get(y), (x*100) + 700, duration);
								return;
							}
						}
					}
				}
			}
			}
			throw new NoAvailibleTimeException("There is nowhere the course fits in the schedule");
	}
		
	public void printSchedule()
	{
	for(int x=0; x< table.length; x++){
		for (int y=0;y<table[x].length;y++){
			if (y==0)
			{
				table[x][y] = Integer.toString((x+7)*100) + "    ";
				if (x==0){
					table[x][y] = "|     ";
				}
				else if (x > 2){
					table[x][y] = Integer.toString((x+7)*100) + "   ";
				}
			}
			else{
				table[x][y] = "        ";
				table[0][1] = "  Mon   ";
				table[0][2] = "  Tue   ";
				table[0][3] = "  Wed   ";
				table[0][4] = "  Thu   ";
				table[0][5] = "  Fri   ";
			}
		}
	  }

	Set<String> keys = schedule.keySet();

	for(String key : keys){
		if (schedule.get(key).getDay() != "" && schedule.get(key).getDuration() != 0 && schedule.get(key).getStartTime() != 0){
			if(schedule.get(key).getDuration() == 1){
				table[((schedule.get(key).getStartTime())/100)-7][days.get(schedule.get(key).getDay().toUpperCase())] = schedule.get(key).getCode() + "  ";
			}
		else{
			for(int i=0 ; i< schedule.get(key).getDuration(); i++){
				table[((schedule.get(key).getStartTime())/100)-7+i][days.get(schedule.get(key).getDay().toUpperCase())] =  schedule.get(key).getCode()  + "  " ;
			}
		}
		}
	}

	for(int x=0; x< table.length; x++){
		System.out.print("\n");
		for (int y=0;y<table[x].length;y++){
			System.out.print(table[x][y]);
		}
		}
	}
	
}

