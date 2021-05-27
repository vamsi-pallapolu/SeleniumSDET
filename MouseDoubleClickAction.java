package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
				
		//2.How to perform Double click Action
		//Switch to iframe
		driver.switchTo().frame("iframeResult");
		//Retrieve the text from first text box
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Vamsi Krishna Pallapolu");
		//Click on copy text button
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		//Pass copy button xpath to Action class to perform double click operation 
		Actions action=new Actions(driver);
		action.doubleClick(button).perform();
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}

}
