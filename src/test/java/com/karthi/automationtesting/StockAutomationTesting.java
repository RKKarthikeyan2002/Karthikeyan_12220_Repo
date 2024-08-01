package com.karthi.automationtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class StockAutomationTesting {

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
		driver.get("http://localhost:3000/addStock");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Bat");
		driver.findElement(By.name("quantity")).sendKeys("265");
		driver.findElement(By.name("price")).sendKeys("5698");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Stock added successfully", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testAddStockFaliure1() throws InterruptedException {
		driver.get("http://localhost:3000/addStock");
		driver.manage().window().maximize();
		driver.findElement(By.name("quantity")).sendKeys("265");
		driver.findElement(By.name("price")).sendKeys("5698");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Please enter Product Name", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testAddStockFaliure2() throws InterruptedException {
		driver.get("http://localhost:3000/addStock");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Bat");
		driver.findElement(By.name("price")).sendKeys("5698");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Please enter Available Quantity", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testAddStockFaliure3() throws InterruptedException {
		driver.get("http://localhost:3000/addStock");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Bat");
		driver.findElement(By.name("quantity")).sendKeys("265");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Please enter Product Price", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testUpdateStockSuccess() throws InterruptedException {
		driver.get("http://localhost:3000/viewStock");
		driver.manage().window().maximize();
		driver.findElement(By.id("update3")).click();
		driver.findElement(By.name("productName")).clear();
		driver.findElement(By.name("productName")).sendKeys("Yonex Badminton Racquet 7000");
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("17");
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("100009");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertTrue(true);
		driver.switchTo().alert().accept();
	}

	@Test
	public void testUpdateStockFaliure1() throws InterruptedException {
		driver.get("http://localhost:3000/viewStock");
		driver.manage().window().maximize();
		driver.findElement(By.id("update3")).click();
		driver.findElement(By.name("productName")).clear();
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Please enter Product Name", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testUpdateStockFaliure2() throws InterruptedException {
		driver.get("http://localhost:3000/viewStock");
		driver.manage().window().maximize();
		driver.findElement(By.id("update3")).click();
		driver.findElement(By.name("quantity")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Please enter Available Quantity", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testUpdateStockFaliure3() throws InterruptedException {
		driver.get("http://localhost:3000/viewStock");
		driver.manage().window().maximize();
		driver.findElement(By.id("update3")).click();
		driver.findElement(By.name("price")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Please enter Product Price", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	public void testDeleteStock() throws InterruptedException {
		driver.get("http://localhost:3000/viewStock");
		driver.manage().window().maximize();
		driver.findElement(By.name("delete16")).click();
		Thread.sleep(3000);
		assertEquals("Do you want to delete?", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		assertEquals("Record deleted successfully", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
}
