package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends Base {
	
	By signInName = By.name("userName");
	By signInPassword = By.name("password");
	By signIn = By.name("submit");
	
	By signMessage = By.tagName("font");

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void signIn() throws InterruptedException {
		if(isDisplay(signInName)) {
		type("anelmorales",signInName);
		type("anel3101",signInPassword);
		click(signIn);
		}else {
			System.out.println("username textbox was not found");
		}
		
	}
	public String signInMessage() {
		List<WebElement> fonts = findElements(signMessage);
		return getText(fonts.get(3));
	}

	
}
