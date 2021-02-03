package TestFunctions;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.LoginPage;

public class LoginTest extends BaseClass {
	
	public static  WebDriverWait w2;
	
	
  @Test(priority=2)
  public void validlogin() throws InterruptedException {
	  LoginPage obj= new LoginPage(driver);
	  obj.UsernameField().clear();
	  obj.UsernameField().sendKeys(prop.getProperty("username"));
	  obj.PasswordField().clear();
	  obj.PasswordField().sendKeys(prop.getProperty("password"));
	  obj.loginButton().click();
	  Thread.sleep(3000);
	  String  Title= driver.getTitle();
	  if("Home | 6S Process".equals(Title))
	  {
		  Assert.assertEquals(Title, "Home | 6S Process");
		  System.out.println("Valid Login");
	  }
	  else {
			Assert.fail();
			System.out.println("Verification failed");
		}
	  
  }
  @Test(enabled= false)
  public void inValidlogin() throws InterruptedException {
	  LoginPage obj= new LoginPage(driver);
	  obj.UsernameField().sendKeys(prop.getProperty("Inusername"));
	  obj.PasswordField().sendKeys(prop.getProperty("Inpassword"));
	  obj.loginButton().click();
	  
	   
	  String invalid= obj.invalid_Field().getText();
	  if(invalid.equals("User does not exist."))
	  {
		  System.out.println("Invalid login failed");
	  }
	  
	 // w2= new WebDriverWait(driver, 30);
	// w2.until(ExpectedConditions.invisibilityOf(obj.invalid_Field()));
	  obj.bttn_Field().click();
  }
  @Test(enabled= false)
  public void Verifylogin() throws InterruptedException {
	  LoginPage obj= new LoginPage(driver);
	  obj.loginButton().click();
	 	String verify= obj.mandatory_Field().getText();
	  if(verify.equals("*Username is required"))
	  {
		  System.out.println("Mandatory fields Verified");
	  }
	  Thread.sleep(3000);
  }


}

