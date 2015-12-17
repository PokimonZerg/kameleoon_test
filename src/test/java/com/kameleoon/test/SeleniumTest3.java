package com.kameleoon.test;

import com.kameleoon.helpers.WebDriverHelper;
import com.kameleoon.wrappers.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Log in to Kameleoon (https://back-office.kameleoon.com/) with the login "test-selenium" and password "Selenium".
 * Check that the page loads OK. Click on the Preferences icon (wheel, at top right).
 * Check that the page loads OK. Now click on the link below Reporting
 * Check that the page loads OK. Now click on Google Universal Analytics icon.
 * Check that the page loads OK. Now click on the Preferences icon again.
 * Check that the page loads OK. Now check that under reporting there is written the number "2" in the link (before the names of the tools).
 * Click on the link again, then click on Universal Analytics on the left menu, then remove this tool (by clicking on the Trash icon).
 * Go one last time on the Preferences page, and check that under reporting there is only 1 reporting tool (Kameleoon).
 */
public class SeleniumTest3 {
    
    @Test
    public void testSimple() throws Exception {
        
        LoginPage loginPage = new LoginPage();
        
        loginPage.Open();
        loginPage.Login("test-selenium", "Selenium");
        
        WebDriver driver = WebDriverHelper.getDriver();
        
        WebElement prefIcon = driver.findElement(By.cssSelector("a.kameleoon-preference"));
        prefIcon.click();
        
        WebElement reportLink = driver.findElement(By.xpath("//div[div/text() = \"reporting\"]/span/a"));
        reportLink.click();
        
        WebElement googleLink = driver.findElement(By.cssSelector("a[reportingtool = \"useUniversalAnalytics\"]"));
        googleLink.click();

        prefIcon = driver.findElement(By.cssSelector("a.kameleoon-preference"));
        prefIcon.click();
        
        reportLink = driver.findElement(By.xpath("//div[div/text() = \"reporting\"]/span/a"));
        Assert.assertEquals("2", reportLink.findElement(By.tagName("strong")).getText());
        
        reportLink = driver.findElement(By.xpath("//div[div/text() = \"reporting\"]/span/a"));
        reportLink.click();
        googleLink = driver.findElement(By.cssSelector("a[reportingtool = \"useUniversalAnalytics\"]"));
        googleLink.click();
        
        WebElement removeButton = driver.findElement(By.cssSelector("p#remove-reporting-tool a"));
        removeButton.click();
        WebElement validateButton = driver.findElement(By.xpath("//button[contains(text(), \"Validate\")]"));
        validateButton.click();            
                
        prefIcon = driver.findElement(By.cssSelector("a.kameleoon-preference"));
        prefIcon.click();
        reportLink = driver.findElement(By.xpath("//div[div/text() = \"reporting\"]/span/a"));
        Assert.assertEquals("1", reportLink.findElement(By.tagName("strong")).getText());
        
        driver.quit();
    }
}
