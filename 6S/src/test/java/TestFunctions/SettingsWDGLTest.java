package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.SettingsPage;

public class SettingsWDGLTest extends BaseClass{
	
	public static  WebDriverWait w2;
	
  @Test(priority=23)
  public void selectWDGLMenu() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Select settings page
	  obj.menuField().click();
	  Thread.sleep(3000);
	  
	  //Select WDGL
	  obj.menu_WDGL().click();
	  Thread.sleep(3000);
  }
  @Test(priority=24)
  public void addWDGL() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //click add WDGL button
	  obj.image_WDGL().click();
	  
	  //wait for add modal
	  w2=new WebDriverWait(driver, 10);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  //Select CellSearch
	  w2.until(ExpectedConditions.elementToBeClickable(obj.optionsSelect()));
	  obj.optionsSelect().click();
	  Select CellSearch = new Select(obj.optionsSelect());
	  CellSearch.selectByVisibleText(prop.getProperty("CellSearch"));
	  obj.optionsSelect().click();
	 
	  //add WDGL
	  //w2.until(ExpectedConditions.elementToBeClickable(obj.fileUpload()));
	 // obj.fileUpload().click();
	  obj.fileUpload().sendKeys("C:\\Users\\aparn\\OneDrive\\Pictures\\Camera Roll\\sample.jpg");
	  obj.submitTitle().click();
	  Thread.sleep(3000);
	  
	 
	  //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Successfully uploaded WDGLL."))
	  {
		  Assert.assertEquals(toastMessage, "Successfully uploaded WDGLL.");
		  System.out.println("Create on WDGL executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Delete failed");
			 
			
		}
	  
  }@Test(priority=25)
  
  public void deleteWDGL() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  w2.until(ExpectedConditions.elementToBeClickable(obj.searchWDGL()));
	  obj.searchWDGL().click();
	  
	  Select CellSearch = new Select(obj.searchWDGL());
	  CellSearch.selectByVisibleText(prop.getProperty("CellSearch"));
	  Thread.sleep(3000);
	  
	  //click delete WDGL button
	  obj.delete().click();
	  
	  //wait for  modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //Confirm delete 
	  obj.deleteConfirm().click();
		  
	  
	  //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("WDGLL deleted successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "WDGLL deleted successfully!");
		  System.out.println("Delete on WDGL executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Delete failed");
			 
			
		}
	  
	  obj.menuField().click();
	  Thread.sleep(3000);

  
  }
}
