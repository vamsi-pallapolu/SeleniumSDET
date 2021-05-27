package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
				
		//4.How to perform Mouse Hover Action ?
		WebElement mainMenu=driver.findElement(By.xpath(" //a[normalize-space()='Desktops']"));
		WebElement subMenu=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(mainMenu).moveToElement(subMenu).click().perform();
		
		Wait.waitFor(driver, 5);
		driver.quit();
	}
}
