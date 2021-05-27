package mypackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider-range']/span"));
		System.out.println(slider.getLocation());//59, 250
		System.out.println("Height & Width:"+slider.getSize()); //21, 21
		
		Actions action=new Actions(driver);
		action.dragAndDropBy(slider, 100, 0).perform();
		
		WebElement maxSlider=driver.findElement(By.xpath("//span[2]"));
		action.dragAndDropBy(maxSlider, -100, 0).perform();
		
		Wait.waitFor(driver, 2);
		driver.quit();
	}
}
