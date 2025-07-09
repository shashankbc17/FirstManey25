package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ecommerce.util.ElementUtil;

import io.qameta.allure.Step;

import static com.qa.ecommerce.constants.AppConstants.*;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators: OR
	private final By email = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@value='Login']");
	private final By forgotPwdLink = By.linkText("Forgotten Password");
	private final By registerLink = By.linkText("Register");


	// 2. public page constr...
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public page actions/methods
	@Step("getting login page title")
	public String getLoginPageTitle() {
		String title = eleUtil.waitFotTitleIs(LOGIN_PAGE_TITLE, DEFAULT_TIMEOUT);
		System.out.println("login page title: " + title);
		return title;
	}

	@Step("getting login page url")
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(LOGIN_PAGE_FRACTION_URL, DEFAULT_TIMEOUT);
		System.out.println("login page url: " + url);
		return url;
	}

	@Step("checking forgot pwd link exist")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
	}

	
	
	
	
	
}
