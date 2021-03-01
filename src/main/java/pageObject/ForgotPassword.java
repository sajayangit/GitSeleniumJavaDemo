package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	By email=By.id("user_email");
	By sendMeInstructions=By.cssSelector("[type='submit']");
	
	
	
	public ForgotPassword(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
		
	public void forgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement getEmailId()
	{
		return driver.findElement(email);
	}
	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendMeInstructions);
	}

	
	
}


