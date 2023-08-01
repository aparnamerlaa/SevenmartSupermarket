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
	

	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	private WebElement pushNotification;
	
	
	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		public void clickOn_PushNotification() 
		{
			pushNotification.click();
		}
		
	}
	
	
	
	
	
	
