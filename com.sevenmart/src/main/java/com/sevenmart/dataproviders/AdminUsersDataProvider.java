package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmart.utilities.ExcelUtility;

public class AdminUsersDataProvider {
	ExcelUtility excelutility=new ExcelUtility();

	@DataProvider(name = "NewAdminCreationFromAdminPage")
	public Object[][] deliveryBoyProfileDetails() {
		excelutility.setExcelFile("AdminUsers", "newAdminUser");
		Object data[][] = excelutility.getMultiDimensionalData(1, 2);
		return data;
	}
	@DataProvider(name = "NewstaffCreationFromAdminPage")
	public Object[][] deliveryBoyProfileDetailsstaff() {
		excelutility.setExcelFile("AdminUsers", "newAdminUser");
		Object data[][] = excelutility.getMultiDimensionalData(2, 2);
		return data;
	}
	@DataProvider(name = "PartnerCreationFromAdminPage")
	public Object[][] PartnerCreation() {
		excelutility.setExcelFile("AdminUsers", "partnerCreation");
		Object data[][] = excelutility.getMultiDimensionalData(2, 2);
		return data;
	}
}