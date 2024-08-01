package com.karthi.manualtesting.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karthi.manualtesting.service.StockService;

@SpringBootTest
class StockServiceImpliTest {

	@Autowired
	private StockService stockService;
	
	WebDriver driver;
	
	@BeforeEach
	void init() {
		driver = new ChromeDriver();
	}
	

	@Test
	void testAddStockSuccess() throws InterruptedException {
//		Stock stock = new Stock(0, "Cricket Ball", 124, 249);
//		assertEquals("Success", stockService.addStock(stock));
		
		driver.get("http://localhost:3000/addStock");
		driver.manage().window().maximize();
		driver.findElement(By.name("productName")).sendKeys("Cricket Ball");
		driver.findElement(By.name("quantity")).sendKeys("1289");
		driver.findElement(By.name("price")).sendKeys("300");
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		assertEquals("Stock added successfully", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test
	void testGetStockById() {
		assertNotNull(stockService.getStockById(3));
	}

	@Test
	void testGetAllStocks() {
		assertEquals(2, stockService.getAllStocks().size());
	}

	@Test
	void testGetAllStockNames() {
		assertEquals(2, stockService.getAllStockNames().size());
	}

	@Test
	void testGetStockByProductName() {
		assertNotNull(stockService.getStockByProductName("Cricket Ball"));
	}

}
