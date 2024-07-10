package actions;

import org.openqa.selenium.WebDriver;

import elements.EbayAdvancedSearch_Elements;
import steps.Common_Steps;

public class EbayAdvancedSearch_Actions {
	
	private WebDriver driver;
	EbayAdvancedSearch_Elements ebayadvancesearch_elements;
	
	public EbayAdvancedSearch_Actions(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
		ebayadvancesearch_elements = new EbayAdvancedSearch_Elements(driver);
	}
	
	public void clickOnEbayLogo() {
		ebayadvancesearch_elements.ebayLogo.click();
	}
	
	public void enterAdvSearchString(String string) {
		ebayadvancesearch_elements.searchString.sendKeys(string);;
	}
	
	public void enterAdvExcludeString(String string) {
		ebayadvancesearch_elements.excludeString.sendKeys(string);
	}
	
	public void enterAdvMinPrice(String string) {
		ebayadvancesearch_elements.minPrice.sendKeys(string);
	}
	
	public void enterAdvMaxPrice(String string) {
		ebayadvancesearch_elements.maxPrice.sendKeys(string);
	}
	
	public void clickAdvSearchButton() {
		ebayadvancesearch_elements.advSearchButton.click();
	}

}
