package mypackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	
		//Scroll to particular element
		WebElement element=driver.findElement(By.xpath("//a[text()='nopCommerce new release!']"));
		JavaScriptUtil.scrollToElement(driver, element);
		element.click();
		
		
		//flash
		//WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//JavaScriptUtil.flash(driver, logo);
		
		/*
		//Draw border and take screenshot
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.drawBorder(driver, logo);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, target);
		
		//Getting title of the page
		String title=JavaScriptUtil.getTitle(driver);
		System.out.println("Title:"+title);
		
		//click action
		WebElement reglink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		JavaScriptUtil.click(driver, reglink);
		*/
		
		//JavaScriptUtil.alert(driver, "Vamsi Krishna Pallapolu");
		//JavaScriptUtil.refresh(driver);
		
		//JavaScriptUtil.scrollPageDown(driver);
		//Wait.waitFor(driver, 2);
		//JavaScriptUtil.scrollPageUp(driver);
		
		//JavaScriptUtil.zoom(driver);
		
		Wait.waitFor(driver, 3);
		driver.close();
		
	}

}
