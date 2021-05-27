package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		//Location Method 1
		System.out.println("Location(x, y):"+element.getLocation());
		System.out.println("Location(x):"+element.getLocation().getX());
		System.out.println("Location(y):"+element.getLocation().getY());
		
		//Location Method 2
		System.out.println("Location(x):"+element.getRect().getX());
		System.out.println("Location(y):"+element.getRect().getY());
		
		//Size Method 1
		System.out.println("Size(Width, Height):"+element.getSize());
		System.out.println("Size(Width):"+element.getSize().getWidth());
		System.out.println("Size(Height):"+element.getSize().getHeight());
		
		//Size Method 2
		System.out.println("Size(Width, Height):"+element.getRect().getDimension());
		System.out.println("Size(Width):"+element.getRect().getDimension().getWidth());
		System.out.println("Size(Height):"+element.getRect().getDimension().getHeight());
		
		Wait.waitFor(driver, 2);
		driver.quit();
		
	}
}
