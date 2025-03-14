package dateADT;

import java.util.Calendar;

//Implement methods and everything else associated with Date ADT here

public class Date implements DateADT {

	private int year;
	private int month;
	private int day;
	
	@Override
	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public int getDay() {
		return day;
	}

	@Override
	public void setMonth(int month) {
		this.month = month;
		
	}

	@Override
	public int getMonth() {
		return month;
	}

	@Override
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int getYear() {
		return year;
	}

	//Checking if the day, month, and year, are appropriate values
	@Override
	public boolean isValidDate() {
		return year > 0 && month > 0 && month <= 12 && day > 0 && day <=365;
	}
	
	@Override
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	//Comparing dates based on their year, month, and day
	@Override
	public int compareTo(DateADT otherDate) {
		if (this.year != otherDate.getYear()) {
			return Integer.compare(this.year, otherDate.getYear());
		} else if (this.month != otherDate.getMonth()) {
			return Integer.compare(this.month, otherDate.getMonth());
		} else {
			return Integer.compare(this.day, otherDate.getDay());
		}
	}

	@Override
	public String toISOFormat() {
		return String.format("%04d-%02d-%02d", year, month, day);
	}

	@Override
	public void advanceByDays(int days) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(year, month - 1, day);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public void retreatByDays(int days) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(year, month -1, day);
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
	}
	

}
