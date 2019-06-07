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
	static String us_url;
	static String ca_url;
	static String ca_fr_url;
	static WebDriver driver;

	@BeforeClass
		//Getting Configuration properties Setting driver
		public static void openapp() throws Exception {
			//Open the page
			BasicConfigurator.configure();
			driver = getDriver();
			GetPropertyValues.getProperties();
			us_url = GetPropertyValues.getProperty("us_url");
			ca_url = GetPropertyValues.getProperty("ca_url");
			ca_fr_url = GetPropertyValues.getProperty("ca_fr_url");
			driver.manage().window().maximize();
			 //small update
		}
		//US Desktop Contact Form Submission
	  @Test
		public void usdesktopcontactform() throws Exception{ 
		
		//WebDriver driver = getDriver();
		driver.manage().window().maximize(); //maximize window for Desktop Testing
		driver.navigate().to(us_url);
		Thread.sleep(3000);
		Contact.opendesktopcontactform();
		Contact.setdesktopcontactform();	
	}
		//Canada Desktop Contact Form Submission
	  @Test
		public void cadesktopcontactform() throws Exception{ 
		
		//WebDriver driver = getDriver();
		driver.manage().window().maximize(); //maximize window for Desktop Testing
		driver.navigate().to(ca_url);
		Thread.sleep(3000);
		Contact.opendesktopcontactform();
		Contact.setdesktopcontactform();	
	}
		//Canada French Desktop Contact Form Submission
	  @Ignore @Test
		public void cafrdesktopcontactform() throws Exception{ 
		
		//WebDriver driver = getDriver();
		driver.manage().window().maximize(); //maximize window for Desktop Testing
		driver.navigate().to(ca_fr_url);
		Thread.sleep(3000);
		Contact.opendesktopcontactform();
		Contact.setdesktopcontactform();	
	}
	
	//US Mobile Contact Form Submission  
	  
	@Test
	public void usmobilecontactform() throws Exception{
		//WebDriver driver = getDriver();
		Dimension d = new Dimension(400,800);
		driver.manage().window().setSize(d); //Set to mobile view
		driver.navigate().to(us_url);
		Contact.openmobilecontactform();
		Contact.setmobilecontactform();
		
	}
	
	//Canada Mobile Contact Form Submission
	@Test
	public void camobilecontactform() throws Exception{
		//WebDriver driver = getDriver();
		Dimension d = new Dimension(400,800);
		driver.manage().window().setSize(d); //Set to mobile view
		driver.navigate().to(ca_url);
		Contact.openmobilecontactform();
		Contact.setmobilecontactform();
		
	}
	
	//Canada French Mobile Contact Form Submission
	@Test
	public void cafrmobilecontactform() throws Exception{
		//WebDriver driver = getDriver();
		Dimension d = new Dimension(400,800);
		driver.manage().window().setSize(d); //Set to mobile view
		driver.navigate().to(ca_fr_url);
		Contact.openmobilecontactform();
		Contact.setmobilecontactform();
		
	}
	//Location Finder Valid and Invalid Searches for US
	@Test
	public void uslocationfinder() throws InterruptedException {
		//WebDriver driver = getDriver();
		//driver.manage().window().maximize();
		driver.navigate().to(us_url + "/location-finder");
		LocationList.validsearchcontianer(driver);
		LocationList.searchvalid("45324"); //any valid zip code
		
		
		driver.navigate().to(us_url + "/location-finder");
		LocationList.validsearchcontianer(driver);
		LocationList.searchinvalid("Invalid Search"); //invalid zip
	
	}
	//Location Finder Valid and Invalid Searches for US
	@Test
	public void calocationfinder() throws InterruptedException {
		//WebDriver driver = getDriver();
		//driver.manage().window().maximize();
		driver.navigate().to(ca_url + "/location-finder");
		LocationList.validsearchcontianer(driver);
		LocationList.searchvalid("45324"); //any valid zip code
		
		
		driver.navigate().to(ca_url + "/location-finder");
		LocationList.validsearchcontianer(driver);
		LocationList.searchinvalid("Invalid Search"); //invalid zip
	
	}
	
	@Test
	public void usuniformvisualizercontactform() throws InterruptedException {
		driver.navigate().to(us_url + "/uniform-work-apparel/custom-workwear-apparel/Contact");
		Contact.uvcontactform();
	}
	@Test
	public void cauniformvisualizercontactform() throws InterruptedException {
		driver.navigate().to(ca_url + "/uniform-work-apparel/custom-workwear-apparel/Contact");
		Contact.uvcontactform();
	}
	@AfterClass
		public static void closeapp() {
			driver.close();
		}

}
