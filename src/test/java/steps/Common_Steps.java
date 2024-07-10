package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Steps {
	
	private WebDriver driver;
	
	
// GLobal Hooks	//if we have all the scenario and global hooks in one file then we can order them
	
	//executed before each and every gherkin scenarios
	@Before(order = 1)
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Global Before Hook Executed.");
	}
	
	//executed after each and every gherkin scenarios
	@After(order = 1)
	public void tearDown(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			//Take Screenshot
			final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getName());
		}
		driver.quit();
		Thread.sleep(1000);  //1 second of wait time for closing the browser.
		System.out.println("Global After Hook Executed.");
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

}
