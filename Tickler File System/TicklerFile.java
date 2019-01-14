/**
 * TicklerFile class contains methods specific to the Tickler 43 System
 * @author Yassin Ting
 * @student ID 2014359
 * @version 1.0
 *
*/

public class TicklerFile {
	// array for the month
	CircularQueue<Month> monthsQueue;
	// declare variables
	Month currentMonth;
	Month nextMonth;
	Day currentDay;
	
	public TicklerFile(){
		// created queue for the months
		this.monthsQueue = new CircularQueue<Month>(12);
		fillMonthsQueue();
		fillDaysForMonth();
		currentMonth = monthsQueue.dequeue(); // When we start the application, current month is the first month in the queue (Jan)
		nextMonth = monthsQueue.front();
		currentDay = currentMonth.listOfDays.removeTop();
	}
	
	/* This method should advance the tickler file by a single day. Any unfinished tasks should be
	added on to the set of tasks for the next day. The current Day object should be added to the
	end of the list of days of the next month. If the method advances to a new month, all tasks
	stored in that month's list of tasks should be added to the first day of that month.
	*/
	public void advance(){
		Day nextDay = currentMonth.listOfDays.getTop();
		if(nextDay == null){
			nextMonth.getFirstDay().addTasks(currentMonth.listOfTasks);
			monthsQueue.enqueue(currentMonth);
			currentMonth = monthsQueue.dequeue();
			nextMonth = monthsQueue.front();
			nextDay = currentMonth.getFirstDay();
		}
		nextDay.addTasks(currentDay.listOfTasks);
		nextMonth.listOfDays.add(currentDay);
		currentDay = currentMonth.listOfDays.removeTop();
		nextDay = currentMonth.getFirstDay();		
	}
	
	// This method should print out all the tasks of the current day.
	public void printTasks(){
		currentDay.listOfTasks.printList();
	}
	
	/* This method should add the task to the set of tasks for the given month and day. If the given
       month does not have day folders in it for the requisite day, then the task should just be added
       to the set of tasks for the given month.
    */   
	public void scheduleTask(String task, int month, int day){
		currentDay.listOfTasks.add(new Task(task, day, month)); 
	}
	
	/* Assuming the tasks are give to the scheduled day, but the day won't do the task unless the task day and the current day matches.(which falls in to uncompleted tasks and they go on until they reach the actual day of the task and then gets completed) 
	   This method should move the given task from the current day to the given new date.
	*/
	public void rescheduleTask(String task, int month, int day){
		// Created linkedlist for task called list.
		LinkedList<Task> list = currentDay.listOfTasks;
		Task shiftingTask= null; // tasks to be rescheduled
		for(int i = 0; i < list.getSize(); i++){
			if(list.get(i).data.equals(task)){
				shiftingTask = list.get(i);
			}
		}
		if(shiftingTask == null)
			System.out.println("There is no such task in the current day");
		else{
			shiftingTask.day = day;
			shiftingTask.month = month;
		}
	}
	
	/* This method should mark the given task as completed (i.e., delete it from the set of tasks) in
       the set of tasks for the given month and day.
    */   
	public void completeTask(String task, int month, int day){
		LinkedList<Task> list = currentDay.listOfTasks;
		Task shiftingTask= null;
		for(int i = 0; i < list.getSize(); i++){
			System.out.println(list.get(i));
			if(list.get(i).data.equals(task)){
				shiftingTask = list.get(i);
			}
		}
		if(shiftingTask == null)
			System.out.println("There is no such task in the current day");
		else{
			list.deleteNodeWithValue(shiftingTask);
		}
	}
	// Method to set the 12 months 
	public void fillMonthsQueue(){
		for(int i = 1; i < 13; i++){
			monthsQueue.enqueue(new Month(i));
		}
	}
	// method to fill the initial 31 days per months (although not every month have 31 days)
	public void fillDaysForMonth(){ //fill initially for the first month. By default
		Month month =monthsQueue.front();
		for(int i = 1; i < 32; i++){
			month.addDay(new Day(i));
		}
	}
}
