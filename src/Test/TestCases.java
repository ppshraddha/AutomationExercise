package Test;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.TestCasePage;

public class TestCases {
	WebDriver driver;
	
	HomePage homepage;
	LoginPage loginpage;
	ContactUsPage contactuspage;
	TestCasePage testcasepage;
	ProductPage productpage;
	CartPage cartpage;

	@BeforeTest
	public void beforeTest() {

		System.out.println("beforeTest");

		// Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Documents\\jar\\chromedriver.exe");
		driver = new ChromeDriver();
		

		try {
			driver.get("https://automationexercise.com");
			driver.manage().window().maximize();

			homepage = new HomePage(driver);
		} catch (NoSuchWindowException e) {
			// Handle the exception, e.g., log it or provide a meaningful error message
			System.out.println("Caught NoSuchWindowException: " + e.getMessage());
			Assert.fail("Browser window is not available.");
		}

		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		contactuspage = new ContactUsPage(driver);
		testcasepage = new TestCasePage(driver);
		productpage = new ProductPage(driver);
		cartpage = new CartPage(driver);
	}

	@Test(priority=0)
	public void testCase1() throws Exception {
		System.out.println("Run :TestCase 1");
		loginpage.login();
		loginpage.registerUser();
		loginpage.deleteAccount();

	}

	@Test(priority=1)
	public void testCase2() {
		System.out.println("Run :TestCase 2");
		loginpage.loginSucess();
		
		//loginpage.deleteAccount();
	}

	@Test(priority=2)
	public void testCase3() {
		System.out.println("Run :TestCase 3");
		loginpage.LoginFailure();
	}

	@Test(priority=3)
	public void testCase4() {
		System.out.println("Run :TestCase 4");
		loginpage.LogoutUser();
	}
	
	@Test(priority=4)
	public void testCase5() {
		System.out.println("Run :TestCase 5");
		loginpage.RegisterUserExistingEmail();
		
	}
	
	@Test(priority=5)
	public void testCase6() {
		System.out.println("Run :TestCase 6");
		driver.navigate().to("https://automationexercise.com");
		contactuspage.contactUs();
	}
	
	@Test(priority=6)
	public void testCase7() {
		System.out.println("Run :TestCase 7");
		testcasepage.testCases();
	}
	
	@Test(priority=7)
	public void testCase8() {
		System.out.println("Run :TestCase 8");
		productpage.product();
	}
	
	@Test(priority=8)
	public void testCase9() throws Exception {
		System.out.println("Run :TestCase 9");
		productpage.searchProduct();
	}
	
	@Test(priority=9)
	public void testCase10() {
		System.out.println("Run :TestCase 10");
		homepage.subscription();
	}
	
	@Test(priority=10)
	public void testCase11(){
		System.out.println("Run :TestCase 11");
		cartpage.cartSubscription();
	}
	
	@Test(priority=11)
	public void testCase12() {
		System.out.println("Run :TestCase 12");
		cartpage.addToCart();
		
	}
	
	@Test(priority=12)
	public void testCase13() throws Exception {
		System.out.println("Run :TestCase 13");
		cartpage.viewProductQuantity();
	}
	
	@Test(priority=13)
	public void testCase14()  {
		System.out.println("Run :TestCase 14");
		cartpage.placeOrder();
		
	}
	
	@Test(priority=14)
	public void testCase15() {
		System.out.println("Run :TestCase 15");
		loginpage.login();
		loginpage.registerUser();
		cartpage.placeOrderRegisterBeforeCheckout();
	}
	
	@Test(priority=15)
	public void testCase16() {
		System.out.println("Run :TestCase 16");
		loginpage.login();
		cartpage.placeOrderLoginBeforeCheckout();
	}
	
	@Test(priority=16)
	public void testCase17() {
		System.out.println("Run :TestCase 17");
		cartpage.removeProductsFromCart();
	}
	
	@Test(priority=17)
	public void testCase18() throws Exception {
		System.out.println("Run :TestCase 18");
		productpage.viewCategoryProducts();
	}
	
	@Test(priority=18)
	public void testCase19() throws Exception{
		System.out.println("Run :TestCase 19");
		productpage.viewBrandProducts();
	}
	
	@Test(priority=19)
	public void testCase20() throws Exception {
		System.out.println("Run :TestCase 20");
		cartpage.searchProductsverifyCartAfterLogin();
	}
	
	@Test(priority=20)
	public void testCase21() {
		System.out.println("Run :TestCase 21");
		productpage.addReview();
	}
	
	@Test(priority=21)
	public void testCase22() throws Exception {
		System.out.println("Run :TestCase 22");
		productpage.recommendedItems();
	}
	
	@Test(priority=22)
	public void testCase23() {
		System.out.println("Run :TestCase 22");
		cartpage.verifyAddressDetailsInCheckoutPage();
	}
	
	@Test(priority=23)
	public void testCase24() throws Exception {
		System.out.println("Run :TestCase 24");
		cartpage.downloadInvoiceAfterPuchaseOrder();
	}
	
	@Test(priority=24)
	public void testcase25() throws Exception {
		System.out.println("Run :TestCase 25");
		homepage.scrollupUsingArrow();
	}
	
	
	@Test(priority=25)
	public void testCase26() throws Exception {
		System.out.println("Run :TestCase 26");
		homepage.scrollupWithoutArrow();
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
		
	}

}
