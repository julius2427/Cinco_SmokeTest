package mav.cintastesting;

import mav.contactform.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import commonfunctions.AbstractSteps;

/**
 * Unit test for simple App.
 */
public class AppTest extends AbstractSteps
{

	@Before
		public void openapp() throws Exception {
			//Open the page
			BasicConfigurator.configure();

		}
	
//	@Test
//		public void test1() throws Exception
//	    {
//			WebDriver driver = getDriver();
//			int initial_counter;
//
//			driver.navigate().to("http://localhost:4567/canvas_basic.html");
//			Canvas_Object.set_action_counter(driver);
//			initial_counter = Canvas_Object.get_action_counter();
//		
//			//Set X Y and Size Information
//			//Initial Count of Events
//			
//			
//			ArrayList<Canvas_Object> obj = new ArrayList<Canvas_Object>(); 
//			obj.add(new Canvas_Object());
//			obj.add(new Canvas_Object(200, 100, 40, "Grey"));
//			
//			Canvas_Object.set_canvas(driver, obj);
//			int addedevents = Canvas_Object.getAdded_events();
//			
//
//			int actual_counter = Canvas_Object.get_action_counter();
//			
//			
//			//Verifying the actual events are as expected
//			assertEquals(initial_counter + addedevents , actual_counter);
//			
//			
//			//Clears the options 
//			//Canvas_Object.clearoption(driver);
//	    }
//	@Test
//		public void api_testing() throws Exception {
//		RestTesting.basicpingtest();
//	}
//	
//	@Test
//		public void api_testingxml() throws Exception{
//		RestTesting.basicpingtestxml();
//	}
	@Test
		public void maincontacttest() throws Exception{
		WebDriver driver = getDriver();
		driver.navigate().to("https://www.cintas.com");
		Thread.sleep(5000);
		Contact.submitcontactform(driver);
		
		

		
	}
	@After
		public void closeapp() {
			driver.quit();
		}

}
