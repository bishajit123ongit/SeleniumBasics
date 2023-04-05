package com.test.orangehrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestEngine {
    public static void main(String[] args) {

        try {
            //for chromedriver
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);

            //for Firefox
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();

            driver.get("https://demoqa.com/");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //by xpath
            WebElement element = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]//preceding::div[contains(@class,'avatar mx-auto white')]"));
//            Point point = element.getLocation();
//            int x = point.getX();
//            int y = point.getY();
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("window.scroll(" + x + ", " + y + ");");
//            executor.executeScript("arguments[0].click();", element);


            scrollToElement(driver,element);

            //by id
            WebElement elementMenu = driver.findElement(By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-0']"));
            checkVisibility(driver,elementMenu);

            WebElement elementFirstName = driver.findElement(By.xpath("//input[@id='userName']"));
            checkVisibility(driver,elementFirstName);
            elementFirstName.sendKeys("Bishajit Sarkar");

            WebElement elementEmail = driver.findElement(By.cssSelector("input#userEmail"));
            checkVisibility(driver,elementEmail);
            elementEmail.sendKeys("bishajit00@gmail.com");

            WebElement elementCurrentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
            checkVisibility(driver,elementCurrentAddress);
            elementCurrentAddress.sendKeys("Dhaka, Bangladesh");

            WebElement elementPermanentAddress = driver.findElement(By.id("permanentAddress"));
            checkVisibility(driver,elementPermanentAddress);
            elementPermanentAddress.sendKeys("Dhaka, Bangladesh");

            WebElement elementSubmit = driver.findElement(By.id("submit"));
            scrollToElement(driver,elementSubmit);
            checkVisibility(driver,elementSubmit);
            elementSubmit.click();


            //Assignment 3
            WebElement elementMenuTwo = driver.findElement(By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-0']"));
            scrollToElement(driver,elementMenuTwo);
            checkVisibility(driver,elementMenuTwo);

            List<WebElement> listOfSubMenu = driver.findElements(By.cssSelector("li[class^='btn btn-light']"));
            System.out.println(listOfSubMenu);
            int i = 0;
            for(WebElement  webElement : listOfSubMenu){
                if(i==1){
                    webElement.click();
                }
                i++;
            }

            driver.findElement(By.cssSelector("button[title*='Tog']")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Desktop')]")).click();



            Thread.sleep(5000);
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

    private static void checkVisibility(WebDriver driver,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
