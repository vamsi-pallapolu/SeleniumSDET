package mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_GoogleSearch {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("java tutorial");
		Thread.sleep(3_000);
		
		List<WebElement> elements=driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']/div[1]/span"));
		System.out.println("Size:"+elements.size());
		
		for(WebElement element:elements) {
			if(element.getText().contains("w3schools")) {
				element.click();
				break;
			}
		}
		
		driver.quit();

	}

}
