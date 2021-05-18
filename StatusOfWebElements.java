package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		//radio buttons
		WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		//isDisplayed() isSelected()
		System.out.println(male.isDisplayed()); //true
		System.out.println(female.isDisplayed()); //true
		
		System.out.println(male.isSelected()); //false
		System.out.println(female.isSelected()); //false
		Thread.sleep(2_000);
		
		male.click();
		System.out.println(male.isSelected()); //true
		System.out.println(female.isSelected()); //false
		Thread.sleep(2_000);
		
		female.click();
		System.out.println(male.isSelected()); //false
		System.out.println(female.isSelected()); //true
		Thread.sleep(2_000);
		
		driver.close();
	}

}
