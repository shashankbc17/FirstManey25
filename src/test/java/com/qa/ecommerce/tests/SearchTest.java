package com.qa.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.ecommerce.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SearchTest extends BaseTest{
	
	@BeforeClass
	public void searchSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("Check search feature test...")
	@Severity(SeverityLevel.MINOR)
	@Owner("Naveen")
	@Test
	public void searchTest() {
		searchResultsPage = accPage.doSearch("macbook");
		int actResultsCount = searchResultsPage.getResultsProductCount();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actResultsCount, 3);
	}
	
	
}
