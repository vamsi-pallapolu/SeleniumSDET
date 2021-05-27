package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropImages {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
				
		//Drag and Drop Action using images
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		//Locate images
		WebElement image1=driver.findElement(By.xpath("//li[1]"));
		WebElement image2=driver.findElement(By.xpath("//li[2]"));
		WebElement target=driver.findElement(By.id("trash"));
		//Action class dragAndDrop
		Actions action=new Actions(driver);
		action.dragAndDrop(image1, target).perform();
		action.dragAndDrop(image2, target).perform();
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}
}
