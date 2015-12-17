package com.kameleoon.wrappers;

import com.kameleoon.helpers.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    
    private final WebDriver driver;
    
    public LoginPage() {
        driver = WebDriverHelper.getDriver();
    }
    
    public void Open() {
        driver.get("https://back-office.kameleoon.com/");
        
        (new WebDriverWait(driver, WebDriverHelper.getDefaultTimeout())).until(ExpectedConditions.presenceOfElementLocated(By.id("kamBlocForm")));
        
        loginInput = driver.findElement(By.id("kamInputLogin"));
        passwordInput = driver.findElement(By.id("kamInputPassword"));
        loginButton = driver.findElement(By.id("kamBlocSignin"));
    }
    
    public void Login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        
        loginButton.click();
        
        (new WebDriverWait(driver, WebDriverHelper.getDefaultTimeout())).until(ExpectedConditions.presenceOfElementLocated(By.className("bo-header")));
    }
    
    private WebElement loginInput;
    private WebElement passwordInput;
    private WebElement loginButton;
}
