package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasePage extends MainPage{

	public TestCasePage(WebDriver driver) {
		super(driver);
	}
	By loginLink = By.xpath("//a[text()=' Signup / Login']");
	By testCaseLink = By.xpath("//a[text()=' Test Cases']");
	
	public void testCases() {
		driver.findElement(loginLink).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(testCaseLink).click();
		
		// Verify that home page is visible successfully
				String expectedTitle = "Automation Practice Website for UI Testing - Test Cases";
				String actualTitle = "";
				try {
					actualTitle = driver.getTitle();
					Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected Title");
				} catch (NoSuchWindowException e) {
					// Handling the exception
					System.out.println("Caught NoSuchWindowException: " + e.getMessage());
					Assert.fail("Browser window is not available.");
				}
	}
}
