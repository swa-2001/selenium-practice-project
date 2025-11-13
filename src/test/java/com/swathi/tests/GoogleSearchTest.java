package com.swathi.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class GoogleSearchTest {

	WebDriver driver;
	
	@BeforeClass 
	public void setup(){
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
	}

	@Test
	public void googleSearch() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.cssSelector("#input"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
        Thread.sleep(2000);
        System.out.println("Page title: " + driver.getTitle());
    }
	
	@AfterClass
    public void tearDown() {
        driver.quit();
    }
}
