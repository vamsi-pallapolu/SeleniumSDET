package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionMultipleKeys {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		//Identify the textArea's
		WebElement textarea1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement textarea2=driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		
		//Send the data
		textarea1.sendKeys("Vamsi Krishna Pallapolu");
		Actions action=new Actions(driver);
		
		//Select the data CTRL + A
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.perform();
		
		//Copy the data
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.perform();
		
		//Switch to 2nd textArea by using tab button
		action.sendKeys(Keys.TAB);
		action.perform();
		
		//Paste the data
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.perform();
		
		//Compare the text
		if(textarea1.getAttribute("value").equals(textarea2.getAttribute("value")))
			System.out.println("Text Copied");
		else
			System.out.println("Text not copied");
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}

}
