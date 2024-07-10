package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.Common_Actions;
import actions.EbayHome_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_Steps {

	Common_Actions common_actions;
	EbayHome_Actions ebayhome_actions;
	
	public EbayHome_Steps(Common_Actions common_actions, EbayHome_Actions ebayhome_actions) {
		this.common_actions = common_actions;
		this.ebayhome_actions = ebayhome_actions;
	}
	
	@Given("I am on Ebay Home Page")
	public void i_am_on_ebay_home_page() {
		//driver.get("https://www.ebay.com/");
		common_actions.goToUrl("https://www.ebay.com/");
	}

	@When("I click on Advanced Link")
	public void i_click_on_advanced_link() {
	  //driver.findElement(By.xpath("//a[@title='Advanced Search']")).click();
		ebayhome_actions.clickAdvancedLink();
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_advanced_search_page() {
	   String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
	   //String actUrl = driver.getCurrentUrl();
	   String actUrl = common_actions.getCurrentPageUrl();
	   if(!expUrl.equals(actUrl)){
		  fail("Page doesnot navigate to expected Page."); 	
	   }
	  
	}
	
	@When("I search for {string}")
	public void i_search_for_i_phone(String str1) throws Exception {
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
		//driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		ebayhome_actions.searchAnItem(str1);
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);

	}
	
	@Then("I validate atleast {int} search items present")
	public void i_validate_atleast_search_items_present(int count) {
		//String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText().trim();
		int itemCountint = ebayhome_actions.getSearchItemCount(count);
		//String actItemcount = itemCount.replace(",", "");
		//int itemCountint = Integer.parseInt(actItemcount);
		if (itemCountint <= count) {
			fail("Less than " + count + " result shown");
		}	

	}
	
	@When("I search for {string} in {string} category")
	public void i_search_for_in_category(String string, String string2) throws Exception {
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
		ebayhome_actions.searchAnItem(string);
//		List<WebElement> cat = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
//		for(WebElement x : cat) {
//			if(x.getText().trim().toLowerCase().equals(string2.toLowerCase())) {
//				x.click();
//				break;				
//			}
//		}
		
		ebayhome_actions.searchCategoryOption(string2);
		//driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		ebayhome_actions.clickSearchButton();
		Thread.sleep(1000);	
	}
	
	@When("I click on the {string}")
	public void i_click_on_the(String string) throws Exception {
		//driver.findElement(By.linkText(string)).click();
		ebayhome_actions.clickOnLinkText(string);
		Thread.sleep(1000);
	  
	}
	@Then("I validate that the page navigates to {string} and title contains {string}")
	public void i_validate_that_the_page_navigates_to_and_title_contains(String url, String title) {
		//String actUrl = driver.getCurrentUrl();
		String actUrl = common_actions.getCurrentPageUrl();
		//String actTitle = driver.getTitle();
		String actTitle = common_actions.getCurrentPageTitle();
		if(!actUrl.equals(url)) {
			fail("Page does not navigate to expected url: " + url);
			
		}
		
		if(!actTitle.contains(title)) {
			fail("Title mismatch");
		}
		
	 
	}

	
}
