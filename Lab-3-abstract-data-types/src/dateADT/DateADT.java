package dateADT;

//Contract or specification for the Date ADT based on the requirements for the Date ADT

/**
 * The Date ADT represents a date with day, month, and year components.
 * The date should be a valid past, present, or future date.
 */
public interface DateADT {

	/**
     * Set the day of the date.
     *
     * @param day The day of the date.
     */
    void setDay(int day);

    /**
     * Get the day of the date.
     *
     * @return The day of the date.
     */
    int getDay();

    /**
     * Set the month of the date.
     *
     * @param month The month of the date (1-12).
     */
    void setMonth(int month);

    /**
     * Get the month of the date.
     *
     * @return The month of the date (1-12).
     */
    int getMonth();

    /**
     * Set the year of the date.
     *
     * @param year The year of the date.
     */
    void setYear(int year);

    /**
     * Get the year of the date.
     *
     * @return The year of the date.
     */
    int getYear();

    /**
     * Check if the date is a valid date.
     *
     * @return True if the date is valid, false otherwise.
     */
    boolean isValidDate();

    /**
     * Construct a date from the given year, month, and day.
     *
     * @param year  The year of the date.
     * @param month The month of the date (1-12).
     * @param day   The day of the date.
     */
    
    void setDate(int year, int month, int day);

    /**
     * Compare this date with another date.
     *
     * @param otherDate The date to compare with.
     * @return 0 if the dates are equal, a negative value if this date is before the other date,
     *         a positive value if this date is after the other date.
     */
    int compareTo(DateADT otherDate);

    /**
     * Get the date in ISO format (e.g., "2023-10-16").
     *
     * @return The date in ISO format.
     */
    String toISOFormat();

    /**
     * Advance the date by a given number of days.
     *
     * @param days The number of days to advance the date by.
     */
    void advanceByDays(int days);

    /**
     * Retreat the date by a given number of days.
     *
     * @param days The number of days to retreat the date by.
     */
    void retreatByDays(int days);

}
