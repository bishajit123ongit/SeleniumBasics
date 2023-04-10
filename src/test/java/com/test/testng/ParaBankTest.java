package com.test.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParaBankTest extends BaseParaBankTest {

    @Test(priority = 0)
    public void verifyTitleSucceed() throws InterruptedException {
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle().trim(), "ParaBank | Welcome | Online Banking");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void verifyLoginPageShouldSucceed() throws InterruptedException {
        String loginText = driver.findElement(By.cssSelector("#leftPanel h2")).getText().trim();
        Assert.assertEquals(loginText, "Customer Login");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void loginShouldSucceed() throws InterruptedException {
        WebElement userNameEl = driver.findElement(By.name("username"));
        userNameEl.clear();
        userNameEl.sendKeys("bis");

        WebElement userPassEl = driver.findElement(By.name("password"));
        userPassEl.clear();
        userPassEl.sendKeys("bis");

        driver.findElement(By.cssSelector("input.button")).click();
        Thread.sleep(3000);

        String logoutLinkText = driver.findElement(By.linkText("Log Out")).getText().trim();
        Assert.assertEquals(logoutLinkText, "Log Out");
        Thread.sleep(2000);
    }
}
