package mypackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentExample2 {
	
static WebElement fluentWait(WebDriver driver,final By targetLocator, int maxTime) {
		// Waiting 30 seconds for an element to be present on the page, checking for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(maxTime))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);	
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			  public WebElement apply(WebDriver driver) {
				    return driver.findElement(targetLocator);
				  }
		});
		
		return element;
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		By targetLocator=By.xpath("//h3[text()='Selenium WebDriver']");
		WebElement element=fluentWait(driver, targetLocator,40);
		element.click();
		
		driver.quit();
	}
}
