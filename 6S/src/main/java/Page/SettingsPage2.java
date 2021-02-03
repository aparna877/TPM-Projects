package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage2 {

	WebDriver driver ;
	
	public SettingsPage2(WebDriver driver) {
		  
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
//Settings sub modules
	@FindBy(xpath="//*[contains(text(),'Settings')]") WebElement Sett_Menu;
	@FindBy(xpath="//*[contains(text(),'Assign Question')]") WebElement AssgnQstn_Menu;
	@FindBy(xpath="//*[contains(text(),'User')]") WebElement User_Menu;
	
//Locating Page Elements	
	@FindBy (xpath="//select[@name='locationId']") WebElement LocationOptions;
	@FindBy (xpath="//select[@name='areaId']") WebElement AreaOptions;
	@FindBy (xpath="//select[@name='cellId']") WebElement cellSearch;
	@FindBy (xpath="//select[@name='cloneFrom']") WebElement cloneSearch;
	@FindBy(xpath="//button[contains(text(),'SORT')]") WebElement process_SORT;
	@FindBy(xpath="//button[contains(text(),'SET')]") WebElement process_SET;
	@FindBy(xpath="//button[contains(text(),'SHINE')]") WebElement process_SHINE;
	@FindBy(xpath="//button[contains(text(),'STANDARDISE')]") WebElement process_STANDARDISE;
	@FindBy(xpath="//button[contains(text(),'SUSTAIN')]") WebElement process_SUSTAIN;
	@FindBy(xpath="//button[contains(text(),'SAFETY AND SECURITY')]") WebElement process_SAFETY_AND_SECURITY;
	@FindBy(xpath="//*[text()='Test Questions ?']/input") WebElement Add_qstn;
	@FindBy(xpath="//*[@class=\"btn sec-submit\"]") WebElement Submit;
	@FindBy(xpath="//input[@class='form-control']") WebElement Search;
	@FindBy(xpath="//button[@class='btn btn-success btn-xs btn-usrStatDisable p-tb-2']") WebElement enable;
	
	
	@FindBy (className="modal-content") WebElement addModal;
	@FindBy(xpath="//input[@class='form-control form-nw error']") WebElement Title;

	
	@FindBy(xpath="//*/table/tbody/tr[2]/td[2]") WebElement Listtitle;
	@FindBy(xpath="//*[@class=\"far fa-edit clr-grey\"]") WebElement Edit_title;
	@FindBy(xpath="//*[@class=\"far fa-trash-alt clr-grey\"]") WebElement Delete_title;
	@FindBy(xpath="//*[@class=\"btn btn-success\"]") WebElement ConfirmDelete;
	@FindBy(xpath="//*[@class=\"toast-message\"]") WebElement toastDelete;
	

	@FindBy (xpath="//input[@class='form-control form-nw']") WebElement TitleField;
	@FindBy (xpath="//select[@class='form-control form-nw']") WebElement Options;
	@FindBy(xpath="//input[@class='form-control form-nw']") WebElement Data;
	
	@FindBy(xpath="//button[@class='toast-close-button']") WebElement closeToast;
	
	@FindBy (xpath="//*[@id=\"file\"]") WebElement Upload;
	
//Functions for actions	
	public WebElement menuField()
	{
	 return Sett_Menu;	
	}
	public WebElement menuAssgnQstn()
	{
	 return AssgnQstn_Menu;	
	}
	public WebElement clickSort()
	{
	 return process_SORT;	
	}
	public WebElement clickSet()
	{
	 return process_SET;	
	}
	public WebElement clickShine()
	{
	 return process_SHINE;	
	}
	public WebElement clickSustain()
	{
	 return process_SUSTAIN;	
	}
	public WebElement clickStandardise()
	{
	 return process_STANDARDISE;	
	}
	public WebElement clickSafety()
	{
	 return process_SAFETY_AND_SECURITY;	 
	}
	public WebElement addwait()
	{
	 return addModal;	
	}
	public WebElement addTitle()
	{
	 return Title;	
	}
	public WebElement submit()
	{
	 return Submit;	
	}
	public WebElement searchTitle()
	{
	 return Search;	
	}
	public WebElement listTitle()
	{
	 return Listtitle;	
	}
	public WebElement edit()
	{
	 return Edit_title;	
	}
	public WebElement delete()
	{
	 return Delete_title;	
	}
	public WebElement deleteConfirm()
	{
	 return ConfirmDelete;	
	}
	public WebElement deleteVerify()
	{
	 return toastDelete;	
	}
	
    public WebElement locationSelect() {
			return LocationOptions;
	}
    public WebElement areaSelect() {
			return AreaOptions;
	}
   
    public WebElement title() {
    	return TitleField;
    }
    
    public WebElement optionsSelect() {
    	return Options;
    }
    public WebElement dataEntry() {
    	return Data;
    }
    public WebElement buttonEnable() {
    	return enable;
    }
    public WebElement buttonClose() {
    	return closeToast;
    }
   
    public WebElement selectQstn() {
    	return Add_qstn;
    }
    //To upload file 
    public WebElement fileUpload() {
    	return Upload;
    }
    //To search cell
    public WebElement searchCell() {
    	return cellSearch;
    }
    public WebElement searchClone() {
    	return cloneSearch;
    }
	
		
}
