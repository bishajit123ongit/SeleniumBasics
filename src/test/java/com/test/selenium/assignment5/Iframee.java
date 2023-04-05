package com.test.selenium.assignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iframee {
    public static void main(String[] args) throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);


        try {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);

//            WebDriverManager.chromedriver().setup();
//            WebDriver driver = new FirefoxDriver();
            driver.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='subscribeBox']//iframe")));
            WebElement subscribe = driver.findElement(By.xpath("//input[@value='Subscribe »']"));
            WebElement guiName = driver.findElement(By.id("name"));
            WebElement guiEmail = driver.findElement(By.id("email"));
            //WebElement subscribe = driver.findElement(By.xpath("//input[@value='Subscribe »']"));
            scrollToElement(driver, guiEmail);
            checkVisibility(driver, guiName);
            guiName.sendKeys("Bishajit Sarkar");
            guiEmail.sendKeys("bishajit00@gmail.com");
            Actions action = new Actions(driver);
            //scrollToElement(driver,driver.findElement(By.xpath("//input[@value='Subscribe »']")));
            action.moveToElement(driver.findElement(By.xpath("//input[@value='Subscribe »']"))).build().perform();
            //driver.findElement(By.xpath("//input[@value='Subscribe »']")).click();
            Thread.sleep(5000);
            driver.switchTo().defaultContent();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void scrollToElement(WebDriver driver, WebElement element) {
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scroll(" + x + ", " + y + ");");
        executor.executeScript("arguments[0].click();", element);
    }

    private static void checkVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
