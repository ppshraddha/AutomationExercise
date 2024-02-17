package Pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CartPage extends MainPage {
	LoginPage loginpage;
	private WebDriverWait wait;

	By homeLink = By.xpath("//a[text()=' Home']");
	By cartLink = By.xpath("//a[text()=' Cart']");
	By textSubscription = By.xpath("//h2[text()='Subscription']");
	By subscriptionEmail = By.id("susbscribe_email");
	By arrowSubscribeButton = By.id("subscribe");
	By successSubcribeMessage = By.id("success-subscribe");
	By productSelect1 = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
	By continueShopping = By.xpath("//button[text()='Continue Shopping']");
	By productSelect2 = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[1]/a");
	By viewCartLink = By.xpath("//a[@href='/view_cart']");
	By shoppingCartText = By.xpath("//li[text()='Shopping Cart']");
	By viewfirstproduct = By.xpath("//a[@href='/product_details/1']");
	By quantity = By.id("quantity");
	By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");
	// By viewCartButton = By.xpath("//u[text()='View Cart']");
	By viewCartButton = By.xpath("//a[@href='/view_cart']");
	By disabledqty = By.xpath("//button[@class='disabled']");
	By disabledQty1 = By.xpath("//*[@id=\"product-1\"]/td[4]/button");
	By disabledQty2 = By.xpath("//*[@id=\"product-2\"]/td[4]/button");
	By loggedinUsername = By.cssSelector("//*[text()=' Logged in as ']");
	By deleteUsername = By.cssSelector("i[class='fa fa-trash-o']");
	By loginEmail = By.cssSelector("input[data-qa='login-email']");
	By loginPass = By.cssSelector("input[data-qa='login-password']");
	By loginButton = By.cssSelector("button[data-qa='login-button']");
	By logOut = By.cssSelector("i[class='fa fa-lock']");
	By signUp = By.xpath("//*[text()=' Signup / Login']");
	By product1Name = By.xpath("//a[@href='/product_details/1']");
	By product2Name = By.xpath("//a[@href='/product_details/2']");
	By allProducts = By.xpath("//*[@class='title text-center']");

	By item1 = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
	By viewitem1 = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
	By proceedToCheckoutButton = By.xpath("//a[text()='Proceed To Checkout']");
	By registerLogin = By.xpath("//u[text()='Register / Login']");
	By messageText = By.xpath("//*[@name=\"message\"]");
	By placeOrderButton = By.xpath("//*[@class=\"btn btn-default check_out\"]");
	By deleteaccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	By crossMarkDeleteItem = By.xpath("//*[@class='fa fa-times']");
	By modalContent = By.xpath("//div[@class='modal-content']");
	By searchIcon = By.xpath("//button[@id='submit_search']");

	By productlink = By.xpath("//a[text()=' Products']");

	public CartPage(WebDriver driver) {
		super(driver);

	}

	public void cartSubscription() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		JavascriptExecutor executor = (JavascriptExecutor) driver;

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

		// Click 'Cart' button
		driver.findElement(cartLink).click();

		// Scroll down 
		jse.executeScript("window.scrollBy(0,250)");

		// Verify text 'SUBSCRIPTION'
		boolean textSubscriptionDisplayed = driver.findElement(textSubscription).isDisplayed();
		if (textSubscriptionDisplayed == true) {
			System.out.println("The Text Subscription is Displayed");
		} else {
			System.out.println("The Text Subscription is not Displayed");
		}

		// Enter email address in input and click arrow button
		driver.findElement(subscriptionEmail).sendKeys("cartsubscription@gmail.com");
		driver.findElement(arrowSubscribeButton).click();

		// Verify success message 'You have been successfully subscribed!' is visible
		WebElement successMsg = driver.findElement(successSubcribeMessage);
		if (successMsg.isDisplayed()) {
			System.out.println("CartPage Subscribe Message: You have been successfully subscribed! is displayed");
		} else {
			System.out.println("CartPage Subscribe Message is not displayed");
		}

	}

	// Testcase 12
	public void addToCart() {

		// driver.findElement(homeLink).click();
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click 'Products' button
		driver.findElement(productlink).click();

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("window.scrollBy(0,250)");

		// Hover over first product and click 'Add to cart'
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement product1Element =
		// wait.until(ExpectedConditions.elementToBeClickable(productSelect1));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// product1Element.click();
		driver.findElement(productSelect1).click();

		// Click 'Continue Shopping' button
		driver.findElement(continueShopping).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Hover over second product and click 'Add to cart'
		boolean product2Displayed = driver.findElement(productSelect2).isDisplayed();

		driver.findElement(productSelect2).click();

		// Click 'View Cart' button
		driver.findElement(viewCartLink).click();

		// start the process of Verifying both products are added to the cart

		// getting the expected product names
		String expectedProduct1Name = "Blue Top";
		String expectedProduct2Name = "Men Tshirt";

		// Getting the actual product names from the web elements
		String actualProduct1Name = driver.findElement(By.xpath("//*[@href='/product_details/1']")).getText();
		String actualProduct2Name = driver.findElement(By.xpath("//*[@href='/product_details/2']")).getText();
		Assert.assertEquals(actualProduct1Name, expectedProduct1Name,
				"Actual Product 1 does not matches with Expected Product1");
		Assert.assertEquals(actualProduct2Name, expectedProduct2Name,
				"Actual Product 2 does not matches with Expected Product2");

		// Verify their prices, quantity and total price - of Product 1
		String ExpectedProduct1Price = "Rs. 500";
		String ActualProduct1Price = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p")).getText();
		Assert.assertEquals(ActualProduct1Price, ExpectedProduct1Price,
				"Actual Product1 Price does not matches with Expected Product1 Price");

		String ExpectedProduct1Qty = "1";
		String ActualProduct1Qty = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button")).getText();
		Assert.assertEquals(ActualProduct1Qty, ExpectedProduct1Qty,
				"Actual Product1 Quantity does not matches with Expected Product1 Quantity");

		// Convert strings to numeric types (assuming amount is in integer or double)
		int amount = Integer.parseInt(ExpectedProduct1Price.replaceAll("[^0-9]", ""));
		int qty = Integer.parseInt(ExpectedProduct1Qty);

		// Multiply the values
		int total = amount * qty;

		// Convert the result back to a string
		String expectedTotalAmount = "Rs. " + total;
		String actualTotalAmount = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p")).getText();
		Assert.assertEquals(actualTotalAmount, expectedTotalAmount,
				"Actual Total of Product 1 does not matches with Expected Total");

		// Verify their prices, quantity and total price - of Product 2
		String ExpectedProduct2Price = "Rs. 400";
		String ActualProduct2Price = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]/p")).getText();
		Assert.assertEquals(ActualProduct2Price, ExpectedProduct2Price,
				"Actual Product2 Price does not matches with Expected Product2 Price");

		String ExpectedProduct2Qty = "1";
		String ActualProduct2Qty = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[4]/button")).getText();
		Assert.assertEquals(ActualProduct2Qty, ExpectedProduct2Qty,
				"Actual Product2 Quantity does not matches with Expected Product2 Quantity");

		// Convert strings to numeric types (assuming amount is in integer or double)
		int amount1 = Integer.parseInt(ExpectedProduct1Price.replaceAll("[^0-9]", ""));
		int qty1 = Integer.parseInt(ExpectedProduct1Qty);

		// Multiply the values
		int total1 = amount1 * qty1;

		// Convert the result back to a string
		String expectedTotalAmount1 = "Rs. " + total1;
		String actualTotalAmount1 = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[5]/p")).getText();
		Assert.assertEquals(actualTotalAmount, expectedTotalAmount,
				"Actual Total of Product 2does not matches with Expected Total");

	}

	// Testcase 13
	public void viewProductQuantity() throws Exception {

		// driver.findElement(homeLink).click();
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
		// Click 'View Product' for any product on home page
		driver.findElement(viewfirstproduct).click();

		// Verify product detail is opened

		String expectedTitle2 = "Automation Exercise - Product Details";
		String actualTitle2 = "";
		try {
			actualTitle2 = driver.getTitle();
			Assert.assertEquals(actualTitle2, expectedTitle2, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		// Increase quantity to 4
		driver.findElement(quantity).click();
		driver.findElement(quantity).clear();
		Thread.sleep(1000);
		driver.findElement(quantity).sendKeys("4");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click 'Add to cart' button
		driver.findElement(addToCartButton).click();

		// Click 'View Cart' button
		driver.findElement(viewCartButton).click();

		// Verify that product is displayed in cart page with exact quantity
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedQty = "4";
		// WebElement actualQty = driver.findElement(disabledqty);

		String actualQty = driver.findElement(disabledqty).getText();
		if (actualQty.equals(expectedQty)) {
			System.out.println("Actual Qty matches with Expected Quantity");
		} else {
			System.out.println("Actual Qty does not matches with Expected Quantity");
		}
	}

	// Testcase 14
	public void placeOrder() {
		driver.findElement(homeLink).click();
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

		// Add products to cart
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(item1).click();
		// Click 'Cart' button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(viewitem1).click();

		// Verify that cart page is displayed
		boolean cartPageText = driver.findElement(shoppingCartText).isDisplayed();
		if (cartPageText == true) {
			System.out.println("Cart Page is displayed");
		} else {
			System.out.println("Cart Page is not displayed");
		}

		// Click Proceed To Checkout
		driver.findElement(proceedToCheckoutButton).click();

		// Click 'Register / Login' button
		driver.findElement(registerLogin).click();

		loginpage = new LoginPage(driver);
		loginpage.registerUser();

		// Click 'Cart' button
		driver.findElement(cartLink).click();

		// Click 'Proceed To Checkout' button
		driver.findElement(proceedToCheckoutButton).click();

		// Verify Address Details and Review Your Order

		String expectedfirstName = "Mr. Shardh";
		String expectedLastName = "Patil";
		String FullName = expectedfirstName + " " + expectedLastName;
		String actualFullName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
		Assert.assertEquals(actualFullName, FullName, "Actual Name does not matches with Expected Name");

		String expectedCompany = "ABCD company";
		String actualCompany = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]")).getText();
		Assert.assertEquals(actualCompany, expectedCompany, "Actual Company does not matches with Expected company");

		String expectedAddress1 = "14,Vinay Nagar";
		String actualAddress1 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
		Assert.assertEquals(actualAddress1, expectedAddress1, "Actual Address does not matches with Expected address");

		String expectedAddress2 = "Pune";
		String actualAddress2 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText();
		Assert.assertEquals(actualAddress2, expectedAddress2, "Actual City does not matches with Expected City");

		String expectedCity = "Mumbai";
		String expectedState = "Maharashtra";
		String expectedZipcode = "422010";
		// String expectedaddress = expectedCity + ", " + expectedState + ", " +
		// expectedZipcode;

		String address = expectedCity + " " + expectedState + " " + expectedZipcode;
		String expectedAddress = address.replace(",", "");
		String actualAddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText();
		Assert.assertEquals(actualAddress, expectedAddress,
				"Actual City,State and ZipCode does not matches with Expected City,State and Zipcode");

		String expectedCountry = "Canada";
		String actualCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]")).getText();
		Assert.assertEquals(actualCountry, expectedCountry, "Actual Country does not matches with Expected Country");

		String expectedMobileNumber = "9886360909";
		String actualMobileNumber = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]")).getText();
		Assert.assertEquals(actualMobileNumber, expectedMobileNumber,
				"Actual Mobile Number does not matches with Expected Mobile Number");

		// String expectedQty = "4";
		// String actualQty = driver.findElement(disabledqty).getText();
		// Assert.assertEquals(actualQty, expectedQty, "Actual Qty does not match with
		// Expected Quantity");
		// System.out.println("Actual Qty matches with Expected Quantity");

		String expectedItem = "Blue Top";
		String actualItem = driver.findElement(By.xpath("//a[text()='Blue Top']")).getText();
		Assert.assertEquals(actualItem, expectedItem,
				"Actual Product Name does not matches with Expected Product Name");

		String expectedAmount = "Rs. 500";
		String actualAmount = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p")).getText();
		Assert.assertEquals(actualAmount, expectedAmount, "Actual Price does not matches with Expected Price");

		String ExpectedQty = "1";
		String actualQty = driver.findElement(By.xpath("//*[@class='disabled']")).getText();
		Assert.assertEquals(actualQty, ExpectedQty, "Actual Quantity does not matches with Expected Quantity");

		// Convert strings to numeric types (assuming amount is in integer or double)
		int amount = Integer.parseInt(expectedAmount.replaceAll("[^0-9]", ""));
		int qty = Integer.parseInt(ExpectedQty);

		// Multiply the values
		int total = amount * qty;

		// Convert the result back to a string
		String expectedTotalAmount = "Rs. " + total;
		String actualTotalAmount = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p")).getText();
		Assert.assertEquals(actualTotalAmount, expectedTotalAmount,
				"Actual Total does not matches with Expected Total");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter description in comment text area and click 'Place Order'
		driver.findElement(messageText).sendKeys("Learning Selenium");
		driver.findElement(placeOrderButton).click();

		// Enter payment details: Name on Card, Card Number, CVC, Expiration date
		driver.findElement(By.xpath("//*[@name=\"name_on_card\"]")).sendKeys("Shraddha P Patil");
		driver.findElement(By.xpath("//*[@name=\"card_number\"]")).sendKeys("876 765 654 543");
		driver.findElement(By.xpath("//*[@name=\"cvc\"]")).sendKeys("111");
		driver.findElement(By.xpath("//*[@name=\"expiry_month\"]")).sendKeys("Jun");
		driver.findElement(By.xpath("//*[@name=\"expiry_year\"]")).sendKeys("2025");

		// Click 'Pay and Confirm Order' button
		driver.findElement(By.xpath("//*[@data-qa=\"pay-button\"]")).click();

		// Verify success message 'Your order has been placed successfully!'
		boolean orderPlacedDisplayed = driver
				.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).isDisplayed();
		if (orderPlacedDisplayed == true) {
			System.out.println("The Message displayed : Congratulations! Your order has been confirmed!");
		} else {
			System.out.println("Order Placed Message was not displayed");
		}

		By deleteaccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

		// Click 'Delete Account' button
		driver.findElement(deleteaccount).click();

		// Verify 'ACCOUNT DELETED!' and click 'Continue' button
		By accountDeleteText = By.xpath("//*[text()='Account Deleted!']");
		Boolean accountDeleteDisplayed = driver.findElement(accountDeleteText).isDisplayed();
		if (accountDeleteDisplayed == true) {
			System.out.println("ACCOUNT DELETED Message was displayed");
		} else {
			System.out.println("ACCOUNT DELETED Message not displayed");
		}

	}

	// TestCase15
	public void placeOrderRegisterBeforeCheckout() {
		// Add products to cart
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(item1).click();
		// Click 'Cart' button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(viewitem1).click();

		// Verify that cart page is displayed
		boolean cartPageText = driver.findElement(shoppingCartText).isDisplayed();
		if (cartPageText == true) {
			System.out.println("Cart Page is displayed");
		} else {
			System.out.println("Cart Page is not displayed");
		}

		// Click Proceed To Checkout
		driver.findElement(proceedToCheckoutButton).click();

		// Verify Address Details and Review Your Order

		String expectedfirstName = "Mr. Shardh";
		String expectedLastName = "Patil";
		String FullName = expectedfirstName + " " + expectedLastName;
		String actualFullName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
		Assert.assertEquals(actualFullName, FullName, "Actual Name does not matches with Expected Name");

		String expectedCompany = "ABCD company";
		String actualCompany = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]")).getText();
		Assert.assertEquals(actualCompany, expectedCompany, "Actual Company does not matches with Expected company");

		String expectedAddress1 = "14,Vinay Nagar";
		String actualAddress1 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
		Assert.assertEquals(actualAddress1, expectedAddress1, "Actual Address does not matches with Expected address");

		String expectedAddress2 = "Pune";
		String actualAddress2 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText();
		Assert.assertEquals(actualAddress2, expectedAddress2, "Actual City does not matches with Expected City");

		String expectedCity = "Mumbai";
		String expectedState = "Maharashtra";
		String expectedZipcode = "422010";
		// String expectedaddress = expectedCity + ", " + expectedState + ", " +
		// expectedZipcode;

		String address = expectedCity + " " + expectedState + " " + expectedZipcode;
		String expectedAddress = address.replace(",", "");
		String actualAddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText();
		Assert.assertEquals(actualAddress, expectedAddress,
				"Actual City,State and ZipCode does not matches with Expected City,State and Zipcode");

		String expectedCountry = "Canada";
		String actualCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]")).getText();
		Assert.assertEquals(actualCountry, expectedCountry, "Actual Country does not matches with Expected Country");

		String expectedMobileNumber = "9886360909";
		String actualMobileNumber = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]")).getText();
		Assert.assertEquals(actualMobileNumber, expectedMobileNumber,
				"Actual Mobile Number does not matches with Expected Mobile Number");

		// String expectedQty = "4";
		// String actualQty = driver.findElement(disabledqty).getText();
		// Assert.assertEquals(actualQty, expectedQty, "Actual Qty does not match with
		// Expected Quantity");
		// System.out.println("Actual Qty matches with Expected Quantity");

		String expectedItem = "Blue Top";
		String actualItem = driver.findElement(By.xpath("//a[text()='Blue Top']")).getText();
		Assert.assertEquals(actualItem, expectedItem,
				"Actual Product Name does not matches with Expected Product Name");

		String expectedAmount = "Rs. 500";
		String actualAmount = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p")).getText();
		Assert.assertEquals(actualAmount, expectedAmount, "Actual Price does not matches with Expected Price");

		String ExpectedQty = "1";
		String actualQty = driver.findElement(By.xpath("//*[@class='disabled']")).getText();
		Assert.assertEquals(actualQty, ExpectedQty, "Actual Quantity does not matches with Expected Quantity");

		// Convert strings to numeric types (assuming amount is in integer or double)
		int amount = Integer.parseInt(expectedAmount.replaceAll("[^0-9]", ""));
		int qty = Integer.parseInt(ExpectedQty);

		// Multiply the values
		int total = amount * qty;

		// Convert the result back to a string
		String expectedTotalAmount = "Rs. " + total;
		String actualTotalAmount = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p")).getText();
		Assert.assertEquals(actualTotalAmount, expectedTotalAmount,
				"Actual Total does not matches with Expected Total");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter description in comment text area and click 'Place Order'
		driver.findElement(messageText).sendKeys("Learning Selenium");
		driver.findElement(placeOrderButton).click();

		// Enter payment details: Name on Card, Card Number, CVC, Expiration date
		driver.findElement(By.xpath("//*[@name=\"name_on_card\"]")).sendKeys("Shraddha P Patil");
		driver.findElement(By.xpath("//*[@name=\"card_number\"]")).sendKeys("876 765 654 543");
		driver.findElement(By.xpath("//*[@name=\"cvc\"]")).sendKeys("111");
		driver.findElement(By.xpath("//*[@name=\"expiry_month\"]")).sendKeys("Jun");
		driver.findElement(By.xpath("//*[@name=\"expiry_year\"]")).sendKeys("2025");

		// Click 'Pay and Confirm Order' button
		driver.findElement(By.xpath("//*[@data-qa=\"pay-button\"]")).click();

		// Verify success message 'Your order has been placed successfully!'
		boolean orderPlacedDisplayed = driver
				.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).isDisplayed();
		if (orderPlacedDisplayed == true) {
			System.out.println("The Message displayed : Congratulations! Your order has been confirmed!");
		} else {
			System.out.println("Order Placed Message was not displayed");
		}

		By deleteaccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

		// Click 'Delete Account' button
		driver.findElement(deleteaccount).click();

		// Verify 'ACCOUNT DELETED!' and click 'Continue' button
		By accountDeleteText = By.xpath("//*[text()='Account Deleted!']");
		Boolean accountDeleteDisplayed = driver.findElement(accountDeleteText).isDisplayed();
		if (accountDeleteDisplayed == true) {
			System.out.println("ACCOUNT DELETED Message was displayed");
		} else {
			System.out.println("ACCOUNT DELETED Message not displayed");
		}
	}

	public void placeOrderLoginBeforeCheckout() {

		driver.findElement(loginEmail).sendKeys("sadhanakulk@gmail.com");
		driver.findElement(loginPass).sendKeys("cear888");
		driver.findElement(loginButton).click();
		// driver.findElement(logOut).click();

		placeOrderRegisterBeforeCheckout();
	}

	public void removeProductsFromCart() {
		driver.findElement(homeLink).click();
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

		// Add products to cart
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(item1).click();
		// Click 'Cart' button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(viewitem1).click();

		// Verify that cart page is displayed
		boolean cartPageText = driver.findElement(shoppingCartText).isDisplayed();
		if (cartPageText == true) {
			System.out.println("Cart Page is displayed");
		} else {
			System.out.println("Cart Page is not displayed");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click 'X' button corresponding to particular product
		driver.findElement(crossMarkDeleteItem).click();

		// Verify that product is removed from the cart
		boolean isProductRemoved = true;

		try {
			driver.findElement(item1);
			isProductRemoved = false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// NoSuchElementException will be thrown if the element is not found, indicating
			// successful removal
			isProductRemoved = true;
		}
		if (isProductRemoved) {
			System.out.println("Product is successfully removed from the cart");
		} else {
			System.out.println("Product is not removed from the cart");
		}

	}

	// Testcase 20
	public void searchProductsverifyCartAfterLogin() throws Exception {
		// Click on 'Products' button
		driver.findElement(productlink).click();

		// Verify user is navigated to ALL PRODUCTS page successfully
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));

		// Perform the search
		String searchKeyword = "top";
		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']")));
		searchInput.sendKeys(searchKeyword);
		driver.findElement(searchIcon).click();

		// Wait for the product containers
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='productinfo text-center']")));

		// Retrieving all product elements
		List<WebElement> productContainers = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));

		// Use soft assertions
		SoftAssert softAssert = new SoftAssert();

		int topsAddedToCart = 0;

		for (WebElement container : productContainers) {
			// Finding the product name element within the container
			WebElement productNameElement = container.findElement(By.tagName("p"));

			// Extracting the text of the product name element
			String productName = productNameElement.getText();

			// Checking if the product name contains "top"
			if (productName.toLowerCase().contains(searchKeyword)) {

				topsAddedToCart++;

				// Locate the "Add to Cart" button within the container
				WebElement addToCartButton = container.findElement(By.tagName("a"));

				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				// Click on the "Add to Cart" button
				addToCartButton.click();

				// Use soft assertion for products that contain the word 'top'
				softAssert.assertTrue(true, "Product '" + productName + "' contains the word 'top' and added to cart");

				driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

				Thread.sleep(1000);
			} else {
				// Log a warning for products that do not contain the word 'top'
				System.out.println("Warning: Product '" + productName + "' does not contain the word 'top'");
			}
		}
		// Perform soft assertion
		softAssert.assertAll();
		driver.findElement(cartLink).click();

		// Printing the number of "tops" added to the cart
		System.out.println("Number of 'tops' added to the cart: " + topsAddedToCart);

		// Waiting for the product containers in the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart_info']")));

		// Retrieving all the product elements listed in the cart
		List<WebElement> cartProductElements = driver.findElements(By.xpath("//*[@class='cart_product']"));

		// Compare the counts of products added to the cart and products present in the
		// cart page
		int productsInCartPage = cartProductElements.size();
		System.out.println("Tops in the cart :" + productsInCartPage);
		if (topsAddedToCart == productsInCartPage) {
			System.out.println(
					"Number of 'tops' added to the cart is equal to the number of items present in the cart page.");
		} else {
			System.out.println(
					"Number of 'tops' added to the cart is not equal to the number of items present in the cart page.");
		}
		// Click 'Signup / Login' button and submit login details
		driver.findElement(signUp).click();
		driver.findElement(loginEmail).sendKeys("sap8254@gmail.com");
		driver.findElement(loginPass).sendKeys("sap");
		driver.findElement(loginButton).click();

		// Again, go to Cart page
		driver.findElement(cartLink).click();

		// Verify that those products are visible in cart after login as well
		// Wait for the product containers in the cart after login
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart_info']")));

		// Retrieving all the product elements listed in the cart after login
		List<WebElement> cartProductElementsAfterLogin = driver.findElements(By.xpath("//*[@class='cart_product']"));

		// Compare the counts of products added to the cart before and after login
		int productsInCartPageAfterLogin = cartProductElementsAfterLogin.size();

		System.out.println("Tops in the cart after login: " + productsInCartPageAfterLogin);

		if (topsAddedToCart == productsInCartPageAfterLogin) {
			System.out.println(
					"Number of 'tops' added to the cart is equal to the number of items present in the cart page after login.");
		} else {
			System.out.println(
					"Number of 'tops' added to the cart is not equal to the number of items present in the cart page after login.");
		}

	}

	public void verifyAddressDetailsInCheckoutPage() {
		driver.findElement(homeLink).click();
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

		// Click 'Register / Login' button
		driver.findElement(signUp).click();

		loginpage = new LoginPage(driver);
		loginpage.registerUser();
		
		//click on product
		driver.findElement(productlink).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

		// Add products to cart
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(item1).click();
		
		// Click 'Cart' button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(viewitem1).click();

		// Verify that cart page is displayed
		boolean cartPageText = driver.findElement(shoppingCartText).isDisplayed();
		if (cartPageText == true) {
			System.out.println("Cart Page is displayed");
		} else {
			System.out.println("Cart Page is not displayed");
		}

		// Click Proceed To Checkout
		driver.findElement(proceedToCheckoutButton).click();

		// Verify Delivery Address Details and Review Your Order

		String expectedfirstName = "Mr. Shardh";
		String expectedLastName = "Patil";
		String FullName = expectedfirstName + " " + expectedLastName;
		String actualFullName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
		Assert.assertEquals(actualFullName, FullName, "Delivery Address Details: Actual Name does not matches with Expected Name");

		String expectedCompany = "ABCD company";
		String actualCompany = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]")).getText();
		Assert.assertEquals(actualCompany, expectedCompany, "Delivery Address Details: Actual Company does not matches with Expected company");

		String expectedAddress1 = "14,Vinay Nagar";
		String actualAddress1 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
		Assert.assertEquals(actualAddress1, expectedAddress1, "Delivery Address Details: Actual Address does not matches with Expected address");

		String expectedAddress2 = "Pune";
		String actualAddress2 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText();
		Assert.assertEquals(actualAddress2, expectedAddress2, "Delivery Address Details: Actual City does not matches with Expected City");

		String expectedCity = "Mumbai";
		String expectedState = "Maharashtra";
		String expectedZipcode = "422010";
		// String expectedaddress = expectedCity + ", " + expectedState + ", " +
		// expectedZipcode;

		String address = expectedCity + " " + expectedState + " " + expectedZipcode;
		String expectedAddress = address.replace(",", "");
		String actualAddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText();
		Assert.assertEquals(actualAddress, expectedAddress,
				"Delivery Address Details: Actual City,State and ZipCode does not matches with Expected City,State and Zipcode");

		String expectedCountry = "Canada";
		String actualCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]")).getText();
		Assert.assertEquals(actualCountry, expectedCountry, "Delivery Address Details: Actual Country does not matches with Expected Country");

		String expectedMobileNumber = "9886360909";
		String actualMobileNumber = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]")).getText();
		Assert.assertEquals(actualMobileNumber, expectedMobileNumber,
				"Delivery Address Details: Actual Mobile Number does not matches with Expected Mobile Number");

		//Verify Billing Address
		
		String expectedBillingfirstName = "Mr. Shardh";
		String expectedBillingLastName = "Patil";
		String BillingFullName = expectedfirstName + " " + expectedLastName;
		String actualBillingFullName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
		Assert.assertEquals(actualBillingFullName, BillingFullName, "Billing Address Details: Actual Name does not matches with Expected Name");

		String expectedBillingCompany = "ABCD company";
		String actualBillingCompany = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]")).getText();
		Assert.assertEquals(actualBillingCompany, expectedBillingCompany, "Billing Address Details: Actual Company does not matches with Expected company");

		String expectedBillingAddress1 = "14,Vinay Nagar";
		String actualBillingAddress1 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
		Assert.assertEquals(actualBillingAddress1, expectedBillingAddress1, "Billing Address Details: Actual Address does not matches with Expected address");

		String expectedBillingAddress2 = "Pune";
		String actualBillingAddress2 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText();
		Assert.assertEquals(actualBillingAddress2, expectedBillingAddress2, "Billing Address Details: Actual City does not matches with Expected City");

		String expectedBillingCity = "Mumbai";
		String expectedBillingState = "Maharashtra";
		String expectedBillingZipcode = "422010";
		// String expectedaddress = expectedCity + ", " + expectedState + ", " +
		// expectedZipcode;

		String Billingaddress = expectedBillingCity + " " + expectedBillingState + " " + expectedBillingZipcode;
		String expectedBillingAddress = address.replace(",", "");
		String actualBillingAddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText();
		Assert.assertEquals(actualBillingAddress, expectedBillingAddress,"Billing Address Details: Actual City,State and ZipCode does not matches with Expected City,State and Zipcode");

		String expectedBillingCountry = "Canada";
		String actualBillingCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]")).getText();
		Assert.assertEquals(actualCountry, expectedCountry, "Billing Address Details: Actual Country does not matches with Expected Country");

		String expectedBillingMobileNumber = "9886360909";
		String actualBillingMobileNumber = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]")).getText();
		Assert.assertEquals(actualMobileNumber, expectedMobileNumber,
				"Billing Address Details: Actual Mobile Number does not matches with Expected Mobile Number");
		
		// Click 'Delete Account' button	
		By deleteaccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

		// Click 'Delete Account' button
		driver.findElement(deleteaccount).click();

		// Verify 'ACCOUNT DELETED!' and click 'Continue' button
		By accountDeleteText = By.xpath("//*[text()='Account Deleted!']");
		Boolean accountDeleteDisplayed = driver.findElement(accountDeleteText).isDisplayed();
		if (accountDeleteDisplayed == true) {
			System.out.println("ACCOUNT DELETED Message was displayed");
		} else {
			System.out.println("ACCOUNT DELETED Message not displayed");
		}

	}
	
	
	
	//TestCase 24
	public void downloadInvoiceAfterPuchaseOrder() throws Exception, Exception {
		driver.findElement(homeLink).click();
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

		// Add products to cart
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(item1).click();
		// Click 'Cart' button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(viewitem1).click();

		// Verify that cart page is displayed
		boolean cartPageText = driver.findElement(shoppingCartText).isDisplayed();
		if (cartPageText == true) {
			System.out.println("Cart Page is displayed");
		} else {
			System.out.println("Cart Page is not displayed");
		}

		// Click Proceed To Checkout
		driver.findElement(proceedToCheckoutButton).click();

		// Click 'Register / Login' button
		driver.findElement(registerLogin).click();

		loginpage = new LoginPage(driver);
		loginpage.registerUser();

		// Click 'Cart' button
		driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

		// Click 'Proceed To Checkout' button
		driver.findElement(proceedToCheckoutButton).click();

		// Verify Address Details and Review Your Order

		String expectedfirstName = "Mr. Shardh";
		String expectedLastName = "Patil";
		String FullName = expectedfirstName + " " + expectedLastName;
		String actualFullName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
		Assert.assertEquals(actualFullName, FullName, "Actual Name does not matches with Expected Name");

		String expectedCompany = "ABCD company";
		String actualCompany = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]")).getText();
		Assert.assertEquals(actualCompany, expectedCompany, "Actual Company does not matches with Expected company");

		String expectedAddress1 = "14,Vinay Nagar";
		String actualAddress1 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
		Assert.assertEquals(actualAddress1, expectedAddress1, "Actual Address does not matches with Expected address");

		String expectedAddress2 = "Pune";
		String actualAddress2 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText();
		Assert.assertEquals(actualAddress2, expectedAddress2, "Actual City does not matches with Expected City");

		String expectedCity = "Mumbai";
		String expectedState = "Maharashtra";
		String expectedZipcode = "422010";
		// String expectedaddress = expectedCity + ", " + expectedState + ", " +
		// expectedZipcode;

		String address = expectedCity + " " + expectedState + " " + expectedZipcode;
		String expectedAddress = address.replace(",", "");
		String actualAddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText();
		Assert.assertEquals(actualAddress, expectedAddress,
				"Actual City,State and ZipCode does not matches with Expected City,State and Zipcode");

		String expectedCountry = "Canada";
		String actualCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]")).getText();
		Assert.assertEquals(actualCountry, expectedCountry, "Actual Country does not matches with Expected Country");

		String expectedMobileNumber = "9886360909";
		String actualMobileNumber = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]")).getText();
		Assert.assertEquals(actualMobileNumber, expectedMobileNumber,
				"Actual Mobile Number does not matches with Expected Mobile Number");

		// String expectedQty = "4";
		// String actualQty = driver.findElement(disabledqty).getText();
		// Assert.assertEquals(actualQty, expectedQty, "Actual Qty does not match with
		// Expected Quantity");
		// System.out.println("Actual Qty matches with Expected Quantity");

		String expectedItem = "Blue Top";
		String actualItem = driver.findElement(By.xpath("//a[text()='Blue Top']")).getText();
		Assert.assertEquals(actualItem, expectedItem,
				"Actual Product Name does not matches with Expected Product Name");

		String expectedAmount = "Rs. 500";
		String actualAmount = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p")).getText();
		Assert.assertEquals(actualAmount, expectedAmount, "Actual Price does not matches with Expected Price");

		String ExpectedQty = "1";
		String actualQty = driver.findElement(By.xpath("//*[@class='disabled']")).getText();
		Assert.assertEquals(actualQty, ExpectedQty, "Actual Quantity does not matches with Expected Quantity");

		// Convert strings to numeric types (assuming amount is in integer or double)
		int amount = Integer.parseInt(expectedAmount.replaceAll("[^0-9]", ""));
		int qty = Integer.parseInt(ExpectedQty);

		// Multiply the values
		int total = amount * qty;

		// Convert the result back to a string
		String expectedTotalAmount = "Rs. " + total;
		String actualTotalAmount = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p")).getText();
		Assert.assertEquals(actualTotalAmount, expectedTotalAmount,
				"Actual Total does not matches with Expected Total");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Enter description in comment text area and click 'Place Order'
		driver.findElement(messageText).sendKeys("Learning Selenium");
		driver.findElement(placeOrderButton).click();

		// Enter payment details: Name on Card, Card Number, CVC, Expiration date
		driver.findElement(By.xpath("//*[@name=\"name_on_card\"]")).sendKeys("Shraddha P Patil");
		driver.findElement(By.xpath("//*[@name=\"card_number\"]")).sendKeys("876 765 654 543");
		driver.findElement(By.xpath("//*[@name=\"cvc\"]")).sendKeys("111");
		driver.findElement(By.xpath("//*[@name=\"expiry_month\"]")).sendKeys("Jun");
		driver.findElement(By.xpath("//*[@name=\"expiry_year\"]")).sendKeys("2025");

		// Click 'Pay and Confirm Order' button
		driver.findElement(By.xpath("//*[@data-qa=\"pay-button\"]")).click();

		// Verify success message 'Your order has been placed successfully!'
		boolean orderPlacedDisplayed = driver
				.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).isDisplayed();
		if (orderPlacedDisplayed == true) {
			System.out.println("The Message displayed : Congratulations! Your order has been confirmed!");
		} else {
			System.out.println("Order Placed Message was not displayed");
		}

		//Dowload Invoice
		driver.findElement(By.xpath("//a[@href='/download_invoice/500']")).click();
		
		String filePath = "C:\\Users\\ADMIN\\Downloads\\invoice.txt";
		
		//checking if the file exists
		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("Invoice File found at : "+filePath);
			
			//Reading the content of the file
			try(BufferedReader br = new BufferedReader(new FileReader(file))){
				String line;
				StringBuilder content = new StringBuilder();
				while ((line =br.readLine())!= null) {
					content.append(line).append("\n");
				}
				// Verify if the content contains the expected text
				
				String expectedText = "Hi Shardh Patil, Your total purchase amount is 500. Thank you";
				if(content.toString().contains(expectedText)) {
					System.out.println("Invoice verification was successful. Expected text found");
				}else {
					System.out.println("Invoice verification Failed. Expected text not found");
				}
			}catch(IOException e){
				System.out.println("An error occurred while reading File");
			}
		}else {
			System.out.println("Invoice file not found at : " +filePath);
		}
		
		//Click 'Continue' button
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
		
		By deleteaccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

		// Click 'Delete Account' button
		driver.findElement(deleteaccount).click();

		// Verify 'ACCOUNT DELETED!' and click 'Continue' button
		By accountDeleteText = By.xpath("//*[text()='Account Deleted!']");
		Boolean accountDeleteDisplayed = driver.findElement(accountDeleteText).isDisplayed();
		if (accountDeleteDisplayed == true) {
			System.out.println("ACCOUNT DELETED Message was displayed");
		} else {
			System.out.println("ACCOUNT DELETED Message not displayed");
		}

	}
}
