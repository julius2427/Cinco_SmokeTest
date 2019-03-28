package mav.contactform;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonfunctions.AbstractSteps;


public class Contact extends AbstractSteps{
	static String firstname = "TestFirst";
	static String lastname = "TestLast";
	static String company_name = "TestCompany";
	static String company_address = "Test Address";
	static String postalcode = "45324";
	static String phone = "1234567890";
	static String email = "test@test.com";
	
	
	public static void submitcontactform(WebDriver driver) throws InterruptedException {
		//maincontactform submission
		click(ID, "HeaderContactUs");
		textBox(ID, "InputFirstName", firstname);
		textBox(ID, "InputLastName", lastname);
		textBox(ID, "InputCompany", company_name);
		textBox(ID, "InputAddress", company_address);
		textBox(ID, "InputEmail", email);
		textBox(ID, "InputPhone", phone);
		textBox(ID, "InputPostalCode", postalcode);
		click(ID, "ContactInterestOptions_0");
		click(ID, "InputSubmitButton");
		
		//Need to wait for elemnt to be visible
		WebElement element = driver.findElement(By.id("modal-deny"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		click(ID, "modal-deny"); //Actually Submits Original Naming Sucks
		
		
		verifysubmit(driver);
	}
	public static void verifysubmit(WebDriver driver) {
		assertTrue(driver.findElement(By.id("ThankYouContainer")).isDisplayed());
	}
	
}
