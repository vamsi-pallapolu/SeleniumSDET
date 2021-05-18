package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static void main(String[] args) {
		
		
		//To open chrome browser
		/*System.setProperty("webdriver.chrome.driver","D:\\Selenium\\WebDrivers\\chromedriver.exe");
		WebDriver chromeDriver=new ChromeDriver(); //ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://frontend.nopcommerce.com/");
		//chromeDriver.close();
		//chromeDriver.quit();*/
		
		// To open firfox browser
		/*System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\WebDrivers\\geckodriver.exe");
		WebDriver firefoxDriver=new FirefoxDriver(); //FirefoxDriver firefoxDriver=new FirefoxDriver();
		firefoxDriver.get("https://frontend.nopcommerce.com/");*/
		
		/*System.setProperty("webdriver.edge.driver", "D:\\Selenium\\WebDrivers\\msedgedriver.exe");
		WebDriver ed=new EdgeDriver(); //EdgeDriver ed=new EdgeDriver();
		ed.get("https://frontend.nopcommerce.com/");
		ed.close();*/
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://frontend.nopcommerce.com/");
		System.out.println("Title of the page:"+driver.getTitle());
		System.out.println("Current URL of the page:"+driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.close();
		
		
	}
}
