package mypackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		
		//using sendKeys() method
		//driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\vamsi\\Downloads\\Likhith_resume.pdf");
		
		//Using Robot Class
		WebElement element=driver.findElement(By.id("file-upload"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
		//Copy
		//CTRL+V
		//ENTER
		Robot robot=new Robot();
		robot.delay(2_000);
		StringSelection ss=new StringSelection("C:\\Users\\vamsi\\Downloads\\Likhith_resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1_000);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1_000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Wait.waitFor(driver, 2);
		driver.close();
	}

}
