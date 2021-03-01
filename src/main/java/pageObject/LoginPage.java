package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	
	public WebDriver driver;
	By username=By.id("user_email");
	By password=By.xpath("//input[@type='password']");
	By login=By.xpath("//input[@value='Log In']");
	By forgotPassword=By.cssSelector("[href*='password/new']");
	//By forgotPassword=By.linkText("Forgot Password?"); //using linkedText
		
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement getEmailId()
	{
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		// call email ..webelement ...put value
		// call getpassword --> webelemet --> put value
		// find login link --> web elet ..click()
		//return dashborad object
		return driver.findElement(login);
	}
	//optimization --in detail
	public ForgotPassword getForgotPassword() {
		
		driver.findElement(forgotPassword).click();
		ForgotPassword fp=new ForgotPassword(driver);
		return fp;
		//optimized above 2 lines   //**************************************************************
		//return new ForgotPassword(driver);--not working
	}
}