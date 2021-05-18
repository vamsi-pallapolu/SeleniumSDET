package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		//Find the no of rows in table
		By locator;
		locator=By.xpath("//table[@class='data-list']/tbody/tr");
		List<WebElement> rows=driver.findElements(locator);
		System.out.println("Rows size:"+rows.size());
		
		locator=By.xpath("//table[@class='data-list']/tbody/tr[1]/td");
		List<WebElement> columns=driver.findElements(locator);
		System.out.println("Rows size:"+columns.size());
		
		Wait.waitFor(driver, 5);
		driver.quit();
	}
}
