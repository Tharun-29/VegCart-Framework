package FreshHarvest.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
   WebDriver driver;
   public OrderConfirmationPage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath = "//span[contains(text(),'Thank you, your order has been placed successfully')]")
   WebElement confirmation;
   
   public void confirmationDetails() throws InterruptedException {
	   String details = confirmation.getText();
	   System.out.println(details);
	   Thread.sleep(5000);
   }
   
}
