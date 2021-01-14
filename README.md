# StudentRegistrySimulator
Small scale version of a student registry program used in schools/universites

how to use

“L” : list all the students in the registry. This one has been done for you. 
“Q” : quit out of the program. Also done for you.
“REG” : register a student. Reads a student name and student id from the commandLine scanner (see code). Uses Registry method to register the new student. Just make up a 5 digit id. 
“DEL”: deletes a student from the registry. 
“ADDC”: adds a student to an active course
“DROPC”: drops a student from an active course
“PAC” : prints all active course
“PCL” : prints class list for an active course
“PGR” : prints student id and grade for all students in an active course
“PSC” : prints all credit courses for a student
“SFG” : Set final grade of a student in a course
“SCN” : sort list of students in a course by student name
“SCI” : sort list of students in a course by student id  
“SCH courseCode day start duration”\ For example: sch cps209 Mon 900 3. Schedules a course for a certain day, start time and duration. Don’t forget to catch any exceptions thrown. Print an appropriate message to the user if an exception is thrown.
“CSCH courseCode”. Clears the schedule of the given course
“PSCH” Prints the entire schedule.
