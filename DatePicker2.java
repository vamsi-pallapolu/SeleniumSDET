package mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Click on date of birth
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		//Select the month
		Select month_dropdown=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_dropdown.selectByVisibleText("Oct");
		//Select the year
		Select year_dropdown=new Select(driver.findElement(By.xpath("//select[contains(@class,'ui-datepicker-year')]")));
		year_dropdown.selectByVisibleText("1990");
		//Select the day
		String day="10";
		List<WebElement> days=driver.findElements(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]/tbody/tr/td"));
		for(WebElement d:days) {
			if(d.getText().equals(day)) {
				d.click();
				break;
			}
		}
		Wait.waitFor(driver, 2);
		driver.quit();
	}
}
