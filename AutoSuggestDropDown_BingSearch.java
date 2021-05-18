package mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_BingSearch {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		
		List<WebElement> elements=driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		System.out.println("Size:"+elements.size());
		
		for(WebElement element:elements) {
			if(element.getText().contains("download")) {
				element.click();
				break;
			}
		}
		driver.quit();
	}
}
