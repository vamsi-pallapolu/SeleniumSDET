package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		//Find the no of rows in table
		By locator;
		locator=By.xpath("//table[@class='data-list']/tbody/tr");
		List<WebElement> rows=driver.findElements(locator);
		System.out.println("Rows size:"+rows.size());
		
		locator=By.xpath("//table[@class='data-list']/thead/tr/th");
		List<WebElement> columns=driver.findElements(locator);
		System.out.println("Rows size:"+columns.size());
		
		String value=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr[2]/td[1]")).getText();
		System.out.println("Value:"+value);
		
		/*for(int r=1;r<=rows.size();r++) {
			for(int c=1;c<=columns.size();c++) {
				String data=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(data+" ");
			}
			System.out.println();
		}*/
		
		for(int r=1;r<=rows.size();r++) {
			String data=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[1]")).getText();
			if(data.equals("Java")) {
				String versionno=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[2]")).getText();
				String releasedate=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[3]")).getText();
				System.out.println("Version No:"+versionno);
				System.out.println("Release date:"+releasedate);
			}
		}
		
		
		Wait.waitFor(driver, 5);
		driver.quit();
	}
}
