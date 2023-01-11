package com.SeleniumWebDriver;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



@SuppressWarnings("unused")
public class google {
	
	private WebDriver driver;
	
   By videoLink = By.cssSelector("a[href='https://mx.hola.com/']");

@Before
public void setUp() {
	
	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com.mx/");
}
	

@Test	
public void testGooglePage() {
	WebElement searchbox = driver.findElement(By.name("q"));
	searchbox.clear();
	
	searchbox.sendKeys("hola");
		
	searchbox.submit();	
	
	//Implicit Wait
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Explicit Wait
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.titleContains("hola"));
	//assertEquals("hola - Buscar con Google", driver.getTitle());
	
	//FluentWait
	/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);*/
	
	@SuppressWarnings("unused")
	WebElement video = wait.until(new Function<WebDriver,WebElement>(){
		public WebElement apply(WebDriver driver) {
			return driver.findElement(videoLink);
		}
	});
	
	
	assertTrue(driver.findElement(videoLink).isDisplayed());
	
	
}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}



