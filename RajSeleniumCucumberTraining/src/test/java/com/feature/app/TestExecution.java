package com.feature.app;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
@CucumberOptions(plugin = {"pretty", "html:target/Prema-htmlreport",
		"json:target/cucumber-report.json"})
public class TestExecution {
 
}
