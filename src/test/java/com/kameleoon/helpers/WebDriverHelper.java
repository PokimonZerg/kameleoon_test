package com.kameleoon.helpers;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {
    public static WebDriver getDriver() {
        if (driver == null)
            driver = new ChromeDriver();
        
        return driver;
    }
    
    public static void quitDriver() {
        if (driver == null)
            return;
        
        driver.quit();
        driver = null;
    }
    
    public static int getDefaultTimeout() {
        return 30;
    }
    
    public static WebElement getElementByCondition(List<WebElement> elements, By condition) {
        for (WebElement e : elements) {
            List<WebElement> result = e.findElements(condition);
            
            if (!result.isEmpty())
                return result.get(0);
        }
        
        return null;
    }
    
    private static WebDriver driver;
}
