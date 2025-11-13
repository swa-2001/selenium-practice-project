package com.swathi.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
public class LoginTest {

	WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() throws InterruptedException {
        // 🧭 Load local HTML file
        File file = new File("src/test/resources/login.html");
        String filePath = "file:///" + file.getAbsolutePath();
        driver.get(filePath);

        Thread.sleep(1000);

        // 🧾 Fill username and password
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        // 🧠 Click login
        driver.findElement(By.id("loginBtn")).click();

        Thread.sleep(1000);

        // ✅ Verify result message
        WebElement msg = driver.findElement(By.id("message"));
        System.out.println("Message displayed: " + msg.getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
