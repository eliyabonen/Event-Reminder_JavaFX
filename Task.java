package eventReminder.pack;

public class Task
{
	private String title, description;
	int hours, minutes, seconds, AP;
	
	public Task(String title, String description, int hours, int minutes, int seconds, int AP)
	{
		this.title = title;
		this.description = description;
		
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.AP = AP;
	}
	
	public String getTitle() { return title; }
	public String getDescription() {return description; }
	
	public int getHours() { return hours; }
	public int getMinutes() { return minutes; }
	public int getSeconds() { return seconds; }
	public int getAP() { return AP; }
}