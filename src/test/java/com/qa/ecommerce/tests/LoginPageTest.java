package com.qa.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.ecommerce.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static com.qa.ecommerce.constants.AppConstants.*;

@Feature("F 50: Open Cart - Login Feature")
@Epic("Epic 100: design pages for open cart application")
@Story("US 101: implement login page for open cart application")
public class LoginPageTest extends BaseTest{
	
	@Description("checking open cart login page title...")
	@Severity(SeverityLevel.MINOR)
	@Owner("Naveen")
	@Test(description = "checking login title")
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		ChainTestListener.log("checking login page title: "+ actTitle);
		Assert.assertEquals(actTitle, LOGIN_PAGE_TITLE);
	}
	
	@Description("checking open cart login page url...")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Naveen")
	@Test(description = "checking login page url")
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(LOGIN_PAGE_FRACTION_URL));
	}
	
	@Description("checking open cart login page has forgot pwd link...")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Naveen")
	@Test(description = "forgotPwdLinkExistTest")
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	
	
	@Test(enabled = true, description = "WIP -- forgot pwd check")
	public void forgotPwd() {
		System.out.println("forgot pwd ");
	}
	
	

}
