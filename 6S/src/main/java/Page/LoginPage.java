package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

	WebDriver driver ;
	

	public LoginPage(WebDriver driver) {
		  
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 }
	//Elements
	//@FindBy(how=How.NAME, using="companyId") WebElement company_name;
	@FindBy(how=How.NAME, using="userName") WebElement user_name;
	@FindBy(how=How.NAME, using="password") WebElement user_pas;
	@FindBy(xpath= "//input[@class='form-control-btn']") WebElement loginbutton;
	//Elements-Verification Points
	@FindBy(xpath="//*[contains(text(),\'User does not exist.')]") WebElement invalidField;
	@FindBy(xpath="//*[contains(text(),\"*Username is required\")]") WebElement mandatoryField;
	@FindBy(className="toast-close-button") WebElement close;
	
	public WebElement UsernameField()
	{
		return user_name;
	}
	public WebElement PasswordField()
	{
		return user_pas;
	}
	public WebElement loginButton()
	{
		return loginbutton;
	}
	public WebElement invalid_Field()
	{
		return invalidField;
	}
	public WebElement mandatory_Field()
	{
		return mandatoryField;
	}
	public WebElement bttn_Field()
	{
		return close;
	}

}
