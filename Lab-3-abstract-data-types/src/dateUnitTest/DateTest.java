package dateUnitTest;

import dateADT.Date;
import dateADT.DateADT;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

//JUnit tests to cover the tests to cover the functionality of each method implemented in Date

public class DateTest {

    private DateADT date;

    @Before
    public void setUp() {
        date = new Date();
    }

    @Test
    public void testSetDay() {
        date.setDay(15);
        assertEquals(15, date.getDay());
    }

    @Test
    public void testSetMonth() {
        date.setMonth(6);
        assertEquals(6, date.getMonth());
    }

    @Test
    public void testSetYear() {
        date.setYear(2023);
        assertEquals(2023, date.getYear());
    }

    @Test
    public void testIsValidDate() {
        date.setDate(2023, 10, 15);
        assertTrue(date.isValidDate());
    }

    @Test
    public void testIsInvalidDate() {
        date.setDate(2023, 13, 31);
        assertFalse(date.isValidDate());
    }

    @Test
    public void testToISOFormat() {
        date.setDate(2023, 10, 15);
        assertEquals("2023-10-15", date.toISOFormat());
    }

    @Test
    public void testAdvanceByDays() {
        date.setDate(2023, 10, 15);
        date.advanceByDays(5);
        assertEquals(20, date.getDay());
    }

    @Test
    public void testRetreatByDays() {
        date.setDate(2023, 10, 15);
        date.retreatByDays(5);
        assertEquals(10, date.getDay());
    }

    @Test
    public void testCompareTo() {
        DateADT date2 = new Date();
        date.setDate(2023, 10, 15);
        date2.setDate(2023, 10, 10);
        assertTrue(date.compareTo(date2) > 0);
    }
}
