/**
 * TicklerFileTest class to test run the Tickler System 43 File
 * @author Yassin Ting
 * @student ID 2014359
 * @version 1.0
 *
*/

public class TicklerFileTest {
	
	public static void main(String[] args) {
		
		TicklerFile tickler = new TicklerFile();
		tickler.advance();
		tickler.scheduleTask("Test", 1, 12);
		tickler.printTasks();
		tickler.completeTask("Test Again",12,5);
	}
}
