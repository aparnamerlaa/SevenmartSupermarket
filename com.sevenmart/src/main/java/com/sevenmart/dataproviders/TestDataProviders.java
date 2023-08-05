package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmart.utilities.ExcelUtility;

public class TestDataProviders {
	ExcelUtility excelutility = new ExcelUtility();
	@DataProvider(name="InvalidCredentials")
	public Object[][]Invalid_Credentials()
	{
		return new Object [][] {{"Aparna","asd"}};
}
	@DataProvider(name = "deliveryBoyProfileDetailsExcel")
    public Object[][] deliveryBoyProfileDetailsinexcel() {
	excelutility.setExcelFile("TestData", "deliveryBoyProfileDetails");
	Object data[][] = excelutility.getMultiDimensionalData(2, 6);
	return data;
	}

	@DataProvider(name = "invalidlogin")
    public Object[][] Invalidlogindetailsinexcel() {
	excelutility.setExcelFile("TestData", "Invalidlogincredential");
	Object data[][] = excelutility.getMultiDimensionalData(1, 1);
	return data;
	}
	@DataProvider(name = "Adminusersdetails")
    public Object[][] Adminuserdetailsinexcel() {
	excelutility.setExcelFile("TestData","adminPage");
	Object data[][] = excelutility.getMultiDimensionalData(1, 2);
	return data;
}
}