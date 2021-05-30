package mypackage;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//How to capture the cookies from browser ?
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Size:"+cookies.size());
		
		//How to print cookies from browser ? 
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+":"+cookie.getValue());
		}
		
		//How to add cookie to the browser
		Cookie cookie=new Cookie("MyCookie","123");
		driver.manage().addCookie(cookie);
		cookies=driver.manage().getCookies();
		System.out.println("Size of cookies after adding:"+cookies.size());
		
		//How to delete specific cookie from the browser
		//driver.manage().deleteCookie(cookie);
		driver.manage().deleteCookieNamed("MyCookie");
		
		cookies=driver.manage().getCookies();
		System.out.println("Size of cookies after deletion:"+cookies.size());
		
		//How to delete all cookies ?
		driver.manage().deleteAllCookies();
		cookies=driver.manage().getCookies();
		System.out.println("Size After deleting all cookies:"+cookies.size());
		
		Wait.waitFor(driver, 2);
		driver.close();
	}

}
