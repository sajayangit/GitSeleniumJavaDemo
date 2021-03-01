package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver intializeDriver() throws IOException {

		// Properties prop=new Properties();//made public to use prop obj in diff class
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Software\\workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vidhya\\Desktop\\Sree_Automation_Study\\drivers\\chromedriver-v88\\chromedriver.exe");
			
			//my old path =C:\\Users\\vidhya\\Documents\\ChromeDriver-07242020\\chromedriver_win32\\chromedriver.exe
			
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\vidhya\\Documents\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			// System.setProperty("WebDriver.chrome.driver",
			// "C:\\Users\\vidhya\\Documents\\chromedriver_win32\\chromedriver.exe");
			// WebDriver driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\" +testCaseName+ ".png";
		FileUtils.copyFile(source, new File(destinationFile));	
		return destinationFile;
		
		
		
	}
}
/*
 * <--Logger name="resources.BaseClass" level="trace"
 * additivity="false"><AppenderRef ref="File"/></Logger>-->
 */
