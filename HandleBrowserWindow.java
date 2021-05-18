package mypackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//getWindowHandle() method
		//String windowid=driver.getWindowHandle(); //returns the window id of the browser
		//System.out.println(windowid);
		
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		
		//getWindowHandles() method - returns multiple window id's from the browser
		
		//First Mmethod - iterator()
		/*Set<String> windowsids=driver.getWindowHandles();
		Iterator<String> it=windowsids.iterator();
		String parentWindowId=it.next();
		String childWindowId=it.next();
		
		System.out.println(parentWindowId);
		System.out.println(childWindowId);*/
		
		//Second Method - using List/ArrayList
		Set<String> windowsids=driver.getWindowHandles();
		List<String> windowIds=new ArrayList<String>(windowsids);
		System.out.println(windowIds.get(0));
		System.out.println(windowIds.get(1));
		
		String parentId=windowIds.get(0);
		String childId=windowIds.get(1);
		
		/*
		//Switching to parent window
		driver.switchTo().window(parentId);
		System.out.println("Title of parent Url:"+driver.getTitle());
		Thread.sleep(1_000);
		
		//Switching to child window
		driver.switchTo().window(childId);
		System.out.println("Title of child Url:"+driver.getTitle());*/
		
		for(String window:windowIds) {
			String text=driver.switchTo().window(window).getTitle();
			System.out.println("Title:"+text);
			if(text.equals("HR Management System | HR Management Software | OrangeHRM"))
				driver.close();
		}
		
		//driver.close(); // close() method closes browser window which it is pointing
		Thread.sleep(3_000);
		
		driver.quit(); //close all the browser windows
		
	}

}
