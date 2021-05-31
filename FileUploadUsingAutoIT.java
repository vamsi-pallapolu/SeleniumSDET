package mypackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUsingAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); // for page load
		d.get("https://opensource-demo.orangehrmlive.com"); // Testing webpage
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // for Implicit wait

		WebElement uname = d.findElement(By.id("txtUsername")); // Username.........ID
		uname.sendKeys("Admin");

		WebElement pwd = d.findElement(By.name("txtPassword")); // Password.........NAME
		pwd.sendKeys("admin123");

		WebElement loginb = d.findElement(By.xpath("//input[@id='btnLogin']"));
		loginb.click(); // Loginbutton......XPATH

		WebElement pim = d.findElement(By.id("menu_pim_viewPimModule"));
		pim.click(); // Admin tab-PIM

		WebElement config = d.findElement(By.id("menu_pim_Configuration"));
		config.click(); // Configuration tab

		WebElement data_imp = d.findElement(By.partialLinkText("Data "));
		data_imp.click(); // Data Import tab.....PARTIALLINKT

		// UPLOADING FILE USING AutoIT....

		WebElement browser = d.findElement(By.xpath("//input[@id='pimCsvImport_csvFile']")); // Browse button
		
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].click()", browser);
		System.out.println("1");

		Thread.sleep(3_000);
		Runtime.getRuntime().exec("C:\\Users\\vamsi\\OneDrive\\Desktop\\Java-WS\\SeleniumInterviewQuestions\\FileUpload.exe");
		System.out.println("2");
		Thread.sleep(3000);

		WebElement upload = d.findElement(By.id("btnSave")); // Upload button
		upload.click();
		System.out.println("3");

		System.out.println("File Uploaded Successfully"); // Confirmation message
	}

}
