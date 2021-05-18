package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		driver.manage().window().maximize();
		
		WebElement search=driver.findElement(By.id("autocomplete"));
		search.clear();
		search.sendKeys("ind");
		String  text;
		do {
			search.sendKeys(Keys.ARROW_DOWN);
			text=search.getAttribute("value");
			
			if(text.equals("Indonesia")) {
				search.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(1_000);
		}while(!text.isEmpty());
		
		Thread.sleep(5_000);
		driver.quit();
	}

}
