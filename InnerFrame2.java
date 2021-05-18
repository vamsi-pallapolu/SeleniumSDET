package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrame2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
		
		//Switching to parent frame
		driver.switchTo().frame("iframeResult");
		//Switching to child frame
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
		String text=driver.findElement(By.xpath("/html/body/h1")).getText();
		System.out.println("InnerText:"+text);
		
		//Switching to parent frame
		driver.switchTo().parentFrame();
		String text2=driver.findElement(By.xpath("/html/body/p")).getText();
		System.out.println("ParentText:"+text2);
		
		driver.quit();
	}

}
