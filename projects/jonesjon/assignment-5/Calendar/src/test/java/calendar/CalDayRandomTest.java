package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;

import java.util.*;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


			System.out.println("Start testing...");

			try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
			//			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

					int startHour=ValuesGenerator.RandInt(random);
					int startMinute=ValuesGenerator.RandInt(random);
					int startDay=ValuesGenerator.RandInt(random);
					int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int startYear=ValuesGenerator.RandInt(random);
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
					int day=ValuesGenerator.RandInt(random);
					int month=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int year=ValuesGenerator.RandInt(random);

					GregorianCalendar gCal = new GregorianCalendar(year, month, day);
					CalDay cd = new CalDay(gCal);
					cd.addAppt(appt);
					for (int i = 0; i < 10; i++) {
						int startHour2=ValuesGenerator.RandInt(random);
						int startMinute2=ValuesGenerator.RandInt(random);
						int startDay2=ValuesGenerator.RandInt(random);
						int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int startYear2=ValuesGenerator.RandInt(random);
						String title2="Birthday Party";
						String description2="This is my birthday party.";
						//Construct a new Appointment object with the initial data
						Appt appt2 = new Appt(startHour2,
										 startMinute2 ,
										 startDay2 ,
										 startMonth2 ,
										 startYear2 ,
										 title2,
										description2);
						cd.addAppt(appt2);
					}
				// if(!appt.getValid())continue;
			 // for (int i = 0; i < NUM_TESTS; i++) {
			 //
				//  }

					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
							 if((iteration%10000)==0 && iteration!=0 )
										 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
			}catch(NullPointerException e){

			}

			System.out.println("Done testing...");


	 }



}
