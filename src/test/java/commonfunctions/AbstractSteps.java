package commonfunctions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractSteps {
	protected static WebDriver driver;
	private String environment;
	protected static final int ID = 1;
    protected static final int CLASS = 2;
    protected static final int LINKTEXT = 3;
    protected static final int XPATH = 4;
    protected static final int CSS = 5;
    protected static final int TAGNAME = 6;

    protected static final int VISIBLETEXT = 1;
    protected static final int VALUE = 2;
    protected static final int INDEX = 3;
	static String drivername;
	static String driverlocation;
	protected static WebDriver getDriver() {
		if(driver == null) {
			System.setProperty("webdriver.gecko.driver", "/Users/julius/Desktop/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
		}
		return driver;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getEnvironment() {
		return environment;
	}

	private static WebElement chooseElement(int byStrategy, String locatorValue) {
        By by = null;

        switch (byStrategy) {
        case ID:
            by = By.id(locatorValue);
            break;
        case CLASS:
            by = By.className(locatorValue);
            break;
        case LINKTEXT:
            by = By.linkText(locatorValue);
            break;
        case XPATH:
            by = By.xpath(locatorValue);
            break;
        case CSS:
            by = By.cssSelector(locatorValue);
            break;
        case TAGNAME:
            by = By.tagName(locatorValue);
            break;
        }
        return driver.findElement(by);
    }
    public static Actions getAction() {
        Actions action = new Actions(driver);
        return action;
    }

    public static void mouseOver(int byStrategy, String locatorValue) throws InterruptedException {
        WebElement mO = chooseElement(byStrategy, locatorValue);
        getAction().moveToElement(mO).perform();
    }

    public static void textBox(int byStrategy, String locatorValue, String text) throws InterruptedException {
        chooseElement(byStrategy, locatorValue).sendKeys(text);
        getAction().sendKeys(Keys.ESCAPE);
    }

    public static void click(int byStrategy, String locatorValue) throws InterruptedException {
        chooseElement(byStrategy, locatorValue).click();
    }

    public static String getTxt(int byStrategy, String locatorValue) throws InterruptedException {
        String returnText = chooseElement(byStrategy, locatorValue).getText();
        return returnText;
    }

    public static void dropDown(int byStrategy, String locatorValue, int selectStrategy, Object strategyValue)
            throws InterruptedException {
        try {
            WebElement webElement = chooseElement(byStrategy, locatorValue);

            Select select = new Select(webElement);

            switch (selectStrategy) {
            case VISIBLETEXT:
                System.out.println("case 1");
                select.selectByVisibleText((String) strategyValue);
                break;
            case VALUE:
                System.out.println("case 2");
                select.selectByValue((String) strategyValue);
                break;
            case INDEX:
                System.out.println("case 3");
                select.selectByIndex(((Integer) strategyValue).intValue());
                break;
            }
        } catch (NoSuchElementException e) {
        	System.out.println("No element found. Add better error handling here");
        }
       
    }
	public static void verifyelementid(WebDriver driver, String idelement) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idelement)));
		assertTrue(driver.findElement(By.id(idelement)).isDisplayed());
	}
	public static void verifyelementclass(WebDriver driver, String classelement) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classelement)));
		assertTrue(driver.findElement(By.className(classelement)).isDisplayed());
	}
}
