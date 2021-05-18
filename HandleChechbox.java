package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleChechbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		
		//1) select specific text box
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//2) Select all check boxes
		/*List<WebElement> elements=driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		for(WebElement element:elements)
			element.click();*/
		
		//3) Select multiple checkboxes by choice
		//monday & sunday
		/*List<WebElement> elements=driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		for(WebElement element:elements) {
			String text=element.getAttribute("id");
			if(text.equals("monday") || text.equals("sunday"))
				element.click();
		}*/
		
		//4) Select last n checkboxes
		/*List<WebElement> elements=driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		System.out.println(elements.size());
		int start=elements.size()-3;
		for(int i=start;i<elements.size();i++) {
			elements.get(i).click();
		}
		*/
		
		//5) Select first n checkboxes
		List<WebElement> elements=driver.findElements(By.xpath("//div[@class='form-check']//input[@type='checkbox']"));
		System.out.println(elements.size());
		for(int i=0;i<elements.size();i++) {
			if(i<3)
				elements.get(i).click();
		}
		
		Thread.sleep(3_000);
		driver.quit();
		

	}

}
