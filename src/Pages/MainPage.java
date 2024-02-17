package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	WebDriver driver;
	
		By deleteaccount=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

	
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void deleteAccount()
	{
		driver.findElement(deleteaccount).click();
		
		

		boolean usernameDeleted = driver.findElement(deleteaccount).isDisplayed();
		if (usernameDeleted == true) {
			System.out.println("Username Deleted");
		} else {
			System.out.println("Username not Deleted");
		}
	}

}
