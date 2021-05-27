package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	static void waitFor(WebDriver driver, int time) {
		try {
			
			System.out.println("Waiting for "+time+" seconds");
			//ExplicitWait
			WebDriverWait wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("nothing")));
			
		}catch(Exception e) {
			System.out.println("Waited for "+time+" seconds");
		}
		
	}
	
}
