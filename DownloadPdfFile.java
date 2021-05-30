package mypackage;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPdfFile {

	public static void main(String[] args) {
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		
		HashMap preferences=new HashMap();
		preferences.put("plugins.always_open_pdf_externally", true); //for pdf download
		preferences.put("download.default_directory", location);
		
		//Chrome
		/*ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs",preferences);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);*/
		
		
		
		//Edge
		/*WebDriverManager.edgedriver().setup();
		EdgeOptions options=new EdgeOptions();
		options.setExperimentalOption("prefs",preferences);
		WebDriver driver=new EdgeDriver(options);*/
		
		
		//Firefox
		FirefoxProfile profiles=new FirefoxProfile();
		profiles.setPreference("pdfjs.disabled", true);
		profiles.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profiles.setPreference("browser.download.folderList",2); // 0:Desktop,1:Downloads,2:CustomLocation
		profiles.setPreference("browser.download.dir",location);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profiles);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(options);
		
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();
		WebElement element=driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]"));
		element.click();
		
		Wait.waitFor(driver, 2);
		driver.close();
	}


}
