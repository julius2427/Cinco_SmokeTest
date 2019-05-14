package mav.cintastesting;


import org.apache.log4j.BasicConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import commonfunctions.AbstractSteps;
import commonfunctions.GetPropertyValues;
import location_finder.LocationList;
import mav.contactform.Contact;

/**
 * Unit test for simple App.
 */
public class AppTest extends AbstractSteps
{
	static String url;

	@BeforeClass
		public static void openapp() throws Exception {
			//Open the page
			BasicConfigurator.configure();
			getDriver();
			GetPropertyValues.getProperties();
			url = GetPropertyValues.getProperty("url");
			 //small update
		}
	
	 @Test
		public void desktopcontactform() throws Exception{ 
		
		WebDriver driver = getDriver();
		driver.manage().window().maximize(); //maximize window for Desktop Testing
		driver.navigate().to(url);
		Thread.sleep(3000);
		Contact.opendesktopcontactform();
		Contact.setdesktopcontactform();
		Contact.verifyelementid(driver, "ThankYouContainer");
		
	

		
	}
	
	@Test
	public void mobilecontactform() throws Exception{
		WebDriver driver = getDriver();
		Dimension d = new Dimension(400,800);
		driver.manage().window().setSize(d); //Set to mobile view
		driver.navigate().to(url);
		Contact.openmobilecontactform();
		Contact.setmobilecontactform();
		verifyelementid(driver, "mThankYouContainer");
		
	}
	
	@Test
	public void locationfinder() throws InterruptedException {
		WebDriver driver = getDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url + "/location-finder");
		LocationList.validsearchcontianer(driver);
		LocationList.searchvalid("45324"); //any valid zip code
		
		
		driver.navigate().to(url + "/location-finder");
		LocationList.validsearchcontianer(driver);
		LocationList.searchinvalid("Invalid Search"); //invalid zip
	
	}
	@Test
	public void uniformvisualizer() {
		
	}
	@Test
	public void bestrestroom() {
		
	}
	
	@AfterClass
		public static void closeapp() {
			driver.close();
		}

}
