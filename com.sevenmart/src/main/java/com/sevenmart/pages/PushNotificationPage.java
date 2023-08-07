package com.sevenmart.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmart.utilities.GeneralUtility;

public class PushNotificationPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	GeneralUtility generalutility;
	LoginPage loginPage;
	

	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	private WebElement pushNotification;

	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	private WebElement pushNotificationPageConfirm;
	@FindBy(xpath="//input[@id='description']")
	private WebElement descriptionOfPushNotification;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement sendButton;
	@FindBy(xpath="//a[@type='button']")
	private WebElement resetButton;
	@FindBy(xpath="//input[@id='title']")
	private WebElement pushnotificationtitle;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertMessage;
	
	
	
	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		public void clickOn_PushNotification() 
		{
			pushNotification.click();
		}
		public boolean checkPushNotificationPage() {
			generalutility=new GeneralUtility(driver);
			return generalutility.is_Displayed(pushNotificationPageConfirm);
		}
		public void sendPushNotificationInformations() {
			loginPage=new LoginPage(driver);
			clickOn_PushNotification();
		}
		public void passValuesOnTitleAndDescription(String titleText,String descriptionText) {
			 pushnotificationtitle.sendKeys(titleText);
			 descriptionOfPushNotification.sendKeys(descriptionText);
			 sendButton.click();
		}
		public boolean successAlert() {
			generalutility = new GeneralUtility(driver);
			return generalutility.is_Displayed(successAlertMessage);
		}
	
	}
	
	
	
	
	
	
