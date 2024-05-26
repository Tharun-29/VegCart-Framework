package FreshHarvest.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CountryPage {
  
	WebDriver driver;
	
	public CountryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//select)[1]")
	WebElement options;
	
	@FindBy(css = "input[type='checkbox'")
	WebElement checkout;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement proceed;
	
	//method to select the country
	public OrderConfirmationPage selectCountry(String cName) {
		Select dropdown = new Select(options);
		dropdown.selectByValue(cName);
		checkout.click();
		proceed.click();
		OrderConfirmationPage op = new OrderConfirmationPage(driver);
		return op;
	}
	
	
}
