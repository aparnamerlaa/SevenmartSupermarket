package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

public class AdminUsersDataProvider {
	@DataProvider(name="AdminUsers")
	public Object[][]AdminUsers_Admin()
	{
		return new Object [][] {{"Aparna","Rajesh"}};
}
	@DataProvider(name="StaffUsers")
	public Object[][]AdminUsers_Staff()
	{
		return new Object [][] {{"Rayonn","Rajjeshh"}};
}
	@DataProvider(name="PartnerUsers")
	public Object[][]AdminUsers_Partner()
	{
		return new Object [][] {{"Ronnima","Rajesh"}};
}
	@DataProvider(name="DeliveryBoyUsers")
	public Object[][]AdminUsers_DeliveryBoy()
	{
		return new Object [][] {{"Apghjjjj","Merlaaa"}};
}
}
