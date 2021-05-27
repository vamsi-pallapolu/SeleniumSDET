package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDrop {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
				
		//3.How to perform Drag and Drop Action ?
		//source element
		WebElement source=driver.findElement(By.xpath("//div[@id='box6']"));
		//target element
		WebElement target=driver.findElement(By.xpath("//div[@id='box106']"));
		//Action class dragAndDrop
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}
}
