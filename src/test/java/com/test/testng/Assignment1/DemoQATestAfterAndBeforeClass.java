package com.test.testng.Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoQATestAfterAndBeforeClass extends BaseDemoQATestAfterAndBeforeClass{

    @Test(priority = 0)
    public void goToTheDownMenu() throws InterruptedException {
        System.out.println("Test one");
        WebElement element = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]//preceding::div[contains(@class,'avatar mx-auto white')]"));
        scrollToElement(driver,element);
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void verifyMenu(){
        System.out.println("Test two");
        WebElement elementMenu = driver.findElement(By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-0']"));
        checkVisibility(driver,elementMenu);

    }

    @Test(priority = 2)
    public void formSubmit(){
        System.out.println("Test three");
        WebElement elementFirstName = driver.findElement(By.xpath("//input[@id='userName']"));
        checkVisibility(driver,elementFirstName);


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

    }

}
