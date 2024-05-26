package FreshHarvest.framework.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProductPage {
    
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
    	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "h4.product-name")
	List<WebElement> items;
	
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(3) strong:nth-child(1)" )
	WebElement no_of_items;
	
	@FindBy(css = "tbody tr:nth-child(2) td:nth-child(3) strong:nth-child(1)")
	WebElement price;
	
	@FindBy(css = "img[alt='Cart']")
    WebElement cart;
	
	@FindBy(xpath = "//button[contains(text(),'PROCEED')]")
	WebElement checkoutBasket;
	
	public void goToProductPage() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	
	// Creating methods to handle the search of product and adding to Basket
	public void addItems(String[] itemsNeeded) {
		int j = 0;
		for (int i = 0; i < items.size(); i++) {
			String name[] = items.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List<String> itemsNeededLists = Arrays.asList(itemsNeeded);

			if (itemsNeededLists.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
				j++;
			}
		}
	}
	
	// Method to print Order details
	public CheckoutPage orderDetails() throws InterruptedException {
		String orderListDetails = no_of_items.getText();
		System.out.println("Number of items:" + orderListDetails);
		System.out.println("Price:" + price.getText());
		cart.click();
		checkoutBasket.click();
		Thread.sleep(3000);
		CheckoutPage cp = new CheckoutPage(driver);
		return cp;
	}
}
