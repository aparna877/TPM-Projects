package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.SettingsPage;

public class SettingsLocationTest extends BaseClass{
	
	public static  WebDriverWait w2;
	
  @Test(priority=3)
  public void selectLocationMenu() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Select settings page
	  obj.menuField().click();
	  Thread.sleep(3000);
	  
	  //Select Location
	  obj.locField().click();
	  Thread.sleep(3000);
  }
  @Test(priority=4)
  public void addLocation() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //click add location button
	  obj.addField().click();
	  
	  //wait for add modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //add location title
	  obj.addTitle().sendKeys(prop.getProperty("Location"));
	  obj.submitTitle().click();
	  Thread.sleep(3000);
	  //Close toast message
	  obj.buttonClose();
	  Thread.sleep(2000);
	  
	  
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("Location"));
	  Thread.sleep(3000);
	  //Verification Points
	  String location = obj.listTitle().getText();
	  if(location.contentEquals(prop.getProperty("Location")))
	  {
		  Assert.assertEquals(location, "Test Location");
		  System.out.println("Create  Location executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Create failed");
		}
	  obj.searchTitle().clear();
	
	  Thread.sleep(2000);
	  
  }
  @Test(priority=5)
  public void disableQuestions() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  w2.until(ExpectedConditions.visibilityOf(obj.searchTitle()));
	  obj.searchTitle().clear();
	  obj.searchTitle().sendKeys(prop.getProperty("Location"));
	  w2.until(ExpectedConditions.elementToBeClickable(obj.buttonEnable()));
	  //click enable button
	  obj.buttonEnable().click();
	  
	  //wait for toast message
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.deleteVerify()));
	   //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Status updated successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "Status updated successfully!");
		  System.out.println("Disable on Questions executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Disable failed");
		
	  }
	  
	  obj.searchTitle().clear();
	//Close toast message
	  obj.buttonClose();
	  Thread.sleep(2000);
  }
  @Test(priority=6)
  public void editLocation() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("Location"));
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.elementToBeClickable(obj.edit()));
	  
	  //click edit location button
	  obj.edit().click();
	  
	  //wait for edit modal
	  
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  w2.until(ExpectedConditions.elementToBeClickable(obj.addTitle()));
	  //edit location title
	  obj.addTitle().clear();
	  Thread.sleep(2000);
	  obj.addTitle().sendKeys(prop.getProperty("LocationEdit"));
	  obj.submitTitle().click();
	  
	//Close toast message
	  obj.buttonClose();
	  Thread.sleep(2000);
	 
      w2.until(ExpectedConditions.elementToBeClickable(obj.searchTitle()));
	  //Search the added item
      obj.searchTitle().clear();
      Thread.sleep(2000);
	  obj.searchTitle().sendKeys(prop.getProperty("LocationEdit"));
	  Thread.sleep(3000);
	  //Verification Points
	  String location = obj.listTitle().getText();
	  if("Test Location Edited".equals(location))
	  {
		  Assert.assertEquals(location, "Test Location Edited");
		  System.out.println("Update on location executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Edit failed");
		}
	  obj.searchTitle().clear();
  }
  @Test(priority=7)
  public void deleteLocation() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("LocationEdit"));
	  w2.until(ExpectedConditions.elementToBeClickable(obj.delete()));
	  
	  //click delete location button
	  obj.delete().click();
	  
	  //wait for  modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //Confirm delete 
	  obj.deleteConfirm().click();
		  
	 
	 
	  
	  //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Location deleted successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "Location deleted successfully!");
		  System.out.println("Delete on Location executed and passed successfully!!! ");
	  }
	  else {
		   System.out.println("Delete failed");
			
			
		}	  

	//Close toast message
	  obj.buttonClose();
	  obj.menuField().click();
	  Thread.sleep(3000);

  
  }
}
