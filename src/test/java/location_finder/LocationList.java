package location_finder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonfunctions.AbstractSteps;

public class LocationList extends AbstractSteps{
	static String zipcontainerclass = "lf-ZipSearchContainer";
	static String locationfieldid = "locationFinderFindALocationInputSearch";
	static String noResultsclass = "lf-lb-noResults";
	static String validresultclass = "lf-lb-lc-location";
	String distance;
	List<String> location;
	public static void validsearchcontianer(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(zipcontainerclass)));
	}
	public static void searchvalid(String validzip) throws InterruptedException {
		WebElement locationbox = driver.findElement(By.id(locationfieldid));
		textBox(ID, locationfieldid, validzip);
		locationbox.sendKeys(Keys.ENTER);
		verifyelementclass(driver, validresultclass);
		
	}
	
	public static void searchinvalid(String invalidzip) throws InterruptedException {
		WebElement locationbox = driver.findElement(By.id(locationfieldid));
		textBox(ID, locationfieldid, invalidzip);
		locationbox.sendKeys(Keys.ENTER);
		verifyelementclass(driver, noResultsclass);
		
	}

} 
