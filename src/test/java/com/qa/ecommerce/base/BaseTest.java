package com.qa.ecommerce.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.ecommerce.factory.DriverFactory;
import com.qa.ecommerce.pages.LoginPage;

import io.qameta.allure.Description;

//@Listeners(ChainTestListener.class)
public class BaseTest {
	
	WebDriver driver;
	
	DriverFactory df;
	protected Properties prop;
	
	protected LoginPage loginPage;
	
	private static final Logger log = LogManager.getLogger(BaseTest.class);

	
	@Description("init the driver and properties")
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		df = new DriverFactory();
		prop = df.initProp();
		
			//browserName is passed from .xml file
			if(browserName!=null) {
				prop.setProperty("browser", browserName);
			}

		driver = df.initDriver(prop);//login page
		loginPage = new LoginPage(driver);
	}
	
	

	
	
	@AfterMethod //will be running after each @test method
	public void attachScreenshot(ITestResult result) {
		if(!result.isSuccess()) {//only for failure test cases -- true
			log.info("---screenshot is taken---");
			ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
		}
		
		//ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");


	}
	
	
	@Description("closing the browser..")
	@AfterTest
	public void tearDown() {
		driver.quit();
		log.info("----closing the browser----");
	}
	


}
