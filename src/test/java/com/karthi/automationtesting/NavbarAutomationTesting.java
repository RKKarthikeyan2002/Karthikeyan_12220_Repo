package com.karthi.automationtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavbarAutomationTesting {
	private WebDriver driver;

	@BeforeEach
	public void initialize() {
		driver = new ChromeDriver();
	}

	@AfterEach
	public void closeConnection() {
		driver.quit();
	}
	
	@Test
	public void navbarStock() {
		driver.get("http://localhost:3000/");
		driver.findElement(By.id("stock")).click();
		assertEquals("http://localhost:3000/viewStock", driver.getCurrentUrl());
	}
	
	@Test
	public void navbarPurchase() {
		driver.get("http://localhost:3000/");
		driver.findElement(By.id("purchase")).click();
		assertEquals("http://localhost:3000/viewPurchase", driver.getCurrentUrl());
	}
}
