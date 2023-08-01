package com.sevenmart.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.bcel.classfile.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmart.constants.Constants;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement rememberMeCheckBox;
	@FindBy(xpath = "//div/h5")
	private WebElement alertMessage;

	public LoginPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {

		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);
	}

	public void check_RememberMeCheckBox() {
		rememberMeCheckBox.click();
	}

	public void clickonSignInButton() {
		//waitutility = new WaitUtility(driver);
		//waitutility.waitForClickable(signInButton);
		signInButton.click();
	}

	public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickonSignInButton();

	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickonSignInButton();
	}

	public String getErrorMessage() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.gettextofelement(alertMessage);
	}

}
