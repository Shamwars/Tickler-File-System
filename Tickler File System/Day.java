/**
 * Day class contains methods specific of list of tasks for the days.
 * @author Yassin Ting
 * @student ID 2014359
 * @version 1.0
 *
*/

public class Day {
	LinkedList<Task> listOfTasks;
	int date;
	Day(int date){
		listOfTasks = new LinkedList<Task>();
		this.date = date;
	}
	// method to add the tasks
	void addTasks(LinkedList<Task> list){
		if(list.getSize() > 0)
			listOfTasks.joinLists(list.getHead(), list.getSize()); 
	}
}
