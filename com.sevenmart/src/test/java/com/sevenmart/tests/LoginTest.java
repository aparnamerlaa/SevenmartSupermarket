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

	@Test(priority = 2)
	public void verify_AdminUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "admin";
		Assert.assertEquals(actualProfileName, expectedProfileName,"Not valid userlogin");
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
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	

//test data must be from test only
	@Test(dataProvider = "InvalidCredentials", dataProviderClass = TestDataProviders.class)
	public void verify_InvalidUserLogin1(String userName, String password) {
		loginpage = new LoginPage(driver);
        loginpage.login(userName, password);
        String actualErrorMessage = loginpage.getErrorMessage();
		String expectedErrorMessage = "Invalid Username/Password";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
}
