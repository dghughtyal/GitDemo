package steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import actions.Common_Actions;
import actions.EbayAdvancedSearch_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayAdvancedSearch_Steps {
	
	Common_Actions common_actions;
	EbayAdvancedSearch_Actions ebayadvancedsearch_actions;
	
	public EbayAdvancedSearch_Steps(Common_Actions common_actions, EbayAdvancedSearch_Actions ebayadvancedsearch_actions) {
		this.common_actions = common_actions;
		this.ebayadvancedsearch_actions = ebayadvancedsearch_actions;
	}

	@Given("I am on Ebay Advanced Search Page")
	public void i_am_on_ebay_advanced_search_page() {
		//driver.get("https://www.ebay.com/sch/ebayadvsearch");
		common_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
	}
	
	@When("I click on Ebay Logo")
	public void i_click_on_ebay_logo() {
		//driver.findElement(By.xpath("//a[@id='gh-la']")).click();
		ebayadvancedsearch_actions.clickOnEbayLogo();
	}
	
	@Then("I am navigated to Ebay Home Page")
	public void i_am_navigated_to_ebay_home_page() {
		String expUrl = "https://www.ebay.com/";
		//String actUrl = driver.getCurrentUrl();
		String actUrl = common_actions.getCurrentPageUrl();
		if(!expUrl.equals(actUrl)) {
			fail("Page doesnot navigate to Home Page.");
		}
	
	}
	
	@When("I Advance Search an item")
	public void i_advance_search_an_item(DataTable dataTable) throws Exception {
		//driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1, 0));
		//driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1, 1));
		//driver.findElement(By.xpath("//input[@name='_udlo']")).sendKeys(dataTable.cell(1, 2));
		//driver.findElement(By.xpath("//input[@name='_udhi']")).sendKeys(dataTable.cell(1, 3));
		//driver.findElement(By.cssSelector("div.adv-form__actions>button")).click();
		
		ebayadvancedsearch_actions.enterAdvSearchString(dataTable.cell(1, 0));
		ebayadvancedsearch_actions.enterAdvExcludeString(dataTable.cell(1, 1));
		ebayadvancedsearch_actions.enterAdvMinPrice(dataTable.cell(1, 2));
		ebayadvancedsearch_actions.enterAdvMaxPrice(dataTable.cell(1, 3));
		ebayadvancedsearch_actions.clickAdvSearchButton();
		Thread.sleep(3000);
	}



}
