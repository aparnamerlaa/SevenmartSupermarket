package com.sevenmart.tests;

import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.pages.HomePage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.PushNotificationPage;
import com.sevenmart.utilities.ExcelUtility;

public class PushNotificationTest extends Base
{
	LoginPage loginpage;
	PushNotificationPage pushnotificationpage;
	ExcelUtility excelutility = new ExcelUtility();
	@Test
	public void verify_PushNotification() {
		loginpage = new LoginPage(driver);
		pushnotificationpage=new PushNotificationPage(driver);
		loginpage.login();
		pushnotificationpage.clickOn_PushNotification();
		
}
	}
