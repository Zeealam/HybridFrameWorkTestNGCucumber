package StepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import zeeshan.SeleniumFramewordDesign.pageobjects.CartPage;
import zeeshan.SeleniumFramewordDesign.pageobjects.CheckOutPage;
import zeeshan.SeleniumFramewordDesign.pageobjects.ConfirmationPage;
import zeeshan.SeleniumFramewordDesign.pageobjects.LandingPage;
import zeeshan.SeleniumFramewordDesign.pageobjects.ProductCatalogue;
import zeeshan.SeleniumFrameworkDesign.TestComponents.BaseTest;

public class StepDefinitionimp extends BaseTest{
	
	String countryName = "india";
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public ConfirmationPage confirmationpage;
	public CheckOutPage checkoutpage;
	
	@Given("I landed on Ecommerve Page")
	public void I_landed_on_Ecommerve_Page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given ("^Logged in with emailid (.+) and password (.+)$")
	public void logged_in_with_emailid_and_password(String emailid, String password) {
		productCatalogue = landingPage.loginApplication(emailid,password);
	}
	
	@When ("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addproductTocart(productName);
	}
	
	@And ("^Checkout(.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		checkoutpage = cartPage.goTocheckOut();
		checkoutpage.selectCountry(countryName);
		confirmationpage = checkoutpage.submitOrder();
	}
	@Then ("{string}: message is displayed on confirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string) {
		String confirmMessage = confirmationpage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equals(string));
		driver.close();
	}
	
	@Then ("{string}: message is displayed")
	public void Error_message_is_Displayed(String message) {
		Assert.assertEquals(message, landingPage.getErrorMessage());
		driver.close();
	}
}
