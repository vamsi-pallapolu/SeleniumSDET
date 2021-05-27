package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionVsActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement element=driver.findElement(By.xpath("//a[@title='Women']"));
	
		Actions actions=new Actions(driver);
		Action action=actions.moveToElement(element).build();
		action.perform();
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}
}
