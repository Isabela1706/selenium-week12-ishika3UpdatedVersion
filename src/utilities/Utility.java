package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will click on element
     *
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     *
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    /**
     * This will accept Alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    /**
     * This method will dismiss to alert
     *
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    /**
     * This method will get text alert
     */
    public String getTextAlert(By by){
        return driver.switchTo().alert().getText();
    }
    /**
     * This method will send text from alert
     *
     */
    public void sendTextAlert(By by, String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //****************Select Class Method**********

    /**
     * This method will select option by value form dropdown
     *
     */
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropdown = driver.findElement(by);
        //Create the object of select class
        Select select = new Select(dropdown);
        //Select by visible text
        select.selectByValue(value);
    }
    /**
     * Select by visible text from dropdown
     */
    public void selectByVisibleTextFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(value);



    }
    /**
     * Select by index from dropdown
     */
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //*********************************************
    //             Select action Method


    /**
     * mouse hover to element
     */
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(by)).build().perform();

    }
    public void mouseHoverAndClickOnElement(By by){
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(by)).click().build().perform();

    }
    /**
     * This method will verify text
     */
    public void verifyText(String displayMessage, String expectedText, String actualText){
        Assert.assertEquals(displayMessage, expectedText, actualText);

    }
    public void selectMenu(String Menu){
        clickOnElement(By.xpath("//a[normalize-space()='"+Menu+"]"));

    }
}
