package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		/*
		//findElement() --> Always returns Single WebElement
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchbox.sendKeys("Vamsi");
		Thread.sleep(2_000);
		
		//Even though it matches multiple elements, it returns only first element
		WebElement element=driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(element.getText());
		
		//Throws NoSuchElementException if element is not found
		WebElement searchButton=driver.findElement(By.xpath("//button[@class='button-1 search-box']"));
		*/
		
		/*List<WebElement> links=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(links.size());
		
		for(WebElement element:links)
			System.out.println(element.getText());
		
		//We can also get single WebELement using findElements() method
		List<WebElement> logo=driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println(logo.size());
		*/
		
		//if it doesn't match with any element/elements, it return 0 instead of throwing Exception
		List<WebElement> elements=driver.findElements(By.xpath("//img[@id='none']"));
		System.out.println(elements.size());
		
		driver.close();
	}

}
