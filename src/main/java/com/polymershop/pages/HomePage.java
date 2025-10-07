package com.polymershop.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private SearchContext getShopAppShadowRoot() {
        try {
            // Wait for page load
            Thread.sleep(2000);

            // Wait for shop-app and get its shadow root
            WebElement shopApp = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("shop-app")));
            return wait.until(driver -> {
                try {
                    return shopApp.getShadowRoot();
                } catch (Exception e) {
                    return null;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to get shop-app shadow root: " + e.getMessage());
        }
    }

    public void navigateToMenCategory() {
        try {
            SearchContext shopAppRoot = getShopAppShadowRoot();
            
            // Wait for shop-home
            WebElement shopHome = wait.until(driver -> {
                try {
                    return (WebElement) shopAppRoot.findElement(By.cssSelector("shop-home"));
                } catch (Exception e) {
                    return null;
                }
            });

            SearchContext shopHomeRoot = shopHome.getShadowRoot();

            // Find and click men's category link
            WebElement menLink = wait.until(driver -> {
                try {
                    return (WebElement) shopHomeRoot.findElement(By.cssSelector("a[href='/list/mens_outerwear']"));
                } catch (Exception e) {
                    return null;
                }
            });

            menLink.click();

            // Wait for navigation
            wait.until(ExpectedConditions.urlContains("mens_outerwear"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate to men's category: " + e.getMessage());
        }
    }

    public void navigateToWomenCategory() {
        try {
            SearchContext shopAppRoot = getShopAppShadowRoot();
            
            // Wait for shop-home
            WebElement shopHome = wait.until(driver -> {
                try {
                    return (WebElement) shopAppRoot.findElement(By.cssSelector("shop-home"));
                } catch (Exception e) {
                    return null;
                }
            });

            SearchContext shopHomeRoot = shopHome.getShadowRoot();

            // Find and click women's category link
            WebElement womenLink = wait.until(driver -> {
                try {
                    return (WebElement) shopHomeRoot.findElement(By.cssSelector("a[href='/list/ladies_outerwear']"));
                } catch (Exception e) {
                    return null;
                }
            });

            womenLink.click();

            // Wait for navigation
            wait.until(ExpectedConditions.urlContains("ladies_outerwear"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate to women's category: " + e.getMessage());
        }
    }

    public boolean isPageLoaded() {
        try {
            SearchContext shopAppRoot = getShopAppShadowRoot();
            WebElement toolbar = wait.until(driver -> {
                try {
                    return (WebElement) shopAppRoot.findElement(By.cssSelector("app-toolbar"));
                } catch (Exception e) {
                    return null;
                }
            });
            return toolbar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}