package mypackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses?");
		driver.manage().window().maximize();
		
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Wait.waitFor(driver, 2);
		
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Wait.waitFor(driver, 2);
		
		actions.sendKeys(Keys.ESCAPE).perform();
		Wait.waitFor(driver, 2);
		
		actions.sendKeys(Keys.SPACE).perform();
		Wait.waitFor(driver, 2);
		
		driver.quit();

	}

}
