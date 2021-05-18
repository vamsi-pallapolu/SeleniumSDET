package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {
	
	public static void selectOptionFromDropDown(WebElement dropdownElement, String value) {
		Select dropdown=new Select(dropdownElement);
		List<WebElement> allOptions=dropdown.getOptions();
		for(WebElement option:allOptions) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
		
	}
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement dropdown1=driver.findElement(By.name("NoOfEmployees"));
		selectOptionFromDropDown(dropdown1,"16 - 20");
		
		WebElement dropdown2=driver.findElement(By.name("Industry"));
		selectOptionFromDropDown(dropdown2,"Healthcare");
		
		WebElement dropdown3=driver.findElement(By.name("Country"));
		selectOptionFromDropDown(dropdown3,"Ghana");
		Thread.sleep(3_000);
		
		driver.quit();
		
	}
}
