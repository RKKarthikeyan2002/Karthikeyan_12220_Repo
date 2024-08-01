package com.karthi.manualtesting.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.karthi.manualtesting.service.PurchaseService;

@SpringBootTest
class PurchaseServiceImpliTest {

	@Autowired
	PurchaseService purchaseService;
	
	WebDriver driver;
	
	@BeforeEach
	void init() {
		driver = new ChromeDriver();
	}
	
	@AfterEach
	void closeConnection() {
		driver.close();
	}

	@Test
	void testGetAllPurchases() {
		assertEquals(4, purchaseService.getAllPurchases().size());
	}

	@Test
	void testGetPurchaseById() {
		assertNotNull(purchaseService.getPurchaseById(7));
	}

}
