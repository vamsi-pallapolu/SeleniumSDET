package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamictableWithPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();
		//Login
		WebElement username=driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Sales > Orders
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		String pagetext=driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println("pageText:"+pagetext);
		
		//Extract the page number from page text
		String pageNumber=pagetext.substring(pagetext.indexOf('(')+1, pagetext.indexOf('P')-1);
		int pageno=Integer.valueOf(pageNumber);
		System.out.println("PageNumber:"+pageno);
		
		for(int i=1;i<=5;i++) {
			//click the active page number
			WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			System.out.println("Active page:"+active_page.getText());
			active_page.click();
			
			//Find the number of rows in active page
			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
			System.out.println("Rows in page "+active_page.getText()+":"+rows);
			
			for(int r=1;r<=rows;r++) {
				String OrderID=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[2]")).getText();
				String Customer=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[3]")).getText();
				String Status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[4]")).getText();
				if(Status.equals("Pending"))
					System.out.println(OrderID+"|"+Customer+"|"+Status);
			}
			
			//Click on next page
			driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+(i+1)+"']")).click();
		}
		
		Wait.waitFor(driver, 3);
		driver.quit();

	}

}
