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
import resources.BaseClass;


public class ValidateTitle extends BaseClass{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	
	public void initializeBrowser() throws IOException
	{
		driver=intializeDriver();
		log.info("Driver is initialized-Validate Title");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to qaclickacademy home page");
	}
	
	
	@Test
	public void basePageNavigation() throws IOException{
		
		//driver=intializeDriver();//added in @BeforeTest
		//driver.get(prop.getProperty("url"));
		LandingPage lpage=new LandingPage(driver);
		//lpage.getTitle().getText();
		Assert.assertEquals(lpage.getTitle().getText(), "FEATURED COURSES1111");
		log.info("Successfully validated text message");
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
