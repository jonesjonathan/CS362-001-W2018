package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
			TimeTable t = new TimeTable();
			GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
			GregorianCalendar day2 = new GregorianCalendar(2018, 2, 1);
			GregorianCalendar day3 = new GregorianCalendar(2018, 1, 2);
			Appt appt1 = new Appt(25, 1, 1, 1, 2018, "Test", "This is a test"); //Invalid appt
			Appt appt2 = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test"); //Valid appt at base case time
			Appt appt3 = new Appt(2, 1, 5, 1, 2018, "Test", "This is a test"); //Valid appt with recurrences 5 days and 1 hour after base time
			Appt appt4 = new Appt(3, 1, 1, 1, 2018, "Test", "This is a test");
			Appt appt5 = new Appt(4, 1, 1, 1, 2018, "Test", "This is a test");
			int[] myArray = new int[]{1, 2, 4};
			int[] emptyArr = new int[]{};
			appt3.setRecurrence(myArray, 1, 1, 3);
			appt2.setRecurrence(emptyArr, 1, 1, 3);
			appt5.setRecurrence(emptyArr, 3, 3, 3);
			assertEquals(0, appt2.getRecurDays().length);
			CalDay c1 = new CalDay(day1);
			LinkedList<CalDay> temp;

			c1.addAppt(appt2);
			t.getApptRange(c1.getAppts(), day1, day2);
			temp = t.getApptRange(c1.getAppts(), day1, day2);
			assertEquals(28, temp.size());
			c1.addAppt(appt3);
			t.getApptRange(c1.getAppts(), day1, day2);
			assertEquals(28, temp.size());
			c1.addAppt(appt4);
			t.getApptRange(c1.getAppts(), day1, day2);
			c1.addAppt(appt5);
			t.getApptRange(c1.getAppts(), day1, day3);


	 }
	 @Test //Testing deleteAppt
	  public void test02()  throws Throwable  {
			TimeTable t = new TimeTable();
			GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
			GregorianCalendar day2 = new GregorianCalendar(2018, 2, 1);
			Appt appt1 = new Appt(25, 1, 1, 1, 2018, "Test", "This is a test"); //Invalid appt
			Appt appt2 = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test"); //Valid appt at base case time
			Appt appt3 = new Appt(2, 1, 5, 1, 2018, "Test", "This is a test"); //Valid appt with recurrences 5 days and 1 hour after base time
			Appt appt4 = new Appt(3, 1, 1, 1, 2018, "Test", "This is a test");
			CalDay c1 = new CalDay(day1);
			assertEquals(null, t.deleteAppt(c1.getAppts(), appt2));
			assertEquals(null, t.deleteAppt(null, null));
			c1.addAppt(appt1);
			assertEquals(null, t.deleteAppt(c1.getAppts(), appt1));
			assertEquals(null, t.deleteAppt(c1.getAppts(), null));
			c1.addAppt(appt2);
			c1.addAppt(appt3);
			c1.addAppt(appt4);
			assertNotNull(t.deleteAppt(c1.getAppts(), appt3));
			assertEquals(null, t.deleteAppt(c1.getAppts(), appt3));
			//assertNotNull(t.deleteAppt(c1.getAppts(), appt4));
	 }

	 @Test //Check that we can do a complete run of this code
	 public void test03()  throws Throwable  {
		 TimeTable t = new TimeTable();
		 GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
		 GregorianCalendar day2 = new GregorianCalendar(2018, 2, 1);
		 Appt appt2 = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test"); //Valid appt at base case time
		 Appt appt3 = new Appt(2, 1, 5, 1, 2018, "Test", "This is a test"); //Valid appt with recurrences 5 days and 1 hour after base time
		 Appt appt4 = new Appt(3, 1, 1, 1, 2018, "Test", "This is a test");
		 CalDay c1 = new CalDay(day1);

		 c1.addAppt(appt2);
		 c1.addAppt(appt3);
		 c1.addAppt(appt4);
		 int[] myArray  = new int[]{1, 2, 0};

		 t.permute(c1.getAppts(), myArray);
	}
//add more unit tests as you needed
}
