package com.kameleoon.test;

import com.kameleoon.helpers.WebDriverHelper;
import com.kameleoon.wrappers.LoginPage;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Log in to Kameleoon (https://back-office.kameleoon.com/) with the login "test-selenium" and password "Selenium".
 * Check that the page loads OK. Then click on button "All tests".
 * Check that the page loads OK. Then verify that there is a row displayed with the name of the test "Other test" and in status Running (check the presence of the icon).
 */
public class SeleniumTest1 {
    
    @Test
    public void testSimple() throws Exception {
        
        LoginPage loginPage = new LoginPage();
        
        loginPage.Open();
        loginPage.Login("test-selenium", "Selenium");
        
        WebDriver driver = WebDriverHelper.getDriver();
        
        driver.findElement(By.xpath("//a[contains(text(), \"All tests\")]")).click();
        
        List<WebElement> allTests = driver.findElements(By.className("dashboard-card"));
        
        WebElement otherTest = WebDriverHelper.getElementByCondition(allTests, By.linkText("Other test"));
        Assert.assertNotNull(otherTest);
        
        WebElement status = WebDriverHelper.getElementByCondition(allTests, By.cssSelector("div.status"));
        Assert.assertEquals("Running", status.getText());
        
        driver.quit();
    }  
}
