package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.pages.HomePage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.PushNotificationPage;
import com.sevenmart.utilities.ExcelUtility;

public class PushNotificationTest extends Base {
	LoginPage loginpage;
	PushNotificationPage pushnotificationpage;
	ExcelUtility excelutility = new ExcelUtility();

	@Test
	public void verify_PushNotification() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationPage(driver);
		loginpage.login();
		pushnotificationpage.clickOn_PushNotification();
		Assert.assertTrue(pushnotificationpage.checkPushNotificationPage(), "page not found");

	}
	@Test
	public void Verify_PushNotificationPageSendMessage() {
		loginpage=new LoginPage(driver);
		pushnotificationpage=new PushNotificationPage(driver);
		excelutility=new ExcelUtility();
		loginpage.login();
		pushnotificationpage.sendPushNotificationInformations();
		excelutility.setExcelFile("Pushnotificationdata","data");
		String titlemessage=excelutility.getCellData(0, 1);
		String description=excelutility.getCellData(1, 1);
		pushnotificationpage.passValuesOnTitleAndDescription(titlemessage, description);
		Assert.assertTrue(pushnotificationpage.successAlert(),"Submission Failed");
		
		
		
	}
}
