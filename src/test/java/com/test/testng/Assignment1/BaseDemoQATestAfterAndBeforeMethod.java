package com.test.testng.Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDemoQATestAfterAndBeforeMethod {
    protected WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    //@AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scroll(" + x + ", " + y + ");");
        executor.executeScript("arguments[0].click();", element);
    }

    public static void checkVisibility(WebDriver driver,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
