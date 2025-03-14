package dateADT;

import java.util.Scanner;
import java.util.Calendar;

//Program which given the day name as command-line argument, prints out all the dates in 2010 falling on that named day	in ISO format. 

public class ProgramManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the given day (e.g. Monday, Tuesday, etc.): \n");
        String dayName = scanner.nextLine().trim().toLowerCase();

        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= daysInMonth(month, 2010); day++) {
                DateADT date = new Date();
                date.setDate(2010, month, day);

                if (getDayName(date).toLowerCase().equals(dayName)) {
                    System.out.println(date.toISOFormat());
                }
            }
        }
	}
	
	//Methods
	
	//REturns the number of days in a specified month of a given year
    private static int daysInMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    //Takes a DateADT object and returns the date corresponding to the specified day name (e.g., Sunday, Monday)
    private static String getDayName(DateADT date) {
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonth() - 1, date.getDay());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayNames[dayOfWeek - 1];
    }

}