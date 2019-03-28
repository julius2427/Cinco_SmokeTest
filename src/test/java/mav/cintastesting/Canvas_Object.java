package mav.cintastesting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Canvas_Object {
	public int x_cord = 0;
	public int y_cord = 0;
	public int size = 0;
	public String color;
	private static int count;
	private static int added_events = 0;
	
	public Canvas_Object(){
		
		x_cord = 200;
		y_cord = 200;
		size = 40;
		color = "Black";
	}
	public Canvas_Object(int x_cord, int y_cord, int size, String color) {
		this.x_cord = x_cord;
		this.y_cord = y_cord;
		this.size = size;
		this.color = color;
	}
	
	public static void set_canvas(WebDriver driver, ArrayList<Canvas_Object> obj) {
		//Clearing and Setting Values
		for(int i = 0; i<obj.size();i++) {
			driver.findElement(By.id("xnum")).clear();
			driver.findElement(By.id("xnum")).sendKeys(Integer.toString(obj.get(i).x_cord));
			
			driver.findElement(By.id("ynum")).clear();
			driver.findElement(By.id("ynum")).sendKeys(Integer.toString(obj.get(i).y_cord));
			
			driver.findElement(By.id("shapesize")).clear();
			driver.findElement(By.id("shapesize")).sendKeys(Integer.toString(obj.get(i).size));
			
			//DropDown
			WebElement colourdropdown = driver.findElement(By.id("colourselect"));
			Select dropdown = new Select(colourdropdown);
			dropdown.selectByVisibleText(obj.get(i).color);
			
			show(driver);
			
			
		}
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void clearoption(WebDriver driver) {
		driver.findElement(By.name("clearbutton")).click();
		setAdded_events();
		set_action_counter(driver);
		
	}
	
	public static void show(WebDriver driver) {
		driver.findElement(By.name("gobutton")).click();
		setAdded_events();
		set_action_counter(driver);
	}
	public void set_color(WebDriver driver) {
	}
	
	public static void set_action_counter(WebDriver driver) {
		WebElement actioncounter = driver.findElement(By.id("commandlist"));
		List<WebElement> links = actioncounter.findElements(By.tagName("li"));
		Canvas_Object.count = links.size();
		
	}
	public static int get_action_counter() {
		return count;
	}
	public static int getAdded_events() {
		return added_events;
	}
	public static void setAdded_events() {
		Canvas_Object.added_events++;
	}

}
