package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends MainPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locator for the main element on home page
	By homePageLocator = By.xpath("//a[text()=' Home']");
	By subscriptionEmail = By.id("susbscribe_email");
	By subscription = By.xpath("//h2[text()='Subscription']");
	By arrowSubmit = By.id("subscribe");
	By sucessSubscribe = By.id("success-subscribe");

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	// Method to check if home page is visible
	public boolean isHomePageVisible() {
		return driver.findElement(homePageLocator).isDisplayed();
	}

	// testcase 10
	public void subscription() {
		driver.findElement(homePageLocator).click();
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		// Scroll down to footer
		jse.executeScript("window.scrollBy(0,250)");

		// Verify text 'SUBSCRIPTION'
		boolean subscriptionDisplayed = driver.findElement(subscription).isDisplayed();
		if (subscriptionDisplayed == true) {
			System.out.println("Subcription is displayed");
		} else {
			System.out.println("Subcription is not displayed");
		}

		// Enter email address in input and click arrow button
		driver.findElement(subscriptionEmail).sendKeys("testing@gmail.com");
		driver.findElement(arrowSubmit).click();

		// Verify success message 'You have been successfully subscribed!' is visible
		WebElement succMsg = driver.findElement(sucessSubscribe);
		if (succMsg.isDisplayed()) {
			System.out.println("The Message displayed : You have been successfully subscribed!");
		} else {
			System.out.println("Subscription Success Message not displayed");
		}
	}

	public void scrollupUsingArrow() throws Exception {
		driver.findElement(homePageLocator).click();
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		// Scroll down page to bottom
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);
		// Verify 'SUBSCRIPTION' is visible
		boolean subscriptionDisplayed = driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
		if (subscriptionDisplayed == true) {
			System.out.println("The SUBSCRIPTION - text is displayed");
		} else {
			System.out.println("The SUBSCRIPTION - text failed to display");
		}
		
		//Click on arrow at bottom right side to move upward
		driver.findElement(By.xpath("//a[@id='scrollUp']")).click();
		
		//Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		Thread.sleep(2000);
		
		boolean practiseTextDisplayed = driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']")).isDisplayed();
		if (practiseTextDisplayed == true) {
			System.out.println("Full-Fledged practice website for Automation Engineers - text is displayed");
		} else {
			System.out.println("Full-Fledged practice website for Automation Engineers - text failed to display");
		}
	}
	
	
	//testcase 26
	public void scrollupWithoutArrow() throws Exception {
		driver.findElement(homePageLocator).click();
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		// Scroll down page to bottom
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);
		// Verify 'SUBSCRIPTION' is visible
		boolean subscriptionDisplayed = driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
		if (subscriptionDisplayed == true) {
			System.out.println("The SUBSCRIPTION - text is displayed");
		} else {
			System.out.println("The SUBSCRIPTION - text failed to display");
		}
		
		//Scroll up page to top
		js.executeScript("window.scrollTo(0, 0);");
		
		//Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		Thread.sleep(2000);
		
		boolean practiseTextDisplayed = driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']")).isDisplayed();
		if (practiseTextDisplayed == true) {
			System.out.println("Full-Fledged practice website for Automation Engineers - text is displayed");
		} else {
			System.out.println("Full-Fledged practice website for Automation Engineers - text failed to display");
		}
	}
	
}
