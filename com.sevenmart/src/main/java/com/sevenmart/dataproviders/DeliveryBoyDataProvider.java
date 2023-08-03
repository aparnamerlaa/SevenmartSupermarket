package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmart.utilities.ExcelUtility;

public class DeliveryBoyDataProvider {
	ExcelUtility excelutility = new ExcelUtility();

	@DataProvider(name = "DeliveryBoyDetails")
	public Object[][] Delivery_Boy_Details() {
		return new Object[][] { { "Merla", "rayon1s5@gmail.com", "2434525", "Shasff", "ApaRajsh", "Aparsfna1987" } };
	}

	@DataProvider(name = "ExistingDeliveryBoyDetails")
	    public Object[][] Delivery_Boy_DetailsforAlreadyexistingusername() {
		return new Object[][] { { "Merla", "rayon1s5@gmail.com", "2434525", "Shasff", "ApaRajsh", "Aparsfna1987" } };
	}

	@DataProvider(name = "SearchExistingDeliveryBoyDetails")
	    public Object[][] SearchDelivery_Boy_DetailsforAlreadyexistingusername() {
		return new Object[][] { { "Merla", "rayon1s5@gmail.com" } };
	}

	@DataProvider(name = "nonexistingemailofDeliveryBoyDetails")
	    public Object[][] SearchDelivery_Boy_Detailsfornonexistingusername() {
		return new Object[][] { { "sdparnadfg@gmail.com" } };
	}

	@DataProvider(name = "deliveryBoyProfileDetailsExcel")
	    public Object[][] deliveryBoyProfileDetails() {
		excelutility.setExcelFile("TestData", "deliveryBoyProfileDetails");
		Object data[][] = excelutility.getMultiDimensionalData(2, 6);
		return data;
	}
	@DataProvider(name = "SearchExistingDeliveryBoyDetails")
    public Object[][] deliveryBoyProfileDetailsNonExisting() {
	excelutility.setExcelFile("TestData", "deliveryBoyProfileDetails");
	Object data[][] = excelutility.getMultiDimensionalData(2, 6);
	return data;
}

}
