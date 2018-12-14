
public class Record implements Comparable<Record> {
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private String message;
	
	public Record(int year, int month, int day, int hour, int minute, String message) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.message = message;
	}

	@Override
	public int compareTo(Record record) {
		if (this.year > record.year)
			return 1;
		else if (this.year < record.year)
			return -1;
		
		if (this.month > record.month)
			return 1;
		else if (this.month < record.month)
			return -1;
		
		if (this.day > record.day)
			return 1;
		else if (this.day < record.day)
			return -1;
		
		if (this.hour > record.hour) 
			return 1;
		else if (this.hour < record.hour)
			return -1;
		
		if (this.minute > record.minute)
			return 1;
		else if (this.minute < record.minute)
			return -1;
		
		return 0;
	}
	
	public void print() {
		System.out.println("[" + year + "-" + month + "-" + day + " " + hour + ":" + minute + "]" + " " + message);
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getMinute() {
		return minute;
	}

}
