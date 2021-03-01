package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass{
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public WebDriver driver;
	@BeforeTest
	
	public void initializeBrowser() throws IOException
	{
		driver=intializeDriver();
		//driver.get(prop.getProperty("url")); moved this line to below method as we are getting failure as the url is not hitting second time which is the excution with second set of data
	
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException{
		
		//driver=intializeDriver();
		//driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		LandingPage lpage=new LandingPage(driver);//we got null pointer exception before passing ths driver.After passing it,created a constructor with arguments(in LandingPage).
		//lpage.getLogin().click();
		LoginPage loginpageObj=lpage.getLogin();//No need to perform click....part of optimization---instead of creating 2 obj ,provide this click action in getlogin method and return the object. create this login page object in getLogin method and return it
		//LoginPage loginpageObj=new LoginPage(driver);//part of optimization..check LandingPage class method--no need of this line
		loginpageObj.getEmailId().sendKeys(username);//initially it had hard coded value
		loginpageObj.getPassword().sendKeys(password);//initially it had hard coded value
		loginpageObj.getLogin().click();
		System.out.println(text);
		log.info(text);
		ForgotPassword fp=loginpageObj.getForgotPassword();//called this ForgotPassword method and added to an obj
		fp.getEmailId().sendKeys("aaaa");
		fp.sendMeInstructions().click();
	}
	//adding dataProvider
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] dataObj=new Object[2][3]; //2 rows(0 ,1) and 3 columns
		//0th row
		dataObj[0][0]="aaaaa@a.com";
		dataObj[0][1]="pass123";
		dataObj[0][2]="text";
		//1st row		
		dataObj[1][0]="bbbbb@a.com";
		dataObj[1][1]="pass4455";
		dataObj[1][2]="text";
		 return dataObj;
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		
	}
}
