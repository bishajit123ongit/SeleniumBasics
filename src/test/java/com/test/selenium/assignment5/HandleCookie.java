package com.test.selenium.assignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class HandleCookie {
    public static void main(String[] args) {
        try{
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.lambdatest.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Cookie cname = new Cookie("myCookie", "12345678999");
            driver.manage().addCookie(cname);
            Set<Cookie> cookiesList = driver.manage().getCookies();
            System.out.println("Size-> "+ cookiesList.size());
            for (Cookie getcookies : cookiesList) {
                System.out.println(getcookies);
            }
            Cookie cookieValue = driver.manage().getCookieNamed("myCookie");
            System.out.println("test-> "+cookieValue.getValue());

            //delete the newly created cookie
            driver.manage().deleteCookie(cname);
            Set<Cookie> cookiesListNew =  driver.manage().getCookies();
            for(Cookie getcookies :cookiesListNew) {
                System.out.println(getcookies );
            }

            //delete cookie
            driver.manage().deleteAllCookies();
            Set<Cookie> cookiesListNew2 =  driver.manage().getCookies();
            cookiesListNew2.size();
            System.out.println("The size is "+cookiesListNew2);
            driver.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
