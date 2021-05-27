package mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on date
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		String year="2021";
		String month="July";
		String day="10";
		
		while(true) {
			String date=driver.findElement(By.className("monthTitle")).getText();
			String arr[]=date.split(" ");
			String mth=arr[0];
			String yr=arr[1];
			if(mth.equals(month) && yr.equals(year))
				break;
			else {
				//Click on next button
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
			}
			
		}
		
		//Selecting date
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		for(WebElement date:dates) {
			if(date.getText().equals(day)) {
				date.click();
				break;
			}
		}
		
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}

}
