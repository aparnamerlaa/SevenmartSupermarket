package com.sevenmart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.TestDataProviders;
import com.sevenmart.pages.HomePage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.utilities.ExcelUtility;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelUtility excelutility = new ExcelUtility();

	@Test(priority = 2, groups = "smoke")
	public void verify_AdminUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Dashboard";
		Assert.assertEquals(actualProfileName, expectedProfileName, "Admin login Failed");
	}

	@Test
	public void verify_InvalidUserLogin() {
		loginpage = new LoginPage(driver);
		excelutility.setExcelFile("login data project", "Invalidlogincredential");
		String inValidUserName = excelutility.getCellData(0, 0);
		String invalidPassword = excelutility.getCellData(0, 1);
		loginpage.login(inValidUserName, invalidPassword);
		String actualErrorMessage = loginpage.getErrorMessage();
		String expectedErrorMessage = "Alert!";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Logged in successfully using wrong credential");
	}
	@Test
   public void verify_RemebermeCheckboxNotSelectedbydefault() {
	loginpage = new LoginPage(driver);
	Assert.assertFalse(loginpage.checkboxSelectedInLoginPage(),"Remember me CheckBox is selected by default");
	
}
}
