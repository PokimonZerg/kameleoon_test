package com.kameleoon.test;

import com.kameleoon.helpers.WebDriverHelper;
import com.kameleoon.wrappers.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Log in to Kameleoon (https://back-office.kameleoon.com/) with the login "test-selenium" and password "Selenium".
 * Check that the page loads OK.
 * Check that the link to the documentation is "http://support.kameleoon.com/hc/en-us" (book icon at top right). WARNING: this check should FAIL, as the link is indeed currently not the correct one. This is normal, the test should not currently pass.
 */
public class TestSelenium2 {
    
    @Test
    public void testSimple() throws Exception {
        
        LoginPage loginPage = new LoginPage();
        
        loginPage.Open();
        loginPage.Login("test-selenium", "Selenium");
        
        WebDriver driver = WebDriverHelper.getDriver();
        
        WebElement docLink = driver.findElement(By.cssSelector("ul.kameleoon-documentation li a"));
        
        Assert.assertEquals("http://support.kameleoon.com/hc/en-us", docLink.getAttribute("href"));
    }
    
    @Before
    public void tearDown() {
        WebDriverHelper.quitDriver();
    }
}
