package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextvsgetAttribute {
	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/");
		
		WebElement email=driver.findElement(By.id("Email"));
		//email.clear();
		//email.sendKeys("vamsi123@gmail.com");
		//Thread.sleep(2_000);
		
		//To capture input text
		System.out.println("Value from getAttribute() method:"+email.getAttribute("value"));
		System.out.println("Value from getText() method:"+email.getText());
		
		//Login button
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		System.out.println("type:"+button.getAttribute("type"));
		System.out.println("class:"+button.getAttribute("class"));
		System.out.println(button.getText());
		
		driver.quit();
	}
}
