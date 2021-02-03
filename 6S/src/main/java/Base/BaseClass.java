package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	
	    public static	WebDriver driver;
		public static  Properties prop ;
		
			  @BeforeSuite
			  public void beforeSuite()throws InterruptedException, IOException  {
				  
				// Getting the automation project path
				  		String projectPath = System.getProperty("user.dir");
				 
				// Loading the properties file
				  		prop = new Properties();
				  		FileInputStream fis = new FileInputStream(projectPath+"/configurations/config.properties");
				  		prop.load(fis);
				  		//test
				  		
				// Initialize the driver
				  		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
				  		driver= new ChromeDriver();
				  		
				// Launching the browser and navigating to the application URL
				  		driver.get(prop.getProperty("URL"));
				  		
				// Manage windows property
					 driver.manage().window().maximize();
					 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
		
	}
			  @AfterSuite
			  public void afterSuite()
			  {
				  driver.quit();
			  }

}
