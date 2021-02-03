package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.SettingsPage;

public class SettingsQuestionsTest extends BaseClass{
	
	public static  WebDriverWait w2;
	
  @Test(priority=18)
  public void selectQuestionsMenu() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Select settings page
	  obj.menuField().click();
	  Thread.sleep(3000);
	  
	  //Select Questions
	  obj.qstnMenu().click();
	  Thread.sleep(3000);
  }
  @Test(priority=19)
  public void addQuestions() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //click add Questions button
	  obj.addField().click();
	  
	  //wait for add modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  //Select Process
	  Select process = new Select(obj.optionsSelect());
	  process.selectByVisibleText(prop.getProperty("process"));
	  //add Questions title
	  obj.dataEntry().sendKeys(prop.getProperty("Questions"));
	  obj.submitTitle().click();
	  Thread.sleep(3000);
	  //Search the added item
	  w2.until(ExpectedConditions.visibilityOf(obj.searchTitle()));
	  obj.searchTitle().clear();
	  obj.searchTitle().sendKeys(prop.getProperty("Questions"));
	  Thread.sleep(3000);
	  //Verification Points
	  w2.until(ExpectedConditions.visibilityOf(obj.listTitle()));
	  String Questions = obj.listTitle().getText();
	  if(Questions.contentEquals(prop.getProperty("Questions")))
	  {
		  Assert.assertEquals(Questions, (prop.getProperty("Questions")));
		  System.out.println("Create  Questions executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Create failed");
		}
	  obj.searchTitle().clear();
	  
  }@Test(priority=20)
  public void disableQuestions() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  w2.until(ExpectedConditions.visibilityOf(obj.searchTitle()));
	  obj.searchTitle().sendKeys(prop.getProperty("Questions"));
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
		  System.out.println("Disable on Questions executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Disable failed");
		
	  }
	  
	  obj.searchTitle().clear();
  }
  @Test(priority=21)
  public void editQuestions() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  w2.until(ExpectedConditions.visibilityOf(obj.searchTitle()));
	  obj.searchTitle().sendKeys(prop.getProperty("Questions"));
	  Thread.sleep(3000);
	  
	  //click edit Questions button
	  obj.edit().click();
	  
	  //wait for edit modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //edit Questions title
	  w2.until(ExpectedConditions.elementToBeClickable(obj.dataEntry()));
	  obj.dataEntry().clear();
	  obj.dataEntry().sendKeys(prop.getProperty("QuestionsEdit"));
	  Thread.sleep(3000);
	  obj.submitTitle().click();
	  Thread.sleep(3000);
	
  	 
	  //Search the added item
	  w2.until(ExpectedConditions.visibilityOf(obj.searchTitle()));
	  obj.searchTitle().clear();
	  obj.searchTitle().sendKeys(prop.getProperty("QuestionsEdit"));
	  w2.until(ExpectedConditions.visibilityOf(obj.listTitle()));
	  
	  //Verification Points
	  String QuestionEdit = obj.listTitle().getText();
	  
	  if(QuestionEdit.contentEquals(prop.getProperty("QuestionsEdit")))
	  {
		  Assert.assertEquals(QuestionEdit, prop.getProperty("QuestionsEdit"));
		  System.out.println("Update on Questions executed and passed successfully!!! ");
	  }
	  else {
			Assert.fail();
			System.out.println("Edit failed");
		}
	  obj.searchTitle().clear();
  }
  @Test(priority=22)
  public void deleteQuestions() throws InterruptedException {
	  
	  SettingsPage obj = new  SettingsPage(driver);
	  //Search the added item
	  w2.until(ExpectedConditions.elementToBeClickable(obj.searchTitle()));
	  obj.searchTitle().clear();
	  obj.searchTitle().sendKeys(prop.getProperty("QuestionsEdit"));
	  Thread.sleep(3000);
	  
	  //click delete Questions button
	  obj.delete().click();
	  
	  //wait for  modal
	  w2=new WebDriverWait(driver, 30);
	  w2.until(ExpectedConditions.visibilityOf(obj.addwait()));
	  
	  //Confirm delete 
	  obj.deleteConfirm().click();
		  
	  
	  //Verification points
	  String toastMessage = obj.deleteVerify().getText();
	  if(toastMessage.contentEquals("Question deleted successfully!"))
	  {
		  Assert.assertEquals(toastMessage, "Question deleted successfully!");
		  System.out.println("Delete on Questions executed and passed successfully!!! ");
	  }
	  else {
		   Assert.fail();
		   System.out.println("Delete failed");
			 
			
		}
	  
	  obj.menuField().click();
	  Thread.sleep(3000);

  
  }
}
