/**
 * Month class contains methods specific of the list of tasks, list of days and month number.
 * @author Yassin Ting
 * @student ID 2014359
 * @version 1.0
 *
*/

public class Month {
	// array list for the tasks
	LinkedList<Task> listOfTasks;
	// array list of days
	LinkedList<Day> listOfDays;
	// declare variable for number of month
	int monthNumber;
	Month(int monthNumber){
		listOfTasks = new LinkedList<Task>();   // declare list of tasks array
		listOfDays = new LinkedList<Day>();       // declare list of days array
		this.monthNumber = monthNumber;                 // month represent by number
	}
	void addDay(Day day){
		listOfDays.add(day);   //add day to the day list
	}
	//grab data from the current day
	Day getFirstDay(){
		return listOfDays.getHead().getData();    
	}
	//grab data from the next day
	Day getNextDay(){
		if(listOfDays.size >  1)
			return listOfDays.get(1);
		else
			return null;
	}
}
