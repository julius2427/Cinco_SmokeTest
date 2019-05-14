package mav.contactform;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	

	private static String inputtime() {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		return strDate;
	}
	public static void opendesktopcontactform() throws InterruptedException {
		click(ID, "HeaderContactUs");
	}
	public static void openmobilecontactform() throws InterruptedException {
		click(CLASS, "contact-us-mobile");
	}
	public static void setdesktopcontactform() throws InterruptedException {
		textBox(ID, "InputFirstName", firstname);
		textBox(ID, "InputLastName", lastname);
		textBox(ID, "InputCompany", company_name);
		textBox(ID, "InputAddress", company_address);
		textBox(ID, "InputEmail", email);
		textBox(ID, "InputPhone", phone);
		textBox(ID, "InputPostalCode", postalcode);
		textBox(ID, "InputComments", inputtime());
		click(ID, "ContactInterestOptions_0");
		click(ID, "InputSubmitButton");
		WebElement element = driver.findElement(By.id("modal-deny"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		click(ID, "modal-deny"); 
	}
	public static void setmobilecontactform() throws InterruptedException {
		textBox(ID, "mInputFirstName", firstname);
		textBox(ID, "mInputLastName", lastname);
		textBox(ID, "mInputCompany", company_name);
		textBox(ID, "mInputAddress", company_address);
		textBox(ID, "mInputEmail", email);
		textBox(ID, "mInputPhone", phone);
		textBox(ID, "mInputPostalCode", postalcode);
		textBox(ID, "mInputComments", inputtime());
		click(ID, "mContactInterestOptions_0");
		click(ID, "mInputSubmitButton");
		WebElement element = driver.findElement(By.id("modal-deny"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		click(ID, "modal-deny"); 
	}
}
