package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="allureFeature",
		glue="com.step"
		//plugin = { 
				//"pretty", "html:target/cucumber-html-reports",
				//"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
		        //"json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt" }, 
		//monochrome = true 
		        
		        )
		
		
		
		
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
