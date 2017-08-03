package com.feature.app;

import junit.framework.Assert;

import com.project.testbase.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCompletedLoginPage {
	
	WebConnector  selenium=new WebConnector();
 
	@Given("I go to \"([^\"]*)\" and with \"([^\"]*)\"")
	public void I_go_to_url_and_with_chrome(String url,String browser ){
		
		System.out.println("I go to url and with chrome.....");
		selenium.openBrowser(browser);
		selenium.navigateURL(url);
			
	}

	@When("I enter \"([^\"]*)\" in the \"([^\"]*)\"")
	public void I_enter(String username,String txtbox ){
		
		System.out.println("I enter username......."+username + "---"+txtbox);
		
		selenium.enterText(txtbox, username);
	}
	
	 
	
	@And("I click on \"([^\"]*)\" button")
	public void I_click_on_login_button(String locator){
		
		System.out.println("I click on login button......");
		
		selenium.click(locator);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
	}
	
	@Then("I validate \"([^\"]*)\" the Logged successful")
	public void I_validate_the_Logged_successful(String viewallorders){
		
		System.out.println("I validate the Logged successful.....");
		boolean actualresult=selenium.isElementPresent(viewallorders);
		
		//Junit
		Assert.assertTrue(actualresult);
	}

	
	
	/*@And("I click on \"([^\"]*)\" button")
	 
	public void I_click_on_viewallproducts_linktext(String locator){
		System.out.println("I click on viewallproducts_linktext");
		selenium.click(locator);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@Then("I verified \"([^\"]*)\" text is displayed")
	public void verify_the_text(String listofproducts){
		System.out.println("I verified listofproducts text is displayed");
		boolean actualresult=selenium.verifyText_1(listofproducts);
		//selenium.verifyText_1(listofproducts);
		//Assert.assertTrue(actualresult1);
	}

}
	
	
	

/*	@Then("I verify \"([^\"]*)\" is displayed")
	public void I_verify_message(String message){
		System.out.println("I verify " + message);
	selenium.verifyText(message);
	Assert.assertTrue(selenium.verifyText(message));
	
}
	@Then("I verified \"([^\"]*)\" is displayed")
	public void I_verified_message(String errormessage){
		System.out.println("I verified " + errormessage);
	selenium.verifyText2(errormessage);
	Assert.assertTrue(selenium.verifyText2(errormessage));*/



