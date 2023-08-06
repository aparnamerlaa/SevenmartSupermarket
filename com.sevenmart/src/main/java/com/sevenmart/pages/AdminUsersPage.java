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

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class=' nav-link']")
	private WebElement adminUsers;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	private WebElement adminuserspage;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement clickOnNewButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username_AdminUsers;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_AdminUsers;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectUserType;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private List<WebElement> userNames;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	private WebElement newuserName;
	
	
	
	
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

	public void selectUserType(String userType) {
		pageutility = new PageUtility(driver);
		if (userType.equals("Staff")) {
			pageutility.select_ByVisibleText(selectUserType, "Staff");
		} else if (userType.equals("Admin")) {
			pageutility.select_ByVisibleText(selectUserType, "Admin");
		} else if (userType.equals("Partner")) {
			pageutility.select_ByVisibleText(selectUserType, "Partner");
		} else if (userType.equals("Delivery Boy")) {
			pageutility.select_ByVisibleText(selectUserType, "Delivery Boy");
		}

	}

	public void clickSaveButton() {
		saveButton.click();
	}
	public String checkNewAdminUserCreatedOrNot() {
		generalutility = new GeneralUtility(driver);
		return generalutility.gettextofelement(newuserName);

	}


	public void deleteUser(String personName) {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		PageUtility pageUtility = new PageUtility(driver);

		List<String> names = new ArrayList<String>();

		names = generalUtility.gettextofelements(userNames);
		for (pos = 0; pos < names.size(); pos++) {
			if (personName.equals(names.get(pos))) {
				pos++;
				break;
			}
			System.out.println(pos);
		}

		WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr[" + pos + "]/td[5]/a[3]"));
		pageUtility.scrollAndClick(deleteButton);

	}
	

}
