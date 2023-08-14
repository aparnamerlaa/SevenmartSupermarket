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
	ExcelUtility excelUtility;
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
	@Test(dataProvider = "deliveryBoyProfileDetailsExcel", dataProviderClass =  DeliveryBoyDataProvider.class,groups = "smoke")
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
		manageDeliveryBoy.enterUserName_DeliveryBoy(username);
		manageDeliveryBoy.enterPassword_DeliveryBoy(password);
		manageDeliveryBoy.clickOnSaveButton_DeliveryBoy();
		Assert.assertTrue(manageDeliveryBoy.alertMessageSuccessfullDeliveryBoyCreated(),"New Deliveryboy creation failed");
		
        
	}
	

	@Test(dataProvider = "deliveryBoyAlreadyExistingDetailsExcel", dataProviderClass = DeliveryBoyDataProvider.class)
	public void Verify_AlreadyExistingUsername(String name, String email, String number, String address,
			String username, String password) {

		loginPage = new LoginPage(driver);
		excelUtility=new ExcelUtility();
		excelUtility.setExcelFile("Deliveryboy","Sheet2");
		String expectedusername=username;
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
	    manageDeliveryBoy.AlreadyExistingUsername(name, email, number, address, username, password);
	    String actualusername=manageDeliveryBoy.searchNewlyAddedDeliveryBoyInTableByUserName(expectedusername);
		Assert.assertEquals(actualusername, expectedusername,"Username not found");
		
	}

	@Test(dataProvider = "deliveryBoyAlreadyExistingDetailsExcel", dataProviderClass = DeliveryBoyDataProvider.class)

	public void Verify_SearchForAlreadyExistingDeliveryBoy(String name, String email, String number, String address,
			String username, String password) {

		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		excelUtility=new ExcelUtility();
		excelUtility.setExcelFile("Deliveryboy","Sheet2");
		String expectedusername=username;
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.clickOnSearchButton();
		manageDeliveryBoy.NameOfExistingDeliveryBoy(name);
		manageDeliveryBoy.EmailOfExistingDeliveryBoy(email);
		manageDeliveryBoy.PhonenumberOfExistingDeliveryBoy(number);
		manageDeliveryBoy.searchForExistingDetails();	
		String actualusername = manageDeliveryBoy.getusernameofExistingDeliveryboy();
		Assert.assertEquals(actualusername,expectedusername,"Existing User not found");
	}

	@Test(dataProvider = "nonexistingemailofDeliveryBoyDetails", dataProviderClass = DeliveryBoyDataProvider.class)

	public void verify_ResultforNonExistingDeliveryBoy(String email) {
		loginPage = new LoginPage(driver);
		manageDeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		manageDeliveryBoy.hit_ManageDeliveryBoyLink();
		manageDeliveryBoy.clickOnSearchButton();
		manageDeliveryBoy.ResultforNonExistingDeliveryBoy(email);
		Assert.assertTrue(manageDeliveryBoy.noResultFound());
		
		
		
	}

}
