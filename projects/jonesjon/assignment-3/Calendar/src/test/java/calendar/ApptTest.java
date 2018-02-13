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
		 assertEquals(null, appt1.toString());
		 Appt appt2 = new Appt(21,
 		          100 ,
 		          15 ,
 		          01 ,
 		          2018 ,
 		          "Birthday Party",
 		         "This is my birthday party.");
		 assertFalse(appt2.getValid());
		 assertEquals(null, appt2.toString());
		 Appt appt3 = new Appt(21,
 		          30 ,
 		          40 ,
 		          01 ,
 		          2018 ,
 		          "Birthday Party",
 		         "This is my birthday party.");
		 assertFalse(appt3.getValid());
		 assertEquals(null, appt3.toString());

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

	 @Test //Recurrence
	  public void test04() throws Throwable {
			int[] myArray = new int[]{1, 2, 4};
			Appt appt = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test");
 		 	appt.setRecurrence(myArray, 1, 1, 1);

			//Assertions
			assertTrue(appt.isRecurring());
			for(int i = 0; i < 3; i++)
			{
				assertEquals(myArray[i], appt.getRecurDays()[i]);
			}
			assertEquals(1, appt.getRecurNumber());
			assertEquals(1, appt.getRecurBy());
			assertEquals(1, appt.getRecurIncrement());
		}

	@Test
		public void test05() throws Throwable
		{
			Appt appt1 = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test");
			String goodO = "\t1/1/2018 at 1:1am ,Test, This is a test\n";
			assertEquals(goodO, appt1.toString());

			Appt appt2 = new Appt(0, 1, 1, 1, 2018, "Test", "This is a test");
			goodO = "\t1/1/2018 at 12:1am ,Test, This is a test\n";
			assertEquals(goodO, appt2.toString());

			Appt appt3 = new Appt(13, 1, 1, 1, 2018, "Test", "This is a test");
			goodO = "\t1/1/2018 at 1:1pm ,Test, This is a test\n";
			assertEquals(goodO, appt3.toString());
		}

	@Test //Title and description branch tests
		public void test06() throws Throwable
		{
			Appt appt1 = new Appt(1, 1, 1, 1, 2018, null, "This is a test");
			assertEquals("", appt1.getTitle());

			Appt appt2 = new Appt(1, 1, 1, 1, 2018, "Test", null);
			assertEquals("", appt2.getDescription());

			Appt appt3 = new Appt(1, 1, 1, 1, 2018, null, null);
			assertEquals("", appt3.getTitle());
			assertEquals("", appt3.getDescription());
		}

		@Test
			public void test07() throws Throwable
			{
				Appt appt = new Appt(1, 1, 29, 2, 2018, "Test", "This is a test"); //Check num days
				Appt appt2 = new Appt(1, 1, 1, 1, 2018, "Test", "This is a test"); //Check start edge case days
				Appt appt3 = new Appt(1, 0, 5, 1, 2018, "Test", "This is a test"); //Check start edge case minute
				Appt appt4 = new Appt(0, 1, 5, 1, 2018, "Test", "This is a test"); //Check start edge case hour
				Appt appt5 = new Appt(1, 1, 5, 1, 2018, "Test", "This is a test"); //Check end edge case days
				Appt appt6 = new Appt(1, 59, 5, 1, 2018, "Test", "This is a test"); //Check end edge case minute
				Appt appt7 = new Appt(23, 1, 5, 1, 2018, "Test", "This is a test"); //Check end edge case hour
				Appt appt8 = new Appt(1, 1, 31, 1, 2018, "Test", "This is a test"); //Check end edge case day
				Appt appt9 = new Appt(1, 1, 5, 12, 2018, "Test", "This is a test"); //Check end edge case month
				assertEquals(2, appt.getRecurBy());
				//Make sure the number of days in february is 28
				assertFalse(appt.getValid()); //Our start day was 29 in february so it must be invalid
				assertTrue(appt2.getValid()); //Start day is 1 so we should still get a true
				assertTrue(appt3.getValid());
				assertTrue(appt4.getValid());
				assertTrue(appt5.getValid());
				assertTrue(appt6.getValid());
				assertTrue(appt7.getValid());
				assertTrue(appt8.getValid());
				assertTrue(appt9.getValid());
			}

			@Test
				public void test08() throws Throwable
				{
					Appt appt = new Appt(11, 1, 1, 1, 2018, "Test", "This is a test");
					String goodO;
					goodO = "\t1/1/2018 at 11:1am ,Test, This is a test\n";
					assertEquals(goodO, appt.toString());

					appt.setStartHour(-1);
					assertFalse(appt.getValid());
					appt.setStartHour(1);

					appt.setStartMinute(-1);
					assertFalse(appt.getValid());
					appt.setStartMinute(1);

					appt.setStartDay(-1);
					assertFalse(appt.getValid());
					appt.setStartDay(1);
				}

			@Test
				public void test09() throws Throwable
				{
					Appt appt1 = new Appt(5, 4, 3, 2, 2018, "Test", "This is a test");
					Appt appt2 = new Appt(5, 4, 3, 2, 2018, "Test", "This is a test");
					Appt appt3 = new Appt(1, 1, 1, 1, 2017, "Test", "This is a test");

					assertEquals(0, appt1.compareTo(appt2));
					assertEquals(11, appt1.compareTo(appt3));
				}

}
