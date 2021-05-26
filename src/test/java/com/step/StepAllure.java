package com.step;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.practiceallure.ReportAllure;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public class StepAllure{
WebDriver driver;
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		//driver.get("https://www.facebook.com");
	}
	@Attachment
	@After
	public void tearDown(Scenario scenario) {
		try {
			String screenshotName=scenario.getName().replaceAll("", "");
			if(scenario.isFailed()) {
				scenario.log("this is my failure message");
				TakesScreenshot ts=(TakesScreenshot)driver;
				byte[]screenshot=ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", screenshotName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
@Given("I am on facebook page")
public void i_am_on_facebook_page() throws InterruptedException {
	driver.get("https://www.amazon.com/");
	Thread.sleep(1000);

}

@When("I enter user name")
public void i_enter_user_name() {
	Select se=new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
	se.selectByVisibleText("Alexa");
	List<WebElement>l=se.getOptions();
	
	System.out.println(l.size());
	for(int a=0;a<l.size();a++) {
		System.out.println(l.get(a).getText());
	}
}

@When("I enter password")
public void i_enter_password() {


}

@When("I click login")
public void i_click_login() {


}

@Then("I successfully logged in")
public void i_successfully_logged_in() {


}
}
