package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.SettingsPage;

public class SettingsCellTest extends BaseClass{
	
	public static  WebDriverWait w2;
	
  @Test(priority=13)
  public void selectCellMenu() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Select settings page
	  obj.menuField().click();
	  Thread.sleep(3000);
	  
	  //Select Cell
	  obj.CellMenu().click();
	  Thread.sleep(3000);
  }
  @Test(priority=14)
  public void addCell() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //click add Cell button
	  obj.addField().click();
	  
	  //wait for add modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  w2.until(ExpectedConditions.elementToBeClickable(obj.locationSelect()));
	  obj.locationSelect().click();
	  
	  //Select Location
	   Select location = new Select(obj.locationSelect());
	   location.selectByIndex(1);
	   Thread.sleep(3000);
	 //Select Area
	   Select area = new Select(obj.areaSelect());
	   area.selectByIndex(1);
	   
	  //add Cell title
	  obj.title().sendKeys(prop.getProperty("Cell"));
	  obj.submitTitle().click();
	  Thread.sleep(3000);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("Cell"));
	  Thread.sleep(3000);
	  //Verification Points
	  String Cell = obj.listTitle().getText();
	  if("Test Cell".equals(Cell))
	  {
		  Assert.assertEquals(Cell, "Test Cell");
		  System.out.println("Create Cell executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Create failed");
		}
	  obj.searchTitle().clear();
	  
  }
  @Test(priority=15)
  public void disableQuestions() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  w2.until(ExpectedConditions.visibilityOf(obj.searchTitle()));
	  obj.searchTitle().sendKeys(prop.getProperty("Cell"));
	  Thread.sleep(3000);
	  
	  //click edit Questions button
	  obj.buttonEnable().click();
	  
	  //wait for toast message
	  w2=new WebDriverWait(driver, 30);
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
  @Test(priority=16)
  public void editCell() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("Cell"));
	  Thread.sleep(3000);
	  
	  //click edit Cell button
	  obj.edit().click();
	  
	  //wait for edit modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //edit Cell title
	  obj.title().clear();
	  obj.title().sendKeys(prop.getProperty("CellEdit"));
	  obj.submitTitle().click();
	 
  
	  Thread.sleep(3000);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("CellEdit"));
	  Thread.sleep(3000);
	  //Verification Points
	  String Cell = obj.listTitle().getText();
	  if(Cell.contentEquals(prop.getProperty("CellEdit")))
	  {
		  Assert.assertEquals(Cell, "Test Cell Edited");
		  System.out.println("Update on Cell executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Edit failed");
		}
	  obj.searchTitle().clear();
  }
  @Test(priority=17)
  public void deleteCell() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  obj.searchTitle().sendKeys(prop.getProperty("CellEdit"));
	  Thread.sleep(3000);
	  
	  //click delete Cell button
	  obj.delete().click();
	  
	  //wait for  modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //Confirm delete 
	  obj.deleteConfirm().click();
			 
	  
	  //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Cell deleted successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "Cell deleted successfully!");
		  System.out.println("Delete on Cell executed and passed successfully!!! ");
	  }
	  else {
		   System.out.println("Delete failed");
			
			
		}
	 
	  obj.menuField().click();
	  Thread.sleep(3000);
  
  }
}
