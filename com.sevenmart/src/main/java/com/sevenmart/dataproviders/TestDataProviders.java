package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProviders {
	@DataProvider(name="InvalidCredentials")
	public Object[][]Invalid_Credentials()
	{
		return new Object [][] {{"Aparna","asd"},{"eddifice","ad23"},{"asdas","123"},{"asdd","123"}};
}
	
}