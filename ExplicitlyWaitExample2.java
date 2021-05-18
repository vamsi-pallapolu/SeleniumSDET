package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitExample2 {
	
	static WebElement waitForElementPresent(WebDriver driver, By locator, int time) {
		//This timeout is applicable for specific element
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		try {
			By locator=By.xpath("//h3[text()='Selenium WebDriver']");
			WebElement element=waitForElementPresent(driver, locator, 10);
			element.click();
			
		}catch(TimeoutException e) {
			System.out.println(e);
		}
		
		Thread.sleep(2_000);
		driver.quit();
	}

}
