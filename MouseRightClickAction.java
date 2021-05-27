package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClickAction {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		//1.How to perform Right Click Action ?
		//find the button
		WebElement element=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
		
		//2.How to perform Double click Action
		
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}

}
