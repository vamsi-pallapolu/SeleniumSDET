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

public class CaptureScreenShots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Full page screenshot
		/*TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\vamsi\\OneDrive\\Desktop\\Java-WS\\SeleniumInterviewQuestions\\screenshots\\homepage.png";
		File target=new File(path);
		FileUtils.copyFile(src, target);*/
		
		//Screenshot of portion/section of page [Introduced in Selenium 4]
		/*WebElement section=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src2=section.getScreenshotAs(OutputType.FILE);
		File target2=new File(".\\screenshots\\section.png");
		FileUtils.copyFile(src2, target2);*/
		
		WebElement element=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src2=element.getScreenshotAs(OutputType.FILE);
		File target2=new File(".\\screenshots\\element.png");
		FileUtils.copyFile(src2, target2);
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}

}
