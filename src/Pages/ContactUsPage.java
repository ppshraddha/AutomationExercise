package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage extends MainPage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	By loginLink = By.xpath("//a[text()=' Signup / Login']");
	By contactusLink = By.xpath("//a[text()=' Contact us']");
	By homeLink = By.xpath("//a[text()=' Home']");
	By getintouch = By.xpath("//h2[text()='Get In Touch']");
	By contactName = By.xpath("//input[@data-qa='name']");
	By contactEmail = By.xpath("//input[@data-qa='email']");
	By contactSubject = By.xpath("//input[@data-qa='subject']");
	By contactMessage = By.xpath("//textarea[@data-qa='message']");
	By fileupload = By.xpath("//input[@name='upload_file']");
	By submitbutton = By.xpath("//input[@name='submit']");
	By sucessmsg = By.xpath("//div[@class='status alert alert-success']");

	public void contactUs() {
		driver.findElement(loginLink).click();
		
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise - Signup / Login";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}
		// Verify 'GET IN TOUCH' is visible
		driver.findElement(contactusLink).click();
		boolean getInTouch = driver.findElement(getintouch).isDisplayed();
		if (getInTouch == true) {
			System.out.println("ContactUsPage : Get In Touch is displayed");
		} else {
			System.out.println("ContactUsPage : Get In Touch is not displayed");
		}

		driver.findElement(contactName).sendKeys("Shraddha Patil");
		driver.findElement(contactEmail).sendKeys("shrad12@gmial.com");
		driver.findElement(contactSubject).sendKeys("Testing Technology Environment");
		driver.findElement(contactMessage).sendKeys("Knowledge in Testing Environement");
		
		// Specify the file path in the file upload field
		String filepath = "C:\\Users\\ADMIN\\Desktop\\phone.png";
		driver.findElement(fileupload).sendKeys(filepath);
		driver.findElement(submitbutton).click();
		
		Alert a = driver.switchTo().alert();
		a.accept();
		
		//Verify success message 'Success! Your details have been submitted successfully.' is visible
		boolean sucessMsg = driver.findElement(sucessmsg).isDisplayed();
		if (sucessMsg == true) {
			System.out.println("Contact page Message displayed :Success! Your details have been submitted successfully");
		}else {
			System.out.println("Success Message on contact page Failed to display");
		}
		
		driver.findElement(homeLink).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Verify that home page is visible successfully
				String expectedTitle2 = "Automation Exercise";
				String actualTitle2 = "";
				try {
					actualTitle2 = driver.getTitle();
					Assert.assertEquals(actualTitle2, expectedTitle2, "Title does not match the expected Title");
				} catch (NoSuchWindowException e) {
					// Handling the exception
					System.out.println("Caught NoSuchWindowException: " + e.getMessage());
					Assert.fail("Browser window is not available.");
				}
	}

}
