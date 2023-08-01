package com.sevenmart.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUtility;
import com.sevenmart.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WaitUtility waitutility;
	WebDriver driver;
	GeneralUtility generalutility;
	LoginPage loginpage;
	PageUtility pageUtility;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user-plus']")
	private WebElement manageDeliveryBoy;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	private WebElement deliveryBoyPageConfirmelement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickNew;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumber;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//button")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/h5")
	private WebElement alertMessage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5")
	private WebElement alertMessageOfsameUsername;
	@FindBy(xpath = "//i[@class=' fa fa-search']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchWithName;
	@FindBy(xpath = "//input[@id='ut']")
	private WebElement searcheWithEmail;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement tableSearchButton;
	@FindBy(xpath = "//tbody//tr[1]//td[2]")
	private WebElement existingEmail;
	@FindBy(xpath = "//tbody//tr//td/span[@id='res']")
	private WebElement nonexistingEmail;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement resetButton;
	@FindBy(xpath="//table/tbody/tr/td[1]")
	private List<WebElement> userNames;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void hit_ManageDeliveryBoyLink() {

		manageDeliveryBoy.click();
	}

	public String Validate_DeliveryBoyPage() {
		generalutility = new GeneralUtility(driver);

		return generalutility.gettextofelement(deliveryBoyPageConfirmelement);
	}

	public void clickOn_CreateNewButton() {
		clickNew.click();
	}

	public void enterName_DeliveryBoy(String name) {
		nameField.sendKeys(name);
	}

	public void enterEmail_DeliveryBoy(String email) {
		emailField.sendKeys(email);
	}

	public void enterPhonenumber_DeliveryBoy(String number) {
		phoneNumber.sendKeys(number);
	}

	public void enterAddress_DeliveryBoy(String addressdetails) {
		address.sendKeys(addressdetails);

	}

	public void enterUserName_DeliveryBoy(String userNamedetails) {
		userName.sendKeys(userNamedetails);

	}

	public void enterPassword_DeliveryBoy(String passwordDetails) {
		password.sendKeys(passwordDetails);
	}
//
//	public void scrollTo_ClickSaveButton() {
//		pageUtility = new PageUtility(driver);
//		pageUtility.javaScriptExecutorScrollToElement(saveButton);
//	}
//	public void scrollAndClick() {
//		pageUtility = new PageUtility(driver);
//		pageUtility.scrollAndClick(saveButton);
//	}

//	public void clickOnSaveButton_DeliveryBoy() {
//		pageUtility = new PageUtility(driver);
//		pageUtility.javaScriptScrollandclick(saveButton);
//	}
	public void clickOnSaveButton_DeliveryBoy() {
		saveButton.submit();
	}
//
//	public String alertMessage() {
//		generalutility = new GeneralUtility(driver);
//
//		return generalutility.gettextofelement(alertMessage);
//
//	}
//
//	public String alertMessageOfUsernameAlreadyExist() {
//		generalutility = new GeneralUtility(driver);
//
//		return generalutility.gettextofelement(alertMessageOfsameUsername);
//
//	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void NameOfExistingDeliveryBoy(String nameOfexistingDeliveryBoy) {
		searchWithName.sendKeys(nameOfexistingDeliveryBoy);
	}

	public void EmailOfExistingDeliveryBoy(String emailOfexistingDeliveryBoy) {
		searcheWithEmail.sendKeys(emailOfexistingDeliveryBoy);

	}

	public void searchForExistingDetails() {
		tableSearchButton.click();
	}

	public String getEmailofExistingDeliveryboy() {
		generalutility = new GeneralUtility(driver);

		return generalutility.gettextofelement(existingEmail);

	}
	public String GetAlertofNonExistingDeliveryboy() 
	{
		generalutility = new GeneralUtility(driver);

		return generalutility.gettextofelement(nonexistingEmail);

	}
	
		
		
	}
	
