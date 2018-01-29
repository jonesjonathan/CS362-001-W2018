package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }

	 @Test //Test validity
	  public void test02()  throws Throwable  {
 		 //Construct a new Appointment object with the initial data
 		 Appt appt1 = new Appt(25,
 		          30 ,
 		          15 ,
 		          01 ,
 		          2018 ,
 		          "Birthday Party",
 		         "This is my birthday party.");
		 assertFalse(appt1.getValid());
		 Appt appt2 = new Appt(21,
 		          100 ,
 		          15 ,
 		          01 ,
 		          2018 ,
 		          "Birthday Party",
 		         "This is my birthday party.");
		 assertFalse(appt2.getValid());
		 Appt appt3 = new Appt(21,
 		          30 ,
 		          40 ,
 		          01 ,
 		          2018 ,
 		          "Birthday Party",
 		         "This is my birthday party.");
		 assertFalse(appt3.getValid());

	 }

	 @Test
	 	public void test03() throws Throwable {
			Appt appt = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test");
			appt.setStartDay(5);
			appt.setStartHour(5);
			appt.setStartYear(2020);
			appt.setStartMonth(5);
			appt.setStartMinute(5);

			assertTrue(appt.getValid());
			assertEquals(5, appt.getStartDay());
			assertEquals(5, appt.getStartHour());
			assertEquals(2020, appt.getStartYear());
			assertEquals(5, appt.getStartMonth());
			assertEquals(5, appt.getStartMinute());
		}
//add more unit tests as you needed

}
