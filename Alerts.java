package mypackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Alert window with OK button
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//Thread.sleep(2_000);
		//driver.switchTo().alert().accept();
		
		//Alert window with OK and Cancel buttons
		//driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		//Thread.sleep(2_000);
		//driver.switchTo().alert().accept(); //close alert by using OK button
		//driver.switchTo().alert().dismiss(); //close alert by using Cancel button
		
		//Alert window with pop-ups
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println("Alert Text:"+alert.getText());
		Thread.sleep(2_000);
		alert.sendKeys("Welcome Vamsi Krishna Pallapolu");
		Thread.sleep(2_000);
		alert.accept();
		Thread.sleep(2_000);
		driver.quit();
	}
}
