package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement dropdownElement=driver.findElement(By.id("input-country"));
		Select dropdown=new Select(dropdownElement);
		/*dropdown.selectByVisibleText("Denmark");
		Thread.sleep(3_000);
		dropdown.selectByValue("10"); //Argentina
		Thread.sleep(3_000);	
		dropdown.selectByIndex(13); //Australia
		Thread.sleep(3_000);	*/
		
		//Another way to select the dropdown element
		List<WebElement> allOptions=dropdown.getOptions();
		for(WebElement option:allOptions) {
			if(option.getText().equals("Cuba")) {
				option.click();
				break;
			}
		}
		Thread.sleep(3_000);
		driver.quit();
	}
}
