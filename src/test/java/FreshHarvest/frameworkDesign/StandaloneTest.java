package FreshHarvest.frameworkDesign;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FreshHarvest.TestComponents.BaseTest;
import FreshHarvest.framework.pageobjects.CheckoutPage;
import FreshHarvest.framework.pageobjects.CountryPage;
import FreshHarvest.framework.pageobjects.OrderConfirmationPage;

public class StandaloneTest extends BaseTest {
    
	@Test
	public void placeOrder() throws InterruptedException {
	    
 		
		String itemsNeeded[] = {"Tomato","Carrot","Cashews"};
		
		pg.addItems(itemsNeeded);


		// Print the Order details in console and open the Checkout Cart Page
		CheckoutPage cp = pg.orderDetails();
		CountryPage coupg = cp.checkoutProducts();

        
		// Select the country and select the checkbox from Country page
		String CountryName = "Australia";
		OrderConfirmationPage op = coupg.selectCountry(CountryName);

		// Print the Order confirmation in the console
		op.confirmationDetails();

	}
	


//	@DataProvider
//	public Object[][] getData() throws IOException {
//		
//		//Calling the method created for reading the Json file and converting to HashMap
//		// Note - We have passed the Path of JSON File as argument or parameter to the method below
//		
//		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\FreshHarvest\\data\\Items.json");
//		
//		return new Object[][] {{data.get(1)}};
//		
//		//return new Object[][] {{"DavidMDiaz@rhyta.com","David@54321","ADIDAS ORIGINAL"},{"zalepraddili-9737@yopmail.com","Cillian@54321","ZARA COAT 3"}};
//	}

	}
