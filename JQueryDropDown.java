package mypackage;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDown {
	
	static void selectChoiceValues(WebDriver driver, String ...values){
		//Identify all the dropdown elements
		List<WebElement> elements=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		if(!(values[0]=="all")) {
			for(WebElement element:elements) {
				String text=element.getText();
				for(String value:values) {
					if(text.equals(value)) {
						element.click();
						break;
					}
				}			
			}
		}else {
			try {
				for(WebElement element:elements) {
					element.click();		
				}
			}catch(Exception e) {
				
			}
		}
		
	}

	public static void main(String[] args)  throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		//Click the dropdown
		driver.findElement(By.id("justAnInputBox")).click();
		//selectChoiceValues(driver, "choice 1");
		//selectChoiceValues(driver, "choice 1", "choice 2 1", "choice 2 2");
		selectChoiceValues(driver, "all");
		
		System.out.println("Sleeping for 2 seconds");
		Thread.sleep(2_000);
		driver.quit();
	}

}
