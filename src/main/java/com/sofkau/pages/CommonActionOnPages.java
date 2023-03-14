package com.sofkau.pages;

import org.openqa.selenium.*;

public class CommonActionOnPages {
    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    //polimosfirmo
    // protected void typeInto(WebElement webElement, String value) {
    //   webElement.sendKeys(value);
    // }

    protected void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    //   protected void clearText(WebElement webElement) {
    //     webElement.clear();
    // }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }


    public void clickElement(WebElement element) {
        element.click();
    }

    protected void selectDate(By locator, String value) {

        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }

    public void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    /**
     * para realizar la comparacion, como se hace
     *
     * @param locator
     * @return
     */

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }


}
