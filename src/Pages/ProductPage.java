package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage extends MainPage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	By homeLink = By.xpath("//a[text()=' Home']");
	By productlink = By.xpath("//a[text()=' Products']");
	By cartLink = By.xpath("//a[text()=' Cart']");
	By viewfirstproduct = By.xpath("//a[@href='/product_details/1']");
	By allProducts = By.xpath("//h2[text()='All Products']");
	By productname = By.xpath("//h2[text()='Blue Top']");
	By category = By.xpath("//p[text()='Category: Women > Tops']");
	By price = By.xpath("//span[text()='Rs. 500']");
	By availability = By.xpath("//b[text()='Availability:']");
	By condition = By.xpath("//b[text()='Condition:']");
	By brand = By.xpath("//b[text()='Brand:']");
	By searchproduct = By.id("search_product");
	By submitbutton = By.id("submit_search");

	By quantity = By.id("quantity");
	By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");
	By viewCartButton = By.xpath("//u[text()='View Cart']");
	By disabledqty = By.xpath("//button[@class='disabled']");

	By categoryText = By.xpath("//*[text()='Category']");
	By womenCategory = By.xpath("//*[@href='#Women']");
	By dressSubCategory = By.xpath("//*[@href='/category_products/1']");
	By womenDressProductsText = By.xpath("//*[text()='Women - Dress Products']");
	By menCategory = By.xpath("//*[@href ='#Men']");
	By tshirtsSubCategory = By.xpath("//*[@href='/category_products/3']");
	By mensTshirtProductsText = By.xpath("//*[text()='Men - Tshirts Products']");
	By brandslink = By.xpath("//*[text()='Brands']");
	By poloBrandLink = By.xpath("//*[@href='/brand_products/Polo']");
	By poloBrandPage = By.xpath("//*[text()='Brand - Polo Products']");
	By babyhugBrandLink = By.xpath("//*[@href='/brand_products/Babyhug']");
	By babyhugBrandPage = By.xpath("//*[text()='Brand - Babyhug Products']");
	By review = By.xpath("//a[@href='#reviews']");

	JavascriptExecutor executor = (JavascriptExecutor) driver;

	// TestCase 8
	public void product() {
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
		// Click on 'Products' button
		driver.findElement(productlink).click();
		String expectedTitle1 = "Automation Exercise - All Products";
		String actualTitle1 = "";
		try {
			actualTitle1 = driver.getTitle();
			Assert.assertEquals(actualTitle1, expectedTitle1, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		// Verify user is navigated to ALL PRODUCTS page successfully
		boolean productList = driver.findElement(allProducts).isDisplayed();
		if (productList == true) {
			System.out.println("All Products Lists is visible");

		} else {
			System.out.println("Products Lists is not visible");
		}

		// Click on 'View Product' of first product
		driver.findElement(viewfirstproduct).click();

		// User is landed to product detail page
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

		// Verify that detail detail is visible: product name, category, price,
		// availability, condition, brand
		boolean productNameDisplayed = driver.findElement(productname).isDisplayed();
		if (productNameDisplayed == true) {
			System.out.println("product name Blue top is displayed");
		} else {
			System.out.println("Product name is not displayed");
		}

		boolean categoryDisplayed = driver.findElement(category).isDisplayed();
		if (categoryDisplayed == true) {
			System.out.println("Category- Women Tops is displayed");
		} else {
			System.out.println("Category is not displayed");
		}

		boolean priceDisplayed = driver.findElement(price).isDisplayed();
		if (priceDisplayed == true) {
			System.out.println("Price Rs.500 is displayed");
		} else {
			System.out.println("Price is not displayed");
		}

		boolean availabilityDisplayed = driver.findElement(availability).isDisplayed();
		if (availabilityDisplayed == true) {
			System.out.println("Availability is displayed");
		} else {
			System.out.println("Availability is not displayed");
		}

		boolean conditionDisplayed = driver.findElement(condition).isDisplayed();
		if (conditionDisplayed == true) {
			System.out.println("Condition of the Product is displayed");
		} else {
			System.out.println("Condition of the product is not displayed");
		}

		boolean brandDisplayed = driver.findElement(brand).isDisplayed();
		if (brandDisplayed == true) {
			System.out.println("Brand of the Product is displayed");
		} else {
			System.out.println("Brand of the product is not displayed");
		}
	}

	// TestCase 9
	public void searchProduct() throws Exception {
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
		// Click on 'Products' button
		driver.findElement(productlink).click();

		String expectedTitle1 = "Automation Exercise - All Products";
		String actualTitle1 = "";
		try {
			actualTitle1 = driver.getTitle();
			Assert.assertEquals(actualTitle1, expectedTitle1, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		// Verify user is navigated to ALL PRODUCTS page successfully
		boolean productList = driver.findElement(allProducts).isDisplayed();
		if (productList == true) {
			System.out.println("All Products Lists is visible");

		} else {
			System.out.println("Products Lists is not visible");
		}

		// Enter product name in search input and click search button
		// driver.findElement(searchproduct).sendKeys("top");

		// Enter product name in search input and click search button

		String productSearchTerm = "Top";
		By searchProduct = By.id("search_product"); // Change the selector as per your application
		driver.findElement(searchProduct).sendKeys(productSearchTerm);
		driver.findElement(submitbutton).click();

		// Step 2: Find and display only items containing "top"
		List<WebElement> searchedProductElements = driver.findElements(
				By.xpath("//*[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
						+ productSearchTerm.toLowerCase() + "')]"));

		System.out.println(
				"Total Number of items containing \"" + productSearchTerm + "\" is: " + searchedProductElements.size());

		// Iterate through each item element
		for (WebElement itemElement : searchedProductElements) {
			// You can perform further actions with the item elements here, such as printing
			// their text or clicking on them
			System.out.println("Item Text: " + itemElement.getText());
		}

	}

	public void viewCategoryProducts() throws Exception {
		// Verify that categories are visible on left side bar
		boolean categoryList = driver.findElement(categoryText).isDisplayed();
		if (categoryList == true) {
			System.out.println("All Category Lists is visible");

		} else {
			System.out.println("Category Lists is not visible");
		}

		executor.executeScript("window.scrollBy(0,450)");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click on 'Women' category
		driver.findElement(womenCategory).click();

		// Click on any category link under 'Women' category, for example: Dress
		driver.findElement(dressSubCategory).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Verify that category page is displayed and confirm text 'WOMEN - TOPS
		// PRODUCTS'
		String expectedTitle1 = "Automation Exercise - Dress Products";
		String actualTitle1 = "";
		try {
			actualTitle1 = driver.getTitle();
			Assert.assertEquals(actualTitle1, expectedTitle1, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		Boolean womenDressProductTextDisplayed = driver.findElement(womenDressProductsText).isDisplayed();
		if (womenDressProductTextDisplayed == true) {
			System.out.println("The Text WOMEN - DRESS PRODUCTS is displayed");
		} else {
			System.out.println("The Text for WOMEN - DRESS PRODUCTS is not displayed");
		}
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// On left side bar, click on any sub-category link of 'Men' category
		Thread.sleep(1000);
		driver.findElement(menCategory).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Verify that user is navigated to that category page
		boolean mensTshirtProductsTextDisplayed = driver.findElement(mensTshirtProductsText).isDisplayed();
		if (mensTshirtProductsTextDisplayed == true) {
			System.out.println("The Text MEN - TSHIRTS PRODUCTS is displayed");
		} else {
			System.out.println("The Text MEN - TSHIRTS PRODUCTS is not displayed");
		}
	}

	public void viewBrandProducts() throws Exception {
		driver.findElement(homeLink).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Click on 'Products' button
		driver.findElement(productlink).click();

		executor.executeScript("window.scrollBy(0,550)");

		// Verify that Brands are visible on left side bar
		boolean brandslinkDisplayed = driver.findElement(brandslink).isDisplayed();
		if (brandslinkDisplayed == true) {
			System.out.println("Brands are visible on left side bar");
		} else {
			System.out.println("Brands are not visible on left side bar");
		}

		// Click on any brand name
		driver.findElement(poloBrandLink).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Verify that user is navigated to brand page and brand products are displayed
		/*
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); String
		 * expectedTitle1 = "Automation Exercise - Polo Products"; String actualTitle1 =
		 * ""; try { actualTitle1 = driver.getTitle(); Assert.assertEquals(actualTitle1,
		 * expectedTitle1, "Title does not match the expected Title"); } catch
		 * (NoSuchWindowException e) { // Handling the exception
		 * System.out.println("Caught NoSuchWindowException: " + e.getMessage());
		 * Assert.fail("Browser window is not available."); }
		 */
		executor.executeScript("window.scrollBy(0,250)");

		boolean poloBrandPageDisplayed = driver.findElement(poloBrandPage).isDisplayed();
		if (poloBrandPageDisplayed == true) {
			System.out.println("Polo Brand Products are displayed");
		} else {
			System.out.println("Polo Brand Products are displayed");
		}
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// On left side bar, click on any other brand link
		driver.findElement(babyhugBrandLink).click();

		// Verify that user is navigated to that brand page and can see products
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedTitle2 = "Automation Exercise - Babyhug Products";
		String actualTitle2 = "";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			actualTitle2 = driver.getTitle();
			Assert.assertEquals(actualTitle2, expectedTitle2, "Title does not match the expected Title");
		} catch (NoSuchWindowException e) {
			// Handling the exception
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean pbabyhugBrandPageDisplayed = driver.findElement(babyhugBrandPage).isDisplayed();
		if (pbabyhugBrandPageDisplayed == true) {
			System.out.println("Polo Brand Products are displayed");
		} else {
			System.out.println("Polo Brand Products are displayed");
		}

	}

	public void addReview() {
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
		// Click on 'Products' button
		driver.findElement(productlink).click();

		// Verify user is navigated to ALL PRODUCTS page successfully
		boolean productList = driver.findElement(allProducts).isDisplayed();
		if (productList == true) {
			System.out.println("All Products Lists is visible");

		} else {
			System.out.println("Products Lists is not visible");
		}

		executor.executeScript("window.scrollBy(0,450)");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on 'View Product' button
		driver.findElement(viewfirstproduct).click();

		// Verify 'Write Your Review' is visible
		executor.executeScript("window.scrollBy(0,450)");
		boolean reviewDisplayed = driver.findElement(review).isDisplayed();
		if (reviewDisplayed == true) {
			System.out.println("Write your Review Text -is displayed");
		} else {
			System.out.println("Write your Review Text -is not displayed");
		}

		// Enter name, email and review
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Shraddha P Patil");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("psp1234@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='review']")).sendKeys("Learning To Code is Awesome");

		// Click 'Submit' button
		driver.findElement(By.xpath("//button[@id='button-review']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Verify success message 'Thank you for your review.'
		boolean reviewMessage = driver.findElement(By.xpath("//*[text()='Thank you for your review.']")).isDisplayed();
		if (reviewMessage == true) {
			System.out.println("Thank You for your Review -Message is displayed");
		} else {
			System.out.println("Thank You for your Review -Message is not displayed");
		}

	}

	public void recommendedItems() throws Exception {
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

	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    // Scroll to the bottom of the page
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight - 1800);");
	    Thread.sleep(2000);
	    
	 // Click on the product containing the word 'dress'
	    WebElement dressProduct = driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/p"));
	    String productName = dressProduct.getText();
	    dressProduct.click();
	    // Click on the 'Add to Cart' button
	    driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a")).click();
	    
	 // Click on the cart link
	    driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();
	    
	 // Verify if the cart contains the product
	    String cartPageSource = driver.getPageSource();
	    if (cartPageSource.contains(productName)) {
	        System.out.println("The cart contains the product: " + productName);
	    } else {
	        System.out.println("The cart does not contain the product: " + productName);
	    }
	    Thread.sleep(2000);
	}
	    


}
