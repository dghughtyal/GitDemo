package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.EbayHome_Elements;
import steps.Common_Steps;

public class EbayHome_Actions {
	
	private WebDriver driver;
	EbayHome_Elements ebayhome_elements;
	
	public EbayHome_Actions(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
		ebayhome_elements = new EbayHome_Elements(driver);
	}
	
	public void clickAdvancedLink() {
		ebayhome_elements.advSearchLink.click();
	}
	
	public void searchAnItem(String srchString) {
		ebayhome_elements.searchBox.sendKeys(srchString);
	}
	
	public void clickSearchButton() {
		ebayhome_elements.searchButton.click();
	}
	
	public int getSearchItemCount(int srchCount) {
		String itemCount = ebayhome_elements.numOfItems.getText().trim();
		String actItemcount = itemCount.replace(",", "");
		int itemCountint = Integer.parseInt(actItemcount);
		return itemCountint;
	}
	
	public void searchCategoryOption(String catOption) {
		List<WebElement> cat = ebayhome_elements.catOptions;
		for(WebElement x : cat) {
			if(x.getText().trim().toLowerCase().equals(catOption.toLowerCase())) {
						x.click();
						break;	
				}
		}		
	}
	
	public void clickOnLinkText(String linkTextName) {
		driver.findElement(By.linkText(linkTextName)).click();
	}
	
}
