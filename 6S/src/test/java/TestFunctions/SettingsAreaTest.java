package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.SettingsPage;

public class SettingsAreaTest extends BaseClass{
	
	public static  WebDriverWait w2;
	
  @Test(priority=8)
  public void selectAreaMenu() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  w2= new WebDriverWait(driver,10);
	  w2.until(ExpectedConditions.elementToBeClickable(obj.menuField()));
	  //Select settings page
	  obj.menuField().click();
	  
	  w2.until(ExpectedConditions.elementToBeClickable(obj.AreaMenu()));
	  //Select Area
	  obj.AreaMenu().click();
	  Thread.sleep(3000);
  }
  @Test(priority=9)
  public void addArea() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //click add Area button
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.elementToBeClickable(obj.addField()));
	  obj.addField().click();
	  
	  //wait for add modal
	  
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  w2.until(ExpectedConditions.elementToBeClickable(obj.locationSelect()));
	  obj.locationSelect().click();
	  
	  //Select cell
	   Select location = new Select(obj.locationSelect());
	   location.selectByIndex(1);
	   
	  //add Area title
	  obj.addTitle().sendKeys(prop.getProperty("Area"));
	  obj.submitTitle().click();
	  Thread.sleep(3000);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("Area"));
	  Thread.sleep(3000);
	  //Verification Points
	  String Area = obj.listTitle().getText();
	  if("Test Area".equals(Area))
	  {
		  Assert.assertEquals(Area, "Test Area");
		  System.out.println("Create Area executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Create failed");
		}
	  obj.searchTitle().clear();
	  
  }
  @Test(priority=10)
  public void disableArea() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  w2.until(ExpectedConditions.visibilityOf(obj.searchTitle()));
	  obj.searchTitle().clear();
	  obj.searchTitle().sendKeys(prop.getProperty("Area"));
	 
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.elementToBeClickable(obj.buttonEnable()));
	  //click edit Questions button
	  obj.buttonEnable().click();
	  
	  //wait for toast message
	  w2.until(ExpectedConditions.visibilityOf(obj.deleteVerify()));
	   //Verification points
	 
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Status updated successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "Status updated successfully!");
		  System.out.println("Disable on Area executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Disable failed");
		
	  }
	  
	  obj.searchTitle().clear();
  }
  @Test(priority=11)
  public void editArea() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("Area"));
	  Thread.sleep(3000);
	  
	  //click edit Area button
	  obj.edit().click();
	  
	  //wait for edit modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //edit Area title
	  obj.addTitle().clear();
	  obj.addTitle().sendKeys(prop.getProperty("AreaEdit"));
	  obj.submitTitle().click();
	 
  
	  Thread.sleep(3000);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("AreaEdit"));
	  Thread.sleep(3000);
	  //Verification Points
	  String Area = obj.listTitle().getText();
	  if(Area.contentEquals(prop.getProperty("AreaEdit")))
	  {
		  Assert.assertEquals(Area, "Test Area Edited");
		  System.out.println("Update on Area executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Edit failed");
		}
	  obj.searchTitle().clear();
  }
  @Test(priority=12)
  public void deleteArea() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("AreaEdit"));
	  Thread.sleep(3000);
	  
	  //click delete Area button
	  obj.delete().click();
	  
	  //wait for  modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //Confirm delete 
	  obj.deleteConfirm().click();
			 
	  
	  //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Area deleted successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "Area deleted successfully!");
		  System.out.println("Delete on area executed and passed successfully!!! ");
	  }
	  else {
		   System.out.println("Delete failed");
			
			
		}
	 
	  obj.menuField().click();
	  Thread.sleep(3000);
  
  }
}
