package com.project.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebConnector {

	//initialize properties file
	// logging 
 
	Properties OR=null;
	Properties QACONFIG=null;
    WebDriver driver;
	public WebConnector(){
		
	 if (OR==null){
		
		 // initialize OR
		 OR=new Properties();
		 try {
		 FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\configurations\\OR.properties");
			OR.load(fs);
			//OR.getProperty("testEnv");
		 
			//initialize CONFIG to corresponding env.
			
			QACONFIG=new Properties();
			fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\configurations\\QA_env.properties");
			QACONFIG.load(fs);
		 }
		  catch (IOException e) {
			 System.out.println("Error on initalizing properties files");
 
		}
		 
	 }
		
	}
	
	// selenium layer.... (
    //Opening Browser
	public void openBrowser(String brname){
				
	 if(brname.equals("IE")){
				
			System.out.println("IE Launching");
		    System.setProperty("webdriver.ie.driver", 
			"C:\\SeleniumSoftware\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe"); 
			driver=new InternetExplorerDriver();
	} else if(brname.equals("chrome")){
				
 
		System.setProperty("webdriver.chrome.driver", 
				"C:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver(); 
		
	 
	}else if(brname.equals("Firefox")){
		
		driver=new FirefoxDriver();
	}
	else{
		System.out.println(brname +"::Specified browser is not defined to launch");
	}
 
	 
	 // window max
	driver.manage().window().maximize();
		
	}
	
	//navigate to a URL
	public void navigateURL(String URL){
		
     driver.get(QACONFIG.getProperty(URL));
	}
	//Click on on any object
	public void click(String locator){
		
    //driver.findElement(By.id(OR.getProperty(locator))).click();
		
    WebElement element=checkFindElement(locator);
    	element.click();
    }
		
	
	public void enterText(String locator,String datatxt){
		
		//driver.findElement(By.id(OR.getProperty(locator))).sendKeys(datatxt);
		WebElement element=checkFindElement(locator);
		element.sendKeys(datatxt);
	}
	 
	public WebElement checkFindElement(String locator){
		WebElement element=null;
		if(locator.endsWith("_id")){
			element=driver.findElement(By.id(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_name")){
			element=driver.findElement(By.name(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_classname")){
			element=driver.findElement(By.className(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_tagname")){
			element=driver.findElement(By.tagName(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_xpath")){
			element=driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_cssselector")){
			element=driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_linktext")){
			element=driver.findElement(By.linkText(OR.getProperty(locator)));
		}
		else if (locator.endsWith("_plinktext")){
			element=driver.findElement(By.partialLinkText(OR.getProperty(locator)));
		}
		return element;
	

	}
	
	public boolean isElementPresent(String locator){
		boolean b=false;
		try{
			
			//driver.findElement(By.linkText(OR.getProperty(locator)));
			WebElement element=checkFindElement(locator);
			if(element!=null)
			b=true;
		}catch(Exception e){
			
		}
		return b;
		
	}
	public boolean verifyText_1(String listofproducts){
		boolean b=false;
		try{
		//WebElement element=driver.findElement(By.xpath(OR.getProperty("displaymsg_xpath")));
		WebElement element=checkFindElement(listofproducts);
		String actual_value=element.getText();
		if (listofproducts.equals(actual_value)){
			b=true;
		}
		}
		catch(Exception e){
			
		}
		return b;
		
}
	public boolean verifyText_2(String order){
		boolean b=false;
		try{
		//WebElement element=driver.findElement(By.xpath(OR.getProperty("displaymsg_xpath")));
		WebElement element=checkFindElement(order);
		String actual_value=element.getText();
		if (order.equals(actual_value)){
			b=true;
		}
		}
		catch(Exception e){
			
		}
		return b;	
	}
	
	/*public boolean verifyText (String message){
		boolean b=false;
		//WebElement element=driver.findElement(By.xpath(OR.getProperty("loginerrormsg")));
		WebElement element=checkFindElement(message);
		String actual_value=element.getText();
		if (message.equals(actual_value)){
			b=true;
		}
		return b;
	}

	public boolean verifyText2 (String errormessage){
		boolean b=false;
		//WebElement element1=driver.findElement(By.xpath(OR.getProperty("error")));
		WebElement element=checkFindElement(errormessage);
		String actual_value=element.getText();
		if (errormessage.equals(actual_value)){
			b=true;
		}
		return b;
	}*/
	public static void main(String[] args) {
	 

	}

	}

