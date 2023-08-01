package com.sevenmart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageFactory pagefactory;
	PageUtility pageutility;
	GeneralUtility generalutility;

	int pos = 0;

	@FindBy(xpath = "//li//a//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement adminuserspage;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement clickOnNewButton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username_AdminUsers;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_AdminUsers;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement selectUserType;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	WebElement saveButton;
	

	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private List<WebElement> userNames;
	

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hitAdminUsers() {
		adminUsers.click();
	}

	public String adminUsersPageVerification() {
		generalutility = new GeneralUtility(driver);
		return generalutility.gettextofelement(adminuserspage);

	}

	public void clickOnNewButton() {
		clickOnNewButton.click();
	}

	public void enterUserName(String username) {
		username_AdminUsers.sendKeys(username);

	}

	public void enterPassword(String password) {
		password_AdminUsers.sendKeys(password);
	}

	public void selectStaffUsers() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByVisibleText(selectUserType, "Staff");
		saveButton.submit();
	}

	public void selectAdminUsers() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByVisibleText(selectUserType, "Admin");
		saveButton.submit();
	}

	public void selectPartnerUsers() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByVisibleText(selectUserType, "Partner");
		saveButton.submit();
	}

	public void selectDeliveryBoyUsers() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByVisibleText(selectUserType, "Delivery Boy");
		saveButton.submit();
	}

//	public void clickSaveButton() {
//		saveButton.click();
//	}
//

	

	public void deleteUser(String personName) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		PageUtility pageUtility = new PageUtility(driver);

		List<String> names = new ArrayList<String>();
		
		
		names = generalUtility.gettextofelements(userNames);
		for (pos = 0; pos<names.size(); pos++) {
			if (personName.equals(names.get(pos))) {
				pos++;
				break;
			}
			System.out.println(pos);
		}
			
			WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr["+pos+"]/td[5]/a[3]"));
			pageUtility.scrollAndClick(deleteButton);
		

	}

}
