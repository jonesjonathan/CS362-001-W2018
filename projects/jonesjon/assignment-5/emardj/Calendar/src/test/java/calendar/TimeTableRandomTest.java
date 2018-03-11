package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;

import java.util.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
		 private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */

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

					  LinkedList<Appt> appts = new LinkedList<Appt>();
						int startHour=ValuesGenerator.getRandomIntBetween(random, -5, 30);
	 					int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 70);
	 					int startDay=ValuesGenerator.getRandomIntBetween(random, -5, 35);
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
						GregorianCalendar gCal2 = new GregorianCalendar(year + ValuesGenerator.RandInt(random), month, day + 1); //One day ahead of the previous day
						TimeTable tt = new TimeTable();

						appts.add(appt);
						appts.add(appt);
						appts.add(appt);
						appts.add(appt);

	 					for (int i = 0; i < 3; i++) {
							int startHour2=ValuesGenerator.getRandomIntBetween(random, -5, 30);
		 					int startMinute2=ValuesGenerator.getRandomIntBetween(random, -10, 70);
		 					int startDay2=ValuesGenerator.getRandomIntBetween(random, -5, 35);
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
							appts.add(appt2);

							tt.getApptRange(appts, gCal, gCal2);

	 					}
						for(int i=0;i<appts.size();i++){
                Appt tempAppt=appts.get(i);
                tt.deleteAppt(appts, tempAppt);
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
