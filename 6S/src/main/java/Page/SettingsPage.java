package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

	WebDriver driver ;
	
	public SettingsPage(WebDriver driver) {
		  
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
//Settings sub modules
	@FindBy(xpath="//*[contains(text(),'Settings')]") WebElement Sett_Menu;
	@FindBy(xpath="//*[contains(text(),'Location')]") WebElement Location_Menu;
	@FindBy(xpath="//*[contains(text(),'Area')]") WebElement Area_Menu;
	@FindBy(xpath="//*[contains(text(),'Cell')]") WebElement Cell_Menu;
	@FindBy(xpath="//*[contains(text(),'Questions')]") WebElement Qstn_Menu;
	@FindBy(xpath="//*[contains(text(),'WDGL')]") WebElement WDGL_Menu;
//Locating Page Elements	
	
	@FindBy(xpath="//*[@class='btn btn-info btn-lg text-right add-user']") WebElement Add_Menu;
	@FindBy (className="modal-content") WebElement addModal;
	@FindBy(xpath="//input[@class='form-control form-nw error']") WebElement Title;
	@FindBy(xpath="//*[@class=\"btn btn-submit\"]") WebElement Submit;
	@FindBy(xpath="//input[@class='form-control']") WebElement Search;
	@FindBy(xpath="//*/table/tbody/tr[2]/td[2]") WebElement Listtitle;
	@FindBy(xpath="//*[@class=\"far fa-edit clr-grey\"]") WebElement Edit_title;
	@FindBy(xpath="//*[@class=\"far fa-trash-alt clr-grey\"]") WebElement Delete_title;
	@FindBy(xpath="//*[@class=\"btn btn-success\"]") WebElement ConfirmDelete;
	@FindBy(xpath="//*[@class=\"toast-message\"]") WebElement toastDelete;
	@FindBy (xpath="//select[@name='loc_id' and @class='form-control form-nw']") WebElement LocationOptions;
	@FindBy (xpath="//select[@name='area_id' and @class='form-control form-nw']") WebElement AreaOptions;
	@FindBy (xpath="//input[@class='form-control form-nw']") WebElement TitleField;
	@FindBy (xpath="//select[@class='form-control form-nw']") WebElement Options;
	@FindBy(xpath="//input[@class='form-control form-nw']") WebElement Data;
	@FindBy(xpath="//button[@class='btn btn-success btn-xs btn-usrStatDisable p-tb-2']") WebElement enable;
	@FindBy(xpath="//button[@class='toast-close-button']") WebElement closeToast;
	@FindBy(xpath="//button[@class='btn btn-info btn-lg text-right add-user']") WebElement WDGLimagee;
	@FindBy (xpath="//*[@id=\"file\"]") WebElement Upload;
	@FindBy (xpath="//select[@name=\"cellId\"]") WebElement cellSearch;
//Functions for actions	
	public WebElement menuField()
	{
	 return Sett_Menu;	
	}
	public WebElement locField()
	{
	 return Location_Menu;	
	}
	public WebElement addField()
	{
	 return Add_Menu;	
	}
	public WebElement addwait()
	{
	 return addModal;	
	}
	public WebElement addTitle()
	{
	 return Title;	
	}
	public WebElement submitTitle()
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
	public WebElement AreaMenu() {
			return Area_Menu;
	}
    public WebElement locationSelect() {
			return LocationOptions;
	}
    public WebElement areaSelect() {
			return AreaOptions;
	}
    public WebElement CellMenu() {
	    	return Cell_Menu;
    }
    public WebElement title() {
    	return TitleField;
    }
    public WebElement qstnMenu() {
    	return Qstn_Menu;
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
    public WebElement menu_WDGL() {
    	return WDGL_Menu;
    }
    public WebElement image_WDGL() {
    	return WDGLimagee;
    }
    //To upload file 
    public WebElement fileUpload() {
    	return Upload;
    }
    //To search cell in WDGL
    public WebElement searchWDGL() {
    	return cellSearch;
    }
		
}
