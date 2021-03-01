package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseClass;

public class ValidateNavigationBar extends BaseClass{
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	
	public void initializeBrowser() throws IOException
	{
		driver=intializeDriver();
		log.info("Driver is initialized-ValidateNavigationBar");
		driver.get(prop.getProperty("url"));
		log.info("Browser Invoked");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
	
	//driver=intializeDriver();
	//driver.get(prop.getProperty("url"));
	LandingPage lpage=new LandingPage(driver);//we got nullpointer exception before passing ths driver.After passing it,created a constructor with arguments(in LandingPage).
	//lpage.getLogin().click();
	//lpage.getNavigationBar().isDisplayed();
	Assert.assertTrue(lpage.getNavigationBar().isDisplayed());
	log.info("Navigation bar is displayed");

}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}