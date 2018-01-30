package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
			CalDay c = new CalDay();
			assertFalse(c.isValid());
			assertEquals(null, c.iterator());
			assertNotNull(c.toString());
	 }

	 @Test
	  public void test02()  throws Throwable  {
			GregorianCalendar cal = new GregorianCalendar(2018, 1, 1);
			CalDay c = new CalDay(cal);

			assertTrue(c.isValid());
			assertNotNull(c.iterator());
			assertEquals(2018, c.getYear());
			assertEquals(1, c.getMonth());
			assertEquals(1, c.getDay());

			//Is the linked list empty?
			assertEquals(null, c.getAppts().peekFirst());
			assertEquals(0, c.getSizeAppts());

			//Print it even though print is broken
			c.toString();
	 }

	 @Test
	 	public void test03() throws Throwable
		{
			Appt appt1 = new Appt(25, 1, 1, 1, 2018, "Test", "This is a test");
			Appt appt2 = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test");
			Appt appt3 = new Appt(2, 1, 1, 1, 2018, "Test", "This is a test");
			GregorianCalendar cal = new GregorianCalendar(2018, 1, 1);
			CalDay c1 = new CalDay(cal);
			CalDay c2 = new CalDay(cal);

			c1.addAppt(appt1);
			assertEquals(null, c1.getAppts().peekFirst());
			assertEquals(0, c1.getSizeAppts());

			c1.addAppt(appt2);
			c1.addAppt(appt3);
			assertEquals(appt2, c1.getAppts().peekFirst());
			assertEquals(appt3, c1.getAppts().peekLast());
			assertEquals(2, c1.getSizeAppts());

			assertTrue(c1.isValid());
			//We know toString is broken
			assertNotNull(c1.toString());

			c2.addAppt(appt3);
			c2.addAppt(appt2);
			assertEquals(appt3, c2.getAppts().peekLast());
			assertEquals(appt2, c2.getAppts().peekFirst());
			assertEquals(2, c2.getSizeAppts());

			//We know toString is broken
			assertNotNull(c2.toString());
			assertTrue(c2.isValid());
		}
//add more unit tests as you needed
}
