package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {
	
	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//linkText()
		//driver.findElement(By.linkText("Best Sellers")).click();
		//partialLinkText()
		//driver.findElement(By.partialLinkText("Sellers")).click();
		
		//How to capture all links
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Number of links:"+links.size());
		
		/*for(int i=0;i<50;i++) {
			System.out.println("LinkText:"+links.get(i).getText());
			System.out.println("Links:"+links.get(i).getAttribute("href"));
			
		}*/
		
		//Capturing links through for-each loop
		int i=1;
		for(WebElement link:links) {
			if(i > 10)
				break;
			System.out.println("LinkText:"+link.getText());
			System.out.println("Links:"+link.getAttribute("href"));
			i++;
		}
		
		Thread.sleep(3_000);
		driver.close();
	}

}
