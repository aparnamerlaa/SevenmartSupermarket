package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.DeliveryBoyDataProvider;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.ManageDeliveryBoyPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUtility;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage manageDeliveryBoy;
	LoginPage loginPage;
	PageUtility pageUtility;

	@Test
	public void verify_ManageDeliveryboy() {
		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();

		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		String actualtext = manageDeliveryBoy.Validate_DeliveryBoyPage();
		String expectedtext = "List Delivery Boy";
		Assert.assertEquals(actualtext, expectedtext);

	}

	@Test(dataProvider = "deliveryBoyProfileDetailsExcel", dataProviderClass = DeliveryBoyDataProvider.class)
	public void Verify_CreateNewDeliveryBoyDetails(String name, String email, String number, String address,
			String username, String password) {
		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.clickOn_CreateNewButton();
		manageDeliveryBoy.enterName_DeliveryBoy(name);
		manageDeliveryBoy.enterEmail_DeliveryBoy(email);
		manageDeliveryBoy.enterPhonenumber_DeliveryBoy(number);
		manageDeliveryBoy.enterAddress_DeliveryBoy(address);
		manageDeliveryBoy.enterUserName_DeliveryBoy(username + GeneralUtility.getRandomName());
		manageDeliveryBoy.enterPassword_DeliveryBoy(password);
	
		manageDeliveryBoy.clickOnSaveButton_DeliveryBoy();

	}

	@Test(dataProvider = "ExistingDeliveryBoyDetails", dataProviderClass = DeliveryBoyDataProvider.class)
	public void Verify_AlreadyExistingUsername(String name, String email, String number, String address,
			String username, String password) {

		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.clickOn_CreateNewButton();
		manageDeliveryBoy.enterName_DeliveryBoy(name);
		manageDeliveryBoy.enterEmail_DeliveryBoy(email);
		manageDeliveryBoy.enterPhonenumber_DeliveryBoy(number);
		manageDeliveryBoy.enterAddress_DeliveryBoy(address);
		manageDeliveryBoy.enterUserName_DeliveryBoy(username);
		manageDeliveryBoy.enterPassword_DeliveryBoy(password);
		manageDeliveryBoy.clickOnSaveButton_DeliveryBoy();

	
	}

	@Test(dataProvider = "SearchExistingDeliveryBoyDetails", dataProviderClass = DeliveryBoyDataProvider.class)

	public void Verify_SearchForAlreadyExistingDeliveryBoy(String name, String email) {

		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.clickOnSearchButton();
		manageDeliveryBoy.NameOfExistingDeliveryBoy(name);
		manageDeliveryBoy.EmailOfExistingDeliveryBoy(email);
		manageDeliveryBoy.searchForExistingDetails();
		String actualText = manageDeliveryBoy.getEmailofExistingDeliveryboy();
		String expectedText = email;
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(dataProvider = "nonexistingemailofDeliveryBoyDetails", dataProviderClass = DeliveryBoyDataProvider.class)

	public void verify_ResultforNonExistingDeliveryBoy(String email) {
		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.clickOnSearchButton();
		manageDeliveryBoy.EmailOfExistingDeliveryBoy(email);
		manageDeliveryBoy.searchForExistingDetails();
		String actualText = manageDeliveryBoy.GetAlertofNonExistingDeliveryboy();
		String expectedText = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualText, expectedText);

	}

}
