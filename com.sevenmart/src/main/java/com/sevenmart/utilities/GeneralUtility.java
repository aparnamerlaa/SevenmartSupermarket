package com.sevenmart.utilities;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.github.javafaker.Faker;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	public String gettextofelement(WebElement element) {
		return element.getText();
	}

	public List<String> gettextofelements(String xpath) {
		List<String> data = new ArrayList<String>();
		List<WebElement> element = driver.findElements(By.xpath(xpath));
		for (WebElement itr : element) {
			data.add(itr.getText());

		}
		return data;
	}

	public List<String> gettextofelements(List<WebElement> element) {
		List<String> data = new ArrayList<String>();

		for (WebElement itr : element) {
			data.add(itr.getText());

		}
		return data;
	}

	public String get_Attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String get_CSSValue(WebElement element, String cssValue) {
		return element.getCssValue(cssValue);
	}

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}

	public static String getRandomName() {
		Faker faker = new Faker();

		String firstName = faker.name().firstName();

		return firstName;
	}
	public static String getTimeStamp() {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}
}