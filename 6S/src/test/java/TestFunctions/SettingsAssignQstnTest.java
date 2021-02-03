package TestFunctions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.SettingsPage;
import Page.SettingsPage2;


public class SettingsAssignQstnTest extends BaseClass {
	public static  WebDriverWait w2;
	public static JavascriptExecutor js;
	@Test(priority= 26)
	  public void addQuestions() throws InterruptedException {
		  
		  SettingsPage obj = new  SettingsPage(driver);
		  //Select settings page
		  obj.menuField().click();
		  Thread.sleep(3000);
		  
		  //Select Questions
		  obj.qstnMenu().click();
		  Thread.sleep(3000);
		  
		  for (int i=1;i<=6;i++)
		  {
		
			  //click add Questions button
			  obj.addField().click();
		  
			  //wait for add modal
			  w2=new WebDriverWait(driver, 30);
			  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
		  
			  //Select Process
			  Select process = new Select(obj.optionsSelect());
		 
			  process.selectByIndex(i);
		 
			  //add Questions title
			  obj.dataEntry().sendKeys(prop.getProperty("Questions"));
			  obj.submitTitle().click();
			  Thread.sleep(3000);
		  
		  }
		  w2.until(ExpectedConditions.elementToBeClickable(obj.menuField()));
		  obj.menuField().click();
		  
	  }  
	
  @Test(priority= 27)
  public void selectAssignQuestion() throws InterruptedException {
	  SettingsPage2 obj = new  SettingsPage2(driver);
	  //Select settings page
	  obj.menuField().click();
	  
	  
	  //Select Assign Questions
	  obj.menuAssgnQstn().click();
	  Thread.sleep(3000);
  }
  @Test(priority= 28)
  public void addAssignQuestion() throws InterruptedException {
	  SettingsPage2 obj = new  SettingsPage2(driver);
	  
	  //select location	  
	  obj.locationSelect().click();
	  Select location = new Select(obj.locationSelect());
	  location.selectByVisibleText(prop.getProperty("LocationSelect"));
	  
	  //select area
	  obj.areaSelect().click();
	  Select Area= new Select(  obj.areaSelect());
	  Area.selectByVisibleText(prop.getProperty("AreaSelect"));
	  
	  //select  cell
	  obj.searchCell().click();
	  Select Cell= new Select(obj.searchCell());
	  Cell.selectByVisibleText(prop.getProperty("CellSelect"));
	  
	  //select clone from	
	  obj.searchClone().click();
	  Select Clone= new Select(obj.searchClone());
	  Clone.selectByVisibleText(prop.getProperty("CloneFrom"));
	  obj.searchClone().click();
	  Thread.sleep(3000);
	  
	  //Select process1
	  obj.clickSort().click();
	  
	  //Select Question 
	  obj.selectQstn().click();
	  Thread.sleep(2000);
	  //Select process 2
	  obj.clickSet().click();
	  
	  //Select Question 
	  obj.selectQstn().click();
	  Thread.sleep(2000);
	  //Select process3
	  obj.clickShine().click();
	  
	  //Select Question 
	  obj.selectQstn().click();
	  Thread.sleep(2000);
	  //Select process4
	  obj.clickStandardise().click();
	  
	  //Select Question 
	  obj.selectQstn().click();
	  Thread.sleep(2000);
	  //Select process5
	  obj.clickSustain().click();
	  
	  //Select Question 
	  obj.selectQstn().click();
	  Thread.sleep(2000);
	  //Select process6
	  obj.clickSafety().click();
	  
	  //Select Question 
	  obj.selectQstn().click();
	  Thread.sleep(2000);
	  
	  js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  obj.submit().click();
	  
	  //wait for toast message
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.deleteVerify()));
	  
	  
	   //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Cell updated successfully."))
	  {
		  Assert.assertEquals(toastMessage, "Cell updated successfully.");
		  System.out.println("Create on Assign Questions executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Disable failed");
		
	  }
	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  
  }
  @Test(priority= 29)
  public void disableAssignQuestion() throws InterruptedException {
	  SettingsPage2 obj = new  SettingsPage2(driver);
	  //Search cell
	  Thread.sleep(2000);
	  js.executeScript("arguments[0].scrollIntoView();",obj.searchTitle());
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.elementToBeClickable(obj.searchTitle()));
	  obj.searchTitle().sendKeys(prop.getProperty("CellSelect"));
	 
	  
	  //Click on enable 
	  w2.until(ExpectedConditions.elementToBeClickable(obj.buttonEnable()));
	  Thread.sleep(3000);
	  obj.buttonEnable().click();
	 
	  //wait for toast message
      w2.until(ExpectedConditions.visibilityOf(obj.deleteVerify()));
	  //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  System.out.println(toastMessage);
	  if(toastMessage.contentEquals("Status updated successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "Status updated successfully!");
		  System.out.println("Disable on Assign Questions executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Disable failed");
		
	  }
	  
	  
  }
  @Test(priority= 30)
  public void editAssignQuestion() {
  }
  @Test(priority= 31)
  public void deleteAssignQuestion() {
  }
  @Test(priority=32)
  public void deleteQuestions() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  w2.until(ExpectedConditions.elementToBeClickable(obj.menuField()));
	  obj.menuField().click();
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.elementToBeClickable(obj.qstnMenu()));
	  
	  //Select Questions
	  obj.qstnMenu().click();
	  Thread.sleep(3000);
	  for (int i=1;i<6;i++)
	  {
		  //Search the added item
		  w2.until(ExpectedConditions.elementToBeClickable(obj.searchTitle()));
		  obj.searchTitle().clear();
		  obj.searchTitle().sendKeys(prop.getProperty("Questions"));
		  Thread.sleep(3000);
	  
		  //click delete Questions button
		  obj.delete().click();
	  
		  //wait for  modal
		  
		  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
		  //Confirm delete 
		  obj.deleteConfirm().click();
	  }
		  
 }
}
