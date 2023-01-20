package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{
	
	By register = By.linkText("REGISTER");
	By registerPage = By.xpath("//img[@src='images/mast_register.gif']");
	
	By username = By.id("email");
	By password = By.name("password");
	By confirmPassword = By.cssSelector("input[name='confirmPassword']");
	By enviar = By.cssSelector("input[src='images/submit.gif']");

	
	By registeredMessage = By.tagName("font");

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() throws InterruptedException {
		click(register);
		Thread.sleep(2000);
		if(isDisplay(registerPage)) {
			type("anelmorales", username);
			type("anel3101", password);
			type("anel3101", confirmPassword);
			
			click(enviar);
		}else {
			System.out.println("Register pages was not found");
		}
		
	}
	
	public String registeredMessage() {
		List<WebElement> fonts = findElements(registeredMessage);
		return getText(fonts.get(5));
		
	}

}
