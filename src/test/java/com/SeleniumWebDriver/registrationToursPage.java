package com.SeleniumWebDriver;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class registrationToursPage {
	
	private WebDriver driver;
	By register = By.linkText("REGISTER");
	By registerPage = By.xpath("//img[@src='images/mast_register.gif']");
	
	By username = By.id("email");
	By password = By.name("password");
	By confirmPassword = By.cssSelector("input[name='confirmPassword']");
	By enviar = By.cssSelector("input[src='images/submit.gif']");

	
	By signInName = By.name("userName");
	By signInPassword = By.name("password");
	By signIn = By.name("submit");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(register).click();
		Thread.sleep(2000);
		if(driver.findElement(registerPage).isDisplayed()) {
			driver.findElement(username).sendKeys("anelsofia");
			driver.findElement(password).sendKeys("anel3101");
			driver.findElement(confirmPassword).sendKeys("anel3101");
			driver.findElement(enviar).click(); 
		
		}
		
		else {
			System.out.print("Register page was not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is anelsofia.",fonts.get(5).getText());
	}
		
	@Test
	public void signIn() throws Exception {
			if(driver.findElement(signInName).isDisplayed()) {
				driver.findElement(signInName).sendKeys("anelsofia");
				driver.findElement(signInPassword).sendKeys("anel3101");
				driver.findElement(signIn).click(); 
				Thread.sleep(2000);
				
				List<WebElement> fonts1 = driver.findElements(By.tagName("font"));
				
				assertEquals("Thank you for Loggin.",fonts1.get(3).getText());
			}
			else {
				System.out.print("Login was not successfully");
			}
		}
	}


