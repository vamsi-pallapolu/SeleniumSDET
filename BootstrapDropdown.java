package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {
	
	//Code to handle bootstrap dropdowns
	static void  selectOptionFromDropDown(List<WebElement> elements, String value) {
		for(WebElement element:elements) {
			if(element.getText().equals(value)) {
				element.click();
				break;
			}
		}
		
	}
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		
		//Clicking product type dropdown
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		//Identifying the dropdown elements
		List<WebElement> productTypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		selectOptionFromDropDown(productTypes, "Accounts");
		Thread.sleep(5_000);
		
		//Clicking products dropdown
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		//Identifying the dropdown elements
		List<WebElement> products=driver.findElements(By.xpath(" //ul[@class='dropdown2 dropdown-menu']/li"));
		selectOptionFromDropDown(products, "Savings Accounts");
		Thread.sleep(5_000);
		
		driver.quit();
		
	}
}
