package com.virgin.games.pages;

import com.virgin.games.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Allow all cookies']")
    WebElement allowCookies;
    //label[normalize-space()='Allow all cookies']

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome to Virgin Games']")
    WebElement welcomeText;
    //h1[normalize-space()='Welcome to Virgin Games']

    @CacheLookup
    @FindBy(xpath = "//ul[@class='StyledNavigationMenuList-sc-v46bks-1 ctndtu nav-bar']//li")
    List<WebElement> allTabs;
    //ul[@class='StyledNavigationMenuList-sc-v46bks-1 ctndtu nav-bar']//li

    @CacheLookup
    @FindBy(id = "provider-legal-lines")
    WebElement legal;
    //provider-legal-lines

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Modern Slavery Statement']")
    WebElement modern;
    //a[normalize-space()='Modern Slavery Statement']

    @CacheLookup
    @FindBy(className = "jss32")
    WebElement statement;
    //className =jss32


    public void clickOnAllowAllCookies() {
        try {
            (allowCookies).click();
            log.info("click on : " + allowCookies.toString());
        } catch (Exception e) {
            js.executeScript("argument[0].click;", driver.findElement(By.xpath("//label[normalize-space()='Allow all cookies']")));
        }
        log.info("Click on Allow all cookies : " + allowCookies.toString());
    }

    public Boolean verifyHomepage() {
        log.info("verifying HomePage URL : " + driver.getCurrentUrl());
        //System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl().contains("https://www.virgingames.com/");
    }

    public String verifyWelcomeTextIsVisible() {
        log.info("Get text from : " + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void clickOnTheOnTopMenu(String tab) {
        for (WebElement menu : allTabs) {
            if (menu.getText().equalsIgnoreCase(tab)) {
                clickOnElement(menu);
                log.info("Clicking on the" + tab + " : " + allTabs.toString());
                break;
            }
        }
    }

    public boolean navigatedToTheClickedSuccessfully(String tabPage) {
        log.info("Verifying top menu Webpage : " + welcomeText.toString());
        return driver.getCurrentUrl().contains(tabPage);
    }

    public void goDownToLegalLines() {
        int deltaY = legal.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
        log.info("scroll To Play Responsibly");

    }

    public void clickOnModernSlaveryStatement() {
        try {
            (modern).click();
            log.info("click on : " + modern.toString());
        } catch (Exception e) {
            js.executeScript("argument[0].click;", driver.findElement(By.xpath("//a[normalize-space()='Modern Slavery Statement']")));
        }
        log.info("Click on Allow all cookies : " + modern.toString());
    }

    public String navigateToPageSuccessfully() {
        log.info("Verifying top menu Webpage : " + statement.toString());
        return getTextFromElement(statement);
    }

    public boolean verifyPageTheURL() {
        log.info("Verifying the page  : " + driver.getCurrentUrl());
        return driver.getCurrentUrl().contains("https://www.virgingames.com/modern-slavery-policy");
    }

}