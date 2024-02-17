package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class LoginPage extends MainPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	Actions action;
	Select select;

	JavascriptExecutor executor = (JavascriptExecutor) driver;
	By username = By.cssSelector("input[name='name']");
	By email = By.cssSelector("input[data-qa='signup-email']");
	By signup = By.cssSelector("button[data-qa='signup-button']");
	By gender = By.cssSelector("input[id='id_gender1']");
	By pass = By.cssSelector("input[id='password']");
	By day = By.cssSelector("select[id='days']");
	By month = By.cssSelector("select[id='months']");
	By year = By.cssSelector("select[id='years']");
	By newsletter = By.cssSelector("input[id='newsletter']");
	By offers = By.cssSelector("input[id='optin']");
	By firstname = By.cssSelector("input[id='first_name']");
	By lastname = By.cssSelector("input[id='last_name']");
	By company = By.cssSelector("input[id='company']");
	By address1 = By.cssSelector("input[id='address1']");
	By address2 = By.cssSelector("input[id='address2']");
	By country = By.cssSelector("select[id='country']");
	By state = By.cssSelector("input[id='state']");
	By city = By.cssSelector("input[id='city']");
	By zipcode = By.cssSelector("input[id='zipcode']");
	By mobilenum = By.cssSelector("input[id='mobile_number']");
	By createaccount = By.cssSelector("button[data-qa='create-account']");
	By accountcreated = By.cssSelector("h2[data-qa='account-created']");
	By cont = By.cssSelector("a[data-qa='continue-button']");
	By loggedinUsername = By.cssSelector("i[class='fa fa-user']");
	By deleteUsername = By.cssSelector("i[class='fa fa-trash-o']");
	By loginEmail = By.cssSelector("input[data-qa='login-email']");
	By loginPass = By.cssSelector("input[data-qa='login-password']");
	By loginButton = By.cssSelector("button[data-qa='login-button']");
	By logOut = By.cssSelector("i[class='fa fa-lock']");
	By loginToAccount = By.cssSelector("div[class='login-form']");
	By errorMsg = By.cssSelector("p[style='color: red;']");
	By errMsg1 = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");

	public void login() {

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

		// Click on 'Signup / Login' button
		driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();

		// Verify 'New User Signup!' is visible
		boolean signUpDisplayed = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		if (signUpDisplayed == true) {
			System.out.println("New User Signup is displayed");
		} else {
			System.out.println("New User Signup is not displayed");
		}
	}

	public void registerUser() {
		driver.findElement(username).sendKeys("sadhanSkulkkkarniii");
		driver.findElement(email).sendKeys("psadhanSkulkk@gmail.com");
		driver.findElement(signup).click();

		action = new Actions(driver);
		action.moveToElement(driver.findElement(gender)).click().build().perform();

		driver.findElement(pass).sendKeys("cear888");

		select = new Select(driver.findElement(day));
		select.selectByVisibleText("11");
		select = new Select(driver.findElement(month));
		select.selectByVisibleText("July");
		select = new Select(driver.findElement(year));
		select.selectByVisibleText("2015");

		action.moveToElement(driver.findElement(newsletter)).click().build().perform();
		action.moveToElement(driver.findElement(offers)).click().build().perform();

		driver.findElement(firstname).sendKeys("Shardh");
		driver.findElement(lastname).sendKeys("Patil");
		driver.findElement(company).sendKeys("ABCD company");

		executor.executeScript("window.scrollBy(0,250)");

		driver.findElement(address1).sendKeys("14,Vinay Nagar");
		driver.findElement(address2).sendKeys("Pune");

		select = new Select(driver.findElement(country));
		select.selectByVisibleText("Canada");

		driver.findElement(state).sendKeys("Maharashtra");
		driver.findElement(city).sendKeys("Mumbai");
		driver.findElement(zipcode).sendKeys("422010");
		driver.findElement(mobilenum).sendKeys("9886360909");

		executor.executeScript("window.scrollBy(0,250)");

		driver.findElement(createaccount).click();

		// Verify that 'ACCOUNT CREATED!' is visible
		boolean accCreated = driver.findElement(accountcreated).isDisplayed();
		if (accCreated == true) {
			System.out.println("Congratulations,Account was created successfully");
			driver.findElement(cont).click();
		} else {
			System.out.println("Account Creation Failed");
		}

		// Verify that 'Logged in as username' is visible
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean usernameVisible = driver.findElement(loggedinUsername).isDisplayed();
		if (usernameVisible == true) {
			System.out.println("Registered Logged in Username is visible");
		} else {
			System.out.println("Loggedin Username is not visible");
		}

		//driver.findElement(logOut).click();
		//System.out.println("TestCase 1 Loggedout successfuly");
	}

	public void loginSucess() {
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise - Account Created";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Test case 2: Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}
		
		// Click on 'Signup / Login' button
				driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();

		// Loginto your Account is visible or not
		boolean loginToAccountDisplayed = driver.findElement(loginToAccount).isDisplayed();
		if (loginToAccountDisplayed == true) {
			System.out.println("Test case 2:Login to your Account is visible");
		} else {
			System.out.println("Test case 2:Login to your Account is not visible");
		}

		driver.findElement(loginEmail).sendKeys("sap8254@gmail.com");
		driver.findElement(loginPass).sendKeys("sap");
		driver.findElement(loginButton).click();
		
		
		System.out.println("TestCase 2 Successful Login");
		driver.findElement(logOut).click();
	}

	public void LoginFailure() {
		
		// Click on 'Signup / Login' button
		driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();
		
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise - Signup / Login";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Test case 3: Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}
		
				
		// Login to your Account is visible or not
		boolean loginToAccountDisplayed = driver.findElement(loginToAccount).isDisplayed();
		if (loginToAccountDisplayed == true) {
			System.out.println("Test case 3:Login to your Account is visible");
		} else {
			System.out.println("Test case 3:Login to your Account is not visible");
		}

		driver.findElement(loginEmail).sendKeys("lmn@gmail.com");
		driver.findElement(loginPass).sendKeys("cear888");
		driver.findElement(loginButton).click();

		// Verify error 'Your email or password is incorrect!' is visible
		WebElement errorMessage = driver.findElement(errorMsg);
		if (errorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + errorMessage.getText());
		} else {
			System.out.println("Error message not displayed: ");
		}
	}

	public void LogoutUser() {
		// Click on 'Signup / Login' button
		driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();
		
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise - Signup / Login";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Test case 4: Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}
		
		

		// Loginto your Account is visible or not
		boolean loginToAccountDisplayed = driver.findElement(loginToAccount).isDisplayed();
		if (loginToAccountDisplayed == true) {
			System.out.println("Test case 4:Login to your Account is visible");
		} else {
			System.out.println("Test case 4:Login to your Account is not visible");
		}

		driver.findElement(loginEmail).sendKeys("Shrp62323@gmail.com");
		driver.findElement(loginPass).sendKeys("cear888");
		driver.findElement(loginButton).click();
		driver.findElement(logOut).click();

		// Verify that login form is displayed again
		boolean loginPageDisplayed = driver.findElement(loginToAccount).isDisplayed();
		if (loginPageDisplayed) {
			System.out.println("User has successfully logged out and navigated to Login page.");
		} else {
			System.out.println("Logout unsuccessful, login page is not Navigatedd.");
		}

	}

	public void RegisterUserExistingEmail() {
		
		// Click on 'Signup / Login' button
		driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();
		
		// Verify that home page is visible successfully
		String expectedTitle = "Automation Exercise - Signup / Login";
		String actualTitle = "";
		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Test case 5: Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}
		
		

		// Loginto your Account is visible or not
		boolean loginToAccountDisplayed = driver.findElement(loginToAccount).isDisplayed();
		if (loginToAccountDisplayed == true) {
			System.out.println("Test case 5:Login to your Account is visible");
		} else {
			System.out.println("Test case 5:Login to your Account is not visible");
		}

		driver.findElement(username).sendKeys("marao");
		driver.findElement(email).sendKeys("ma14@gmail.com");
		driver.findElement(signup).click();

		// Verify error 'Your email or password is incorrect!' is visible
		WebElement errorMessage1 = driver.findElement(errMsg1);
		if (errorMessage1.isDisplayed()) {
			System.out.println("Error message is displayed: " + errorMessage1.getText());
		} else {
			System.out.println("Error message not displayed: ");
		}

	}

}
