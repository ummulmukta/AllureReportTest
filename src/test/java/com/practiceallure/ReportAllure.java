package com.practiceallure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportAllure {
public WebDriver driver;
@Before
public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	//driver.get("https://www.facebook.com");
}
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
}
