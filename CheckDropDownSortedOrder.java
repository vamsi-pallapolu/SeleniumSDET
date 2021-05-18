package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSortedOrder {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		driver.manage().window().maximize();
		
		WebElement element= driver.findElement(By.name("category_id"));
		Select dropdown=new Select(element);
		List<WebElement> options=dropdown.getOptions();
		
		ArrayList<String> orginallist=new ArrayList<String>();
		ArrayList<String> templist=new ArrayList<String>();
		
		for(WebElement option:options) {
			String text=option.getText();
			orginallist.add(text);
			templist.add(text);
		}
		System.out.println("Orginal list:"+orginallist);
		System.out.println("Temporary list:"+templist);
		Collections.sort(templist);
		System.out.println("Orginal list:"+orginallist);
		System.out.println("Temporary list after sorting:"+templist);
		
		if(templist.equals(orginallist))
			System.out.println("Dropdown sorted");
		else
			System.out.println("Dropdown unsorted");
		driver.quit();
	}
}
