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
//pass
	@Test
	public void verify_ManageDeliveryboy() {
		manageDeliveryBoy=new ManageDeliveryBoyPage(driver);
		manageDeliveryBoy.hitOnManageDeliveryboy();
		String actualtext = manageDeliveryBoy.Validate_DeliveryBoyPage();
		String expectedtext = "List Delivery Boy";
		Assert.assertEquals(actualtext, expectedtext,"Manage DeliveryBoy page not selected");

	}
//pass
	@Test(dataProvider = "DeliveryBoyDetails", dataProviderClass =  DeliveryBoyDataProvider.class)
	public void Verify_CreateNewDeliveryBoyDetails(String name, String email, String number, String address,
			String username, String password) {
		
		loginPage = new LoginPage(driver);
		loginPage.login();
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.clickOn_CreateNewButton();
		manageDeliveryBoy.enterName_DeliveryBoy(name);
		manageDeliveryBoy.enterEmail_DeliveryBoy(email);
		manageDeliveryBoy.enterPhonenumber_DeliveryBoy(number);
		manageDeliveryBoy.enterAddress_DeliveryBoy(address);
		manageDeliveryBoy.enterUserName_DeliveryBoy(username + GeneralUtility.getRandomName());
		manageDeliveryBoy.enterPassword_DeliveryBoy(password);
		manageDeliveryBoy.clickOnSaveButton_DeliveryBoy();
		String actualresult=manageDeliveryBoy.searchNewlyAddedDeliveryBoyInTableByUserName(username);
		String expectedresult="	ApaRajshGreta";
		Assert.assertEquals(actualresult,expectedresult,"Result not found");
	}

	@Test(dataProvider = "deliveryBoyProfileDetailsExcelnonexisting", dataProviderClass = DeliveryBoyDataProvider.class)
	public void Verify_AlreadyExistingUsername(String name, String email, String number, String address,
			String username, String password) {

		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		manageDeliveryBoy.AlreadyExistingUsername(name, email, number, address, username, password);
		manageDeliveryBoy.clickOnSaveButton_DeliveryBoy();
	}

	@Test(dataProvider = "SearchExistingDeliveryBoyDetails", dataProviderClass = DeliveryBoyDataProvider.class)

	public void Verify_SearchForAlreadyExistingDeliveryBoy(String name, String email) {

		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.SearchForAlreadyExistingDeliveryBoy(name, email);
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
		manageDeliveryBoy.ResultforNonExistingDeliveryBoy(email);
		
	}

}
