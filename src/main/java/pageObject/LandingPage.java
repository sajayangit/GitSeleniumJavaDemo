package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signIn = By.cssSelector("a[href*='sign_in']");
	By titleOntheScreen = By.cssSelector(".text-center>h2");
	By navBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");//nav navbar-nav navbar-right

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin() {
		//return driver.findElement(signIn);//part of optimization
		driver.findElement(signIn).click();
		LoginPage loginpageObj=new LoginPage(driver);
		return loginpageObj;//so return type of method changes to LoginPage from WebElement
	}
		
	public WebElement getTitle() {
		return driver.findElement(titleOntheScreen);

	}
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);

	}

}
