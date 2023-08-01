package com.sevenmart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.AdminUsersDataProvider;

import com.sevenmart.pages.AdminUsersPage;

import com.sevenmart.pages.LoginPage;

public class AdminUsersTest extends Base {

	LoginPage loginpage;

	AdminUsersPage adminuserspage;

	@Test

	public void Verify_HitAdminUser() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers();
		

	}

	@Test(dataProvider = "AdminUsers", dataProviderClass = AdminUsersDataProvider.class)
	public void Verify_AddNewAdminUsers(String username, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUserName(username);
		adminuserspage.enterPassword(password);
		adminuserspage.selectAdminUsers();
	
		
	}
	@Test(dataProvider = "StaffUsers", dataProviderClass = AdminUsersDataProvider.class)
	public void Verify_AddNewStaffUsers(String username, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUserName(username);
		adminuserspage.enterPassword(password);
		adminuserspage.selectStaffUsers();
		
		
	}
	@Test(dataProvider = "PartnerUsers", dataProviderClass = AdminUsersDataProvider.class)
	public void Verify_AddNewPartnerUsers(String username, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUserName(username);
		adminuserspage.enterPassword(password);
		adminuserspage.selectPartnerUsers();
	
		
	}
	@Test(dataProvider = "DeliveryBoyUsers", dataProviderClass = AdminUsersDataProvider.class)
	public void Verify_AddNewDeliveryBoyUsers(String username, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.hitAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUserName(username);
		adminuserspage.enterPassword(password);
		adminuserspage.selectDeliveryBoyUsers();
		
		
	}
	@Test
	public void Verify_DeleteAdminUser() {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginpage.login();
		adminuserspage.hitAdminUsers();
		adminuserspage.deleteUser("Shashi");
		
		
	}
}
