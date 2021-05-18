package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIFrame1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		
		//clicking on button
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		
		//Switch to Parent iframe
		WebElement parentElement=driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(parentElement);
		//Switch to child iframe
		WebElement childElement=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(childElement);
		
		//Send value to the text box
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Vamsi Krishna Pallapolu");
		
		Thread.sleep(3_000);
		driver.quit();
	}
}
