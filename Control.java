package eventReminder.pack;

import java.util.ArrayList;

public class Control
{
	public static ArrayList<Task> taskArray = new ArrayList<Task>();
	public static ReminderBox reminderBox = new ReminderBox();
	
	public static void check()
	{
		for(int i = 0; i < taskArray.size(); i++)
		{
			if(taskArray.get(i).getHours() == Main.hours && taskArray.get(i).getMinutes() == Main.minutes && taskArray.get(i).getSeconds() == Main.seconds
					 && taskArray.get(i).getAP() == Main.realAP)
			{
				reminderBox.display("Event", taskArray.get(i).getTitle(), taskArray.get(i).getDescription());
				taskArray.remove(i);
			}
		}
	}
	
	public static void addTask(Task t)
	{
		taskArray.add(t);
	}
	
	public static void removeTask(Task t)
	
	{
		taskArray.remove(t);
	}
}