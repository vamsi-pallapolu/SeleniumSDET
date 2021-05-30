package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Databasetesting {
	public static void main(String[] args) throws SQLException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//driver.get("");
		
		
		String name="krishna";
		//DataBase  Connectivity
		Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.0.109:80/demo","root","");
		Statement st=conn.createStatement();
		ResultSet rset=st.executeQuery("select username from users");
		
		boolean status=false;
		while(rset.next()) {
			if(rset.getString("username").contains(name))
				System.out.println("Record found in the table | Test passed");
				status=true;
				break;
		}
		if(status=false)
			System.out.println("Record not found | Test failed");

		//Wait.waitFor(driver, 2);
		//driver.close();
	}
}
