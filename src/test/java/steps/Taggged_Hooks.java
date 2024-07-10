package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Taggged_Hooks {
	
	private WebDriver driver;
	
	public void Tagged_Hooks(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	//executed Before all those scenarios which contain this setCookies tag--- Scenario specific hook.
	@Before(value  = "@setCookies", order = 0)
	public void setCookies() {
		System.out.println("Scenarios specific hook - setCookies exceuted");
	}
	
	//Scenario specific After hook -- which has the highest preference/order runs last and which has least runs first.
	@After(value = "@tesT", order = 0)
	public void tesT() {
		System.out.println("Scenarios specific hook - tesT executed");
	}

}
