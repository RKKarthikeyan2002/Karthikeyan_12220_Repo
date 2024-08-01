package com.karthi.manualtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManualTestingBackEndApplicationTests {

	private WebDriver driver;

	@BeforeEach
	void initialize() {
		driver = new ChromeDriver();
	}

	@AfterEach
	void closeConnection() {
		driver.quit();
	}
	
	@Test
	void navbarStock() {
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
	
	@Test
	public void testAddStockSuccess() throws InterruptedException {
		driver.get("http://localhost:3000/addStock");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Bat");
		driver.findElement(By.name("quantity")).sendKeys("265");
		driver.findElement(By.name("price")).sendKeys("5698");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Stock added successfully", "Stock added successfully");
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
	
//	@Test
//	public void testDeleteStock() throws InterruptedException {
//		driver.get("http://localhost:3000/viewStock");
//		driver.manage().window().maximize();
//		driver.findElement(By.name("delete20")).click();
//		Thread.sleep(3000);
//		assertEquals("Do you want to delete?", driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//		Thread.sleep(3000);
//		assertEquals("Record deleted successfully", driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//	}
	
	@Test
	public void testAddPurchaseSuccess() throws InterruptedException {
		driver.get("http://localhost:3000/addPurchase");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Ball");
		driver.findElement(By.name("quantity")).sendKeys("2");
		driver.findElement(By.name("totalPrice")).sendKeys("600");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Stock Purchased successfully", "Stock Purchased successfully");
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
		assertEquals("Please select Product Name", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
//	@Test
//	public void testDeletePurchase() throws InterruptedException {
//		driver.get("http://localhost:3000/viewPurchase");
//		driver.manage().window().maximize();
//		driver.findElement(By.name("delete5")).click();
//		Thread.sleep(3000);
//		assertEquals("Do you want to delete?", driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//		Thread.sleep(3000);
//		assertEquals("Record deleted successfully", driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();
//	}

}
