package com.karthi.automationtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class PurchaseAutomationTesting {
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
	public void testAddStockSuccess() throws InterruptedException {
		driver.get("http://localhost:3000/addPurchase");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Ball");
		driver.findElement(By.name("quantity")).sendKeys("2");
		driver.findElement(By.name("totalPrice")).sendKeys("600");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Stock Purchased successfully", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testAddStockFaliure() throws InterruptedException {
		driver.get("http://localhost:3000/addPurchase");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Ball");
		driver.findElement(By.name("totalPrice")).sendKeys("600");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Please enter Available Quantity", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testUpdateStockSuccess() throws InterruptedException {
		driver.get("http://localhost:3000/viewPurchase");
		driver.manage().window().maximize();
		driver.findElement(By.id("update4")).click();
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("4");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertTrue(true);
		driver.switchTo().alert().accept();
	}

	@Test
	public void testDeleteStock() throws InterruptedException {
		driver.get("http://localhost:3000/viewPurchase");
		driver.manage().window().maximize();
		driver.findElement(By.name("delete4")).click();
		Thread.sleep(3000);
		assertEquals("Do you want to delete?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		assertEquals("Record deleted successfully", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

}
