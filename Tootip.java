package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tootip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		//Identify the element by xpath
		WebElement element=driver.findElement(By.xpath("//input[@id='age']"));
		//retrieve the text using getAttribute() method
		String text=element.getAttribute("title");
		//Print the text which is nothing but a tool tip
		System.out.println("Tool Tip text:"+text);
		
		Wait.waitFor(driver, 2);
		driver.close();
		
	}

}
