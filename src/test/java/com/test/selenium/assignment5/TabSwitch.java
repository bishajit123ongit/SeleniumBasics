package com.test.selenium.assignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;

public class TabSwitch {
    public static void main(String[] args) {

        try{
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://demoqa.com/browser-windows");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            String originalWindow = driver.getWindowHandle();
            driver.findElement(By.id("tabButton")).click();
            driver.switchTo().newWindow(WindowType.TAB);
            driver.navigate().to("https://demoqa.com/sample");
            System.out.println(driver.findElement(By.id("sampleHeading")).getText());

            Set<String> windows = driver.getWindowHandles();
            System.out.println(windows.size());
            Thread.sleep(5000);
            driver.close();
            driver.switchTo().window(originalWindow);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
