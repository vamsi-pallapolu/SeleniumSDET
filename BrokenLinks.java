package mypackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//Find all the links in the Web page
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("links size:"+links.size());
		int brokenLinksCount=0;
		
		try {
			for(WebElement link:links) {
				//retrive href from each anchor element
				String href=link.getAttribute("href");
				if(href == null || href.isEmpty())
					continue;
				URL url=new URL(href);
				HttpURLConnection http=(HttpURLConnection)url.openConnection();
				http.connect();
				if(http.getResponseCode()>=400) {
					System.out.println(http.getResponseCode()+":"+href+" is BrokenLink");
					brokenLinksCount++;
				}
				else
					System.out.println(http.getResponseCode()+":"+href+" is valid Link");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println("BrokenLinksCount:"+brokenLinksCount);
		Thread.sleep(3_000);
		driver.quit();
	}

}
