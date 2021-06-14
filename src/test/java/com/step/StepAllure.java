package com.step;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.practiceallure.ReportAllure;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class StepAllure{
WebDriver driver;
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
	//	driver= new InternetExplorerDriver();
		//WebDriverManager.chromedriver().setup();
		//driver =new ChromeDriver();
		driver=new FirefoxDriver();
		//driver.get("https://www.facebook.com");
	}
	@Attachment(value="Page screenshot",type="image/png")
	public byte[]saveScreenshot(byte[]screenShot){
		return screenShot;
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		
		scenario.log("After Hook");
		if(scenario.isFailed()) {
			Allure.addAttachment("any name", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
		}
		
		
		/*
		 * try { String screenshotName=scenario.getName().replaceAll("", "");
		 * if(scenario.isFailed()) { scenario.log("this is my failure message");
		 * TakesScreenshot ts=(TakesScreenshot)driver;
		 * byte[]screenshot=ts.getScreenshotAs(OutputType.BYTES);
		 * scenario.attach(screenshot, "image/png", screenshotName); } }catch(Exception
		 * e) { e.printStackTrace(); }
		 */
		driver.close();
	}
@Given("I am on facebook page")
public void i_am_on_facebook_page() throws InterruptedException {
	driver.get("https://www.facebook.com/");
	Thread.sleep(1000);

}

@When("I enter user name")
public void i_enter_user_name() {
	//Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less.");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ummul mukta");
	
	/*
	 * Select se=new
	 * Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
	 * se.selectByVisibleText("Alexa"); List<WebElement>l=se.getOptions();
	 * 
	 * System.out.println(l.size()); for(int a=0;a<l.size();a++) {
	 * System.out.println(l.get(a).getText()); }
	 */
}

@When("I enter password")
public void i_enter_password() throws InterruptedException {
driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("fhvgbjnm345");
Thread.sleep(2000);
}

@When("I click login")
public void i_click_login() throws InterruptedException {
	try {
	       new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//tagname[@attribute='value")));
	       System.out.println("Element is clickable");
	     }
	catch(TimeoutException e) {
	       System.out.println("Element isn't clickable");
	    }
		/*
		 * driver.findElement(By.xpath("//button[@name='login']")).click();
		 * Thread.sleep(2000);
		 */
}

@Then("I successfully logged in")
public void i_successfully_logged_in() {

	Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less.");
}
}
