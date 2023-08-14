package com.sevenmart.tests;

import java.security.acl.Group;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;
import com.sevenmart.pages.HomePage;
import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.AdminUsersDataProvider;
import com.sevenmart.dataproviders.TestDataProviders;
import com.sevenmart.pages.AdminUsersPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUtility;
import com.sevenmart.pages.LoginPage;

public class AdminUsersTest extends Base {

	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	ExcelUtility excelUtility;
	GeneralUtility generalUtility;
	PageUtility pageUtility;

	@Test(priority = 1, groups = "smoke")
	public void Verify_HitAdminUser() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers();
		String actuaresult = adminuserspage.adminUsersPageVerification();
		String expectedresult = "Admin Users";
		Assert.assertEquals(actuaresult, expectedresult, "Not in Admin usersPage");

	}

	@Test(groups = "smoke")
	public void Verify_AddNewAdminUsers() {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		excelUtility = new ExcelUtility();
		loginpage.login();
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
		excelUtility.setExcelFile("AdminUsers", "newAdminUser");
		String userName = excelUtility.getCellData(0, 0);
		String passWord = excelUtility.getCellData(0, 1);
		adminuserspage.enterUserName(userName);
		adminuserspage.enterPassword(passWord);
		adminuserspage.selectUserType("Admin");
		adminuserspage.clickSaveButton();
		String expectedUser = userName;
		String actualuser = adminuserspage.checkNewAdminUserCreatedOrNot();
		Assert.assertEquals(actualuser, expectedUser, "New user not created");

	}

	@Test
	public void Verify_AddNewStaffUsers(String username, String password) {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		excelUtility = new ExcelUtility();
		loginpage.login();
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
		excelUtility.setExcelFile("AdminUsers", "newAdminUser");
		String userName = excelUtility.getCellData(1, 0);
		String passWord = excelUtility.getCellData(1, 1);
		adminuserspage.enterUserName(userName);
		adminuserspage.enterPassword(passWord);
		adminuserspage.selectUserType("Staff");
		adminuserspage.clickSaveButton();
		String expectedUser = userName;
		String actualuser = adminuserspage.checkNewAdminUserCreatedOrNot();
		Assert.assertEquals(actualuser, expectedUser, "New Adminuser not created");

	}

	@Test(dataProvider = "PartnerCreationFromAdminPage", dataProviderClass = AdminUsersDataProvider.class)
	public void Verify_AddNewPartnerUsers(String username, String password) {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		excelUtility = new ExcelUtility();
		loginpage.login();
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
	    adminuserspage.enterUserName(username);
		adminuserspage.enterPassword(password);
		adminuserspage.selectUserType("Partner");
		adminuserspage.clickSaveButton();
		String expectedUser = username;
		String actualUser = adminuserspage.checkNewAdminUserCreatedOrNot();
		Assert.assertEquals(actualUser, expectedUser, "New Parter user not created");

	}
	

	@Test

	public void Verify_AddNewDeliveryBoyUsers() {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		excelUtility = new ExcelUtility();
		loginpage.login();
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
		excelUtility.setExcelFile("AdminUsers", "newAdminUser");
		String userName = excelUtility.getCellData(3, 0);
		String passWord = excelUtility.getCellData(3, 1);
		adminuserspage.enterUserName(userName);
		adminuserspage.enterPassword(passWord);
		adminuserspage.selectUserType("Delivery Boy");
		adminuserspage.clickSaveButton();
		String expectedUser = userName;
		String actualuser = adminuserspage.checkNewAdminUserCreatedOrNot();
		Assert.assertEquals(actualuser, expectedUser, "New DeliveryBoyuser not created");

	}

	@Test
	public void Verify_DeleteAdminUser() {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginpage.login();
		adminuserspage.hitAdminUsers();
		adminuserspage.deleteUser("reymondd");
		pageUtility=new PageUtility(driver);
		pageUtility.acceptAlert();
	 
		

	}
}
