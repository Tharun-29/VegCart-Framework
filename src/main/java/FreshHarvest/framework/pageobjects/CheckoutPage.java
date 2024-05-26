package FreshHarvest.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
   
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//button[contains(text(),'Place')]")
	WebElement placeOrder;
	
	// Select the checkbox and submit in Checkout Page
	public CountryPage checkoutProducts() {
		placeOrder.click();
		CountryPage coupg = new CountryPage(driver);
		return coupg;
	}
}
