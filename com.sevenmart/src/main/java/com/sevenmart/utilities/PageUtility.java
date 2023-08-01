package com.sevenmart.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Select select;
	Actions actions;
	JavascriptExecutor javascriptexecutor;
	

	public PageUtility(WebDriver driver) {
		this.driver = driver;

	}

	public void select_ByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	public void select_ByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void select_ByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void moveToElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, destination).build().perform();
	}

	public void leftClick(WebElement element) {
		element.click();
	}

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextOfJavaScriptAlert() {
		return driver.switchTo().alert().getText();

	}

	public void switchTo_Window(String WindowID) {
		driver.switchTo().window(WindowID);

	}
	public void scrollAndClickUsingArrowDown(WebElement element) //using robot
	{
		
		try {
			Robot robot=new Robot();
			while(isNotClicked(element))
			 {
				robot.keyPress(KeyEvent.VK_DOWN);//down arrown
				robot.keyRelease(KeyEvent.VK_DOWN);
			 }
			
		} catch (Exception e) {
			
		}
		
	}
	public void javaScriptExecutorClick(WebElement element) {
		javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].click();", element);
	}

	public void javaScriptExecutorScrollToElement(WebElement element) {
		javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void javaScriptScrollandclick(WebElement element) {
		javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollAndClick(WebElement element) {
		int y=0;
		javascriptexecutor=(JavascriptExecutor) driver;
		while(isNotClicked(element))
		{
			javascriptexecutor.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}
	}

	public boolean isNotClicked(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

}
