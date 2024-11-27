package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter(){

        clickOnElement(By.xpath("//p[contains(text(),'Consent')]"));
        //Mouse Hover on the ‘Women’ Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));

        //Mouse Hover on the ‘Tops’
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //Click on the ‘Jackets’
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Product Name");

        //Verify the product name displayed in alphabetical order
        List<WebElement> productNames = driver.findElements(By.xpath("//li//div[1]//div[1]//strong[1]/a"));

        //store product name in the actualProductName List.
        List<String> actualProductsName = new ArrayList<>();
        for (WebElement product : productNames) {
//            System.out.println(product.getText());
            actualProductsName.add(product.getText());
        }


    }

    @Test
    public void verifyTheSortByPriceFilter(){


        clickOnElement(By.xpath("//p[contains(text(),'Consent')]"));
        //Mouse Hover on the ‘Women’ Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));

        //Mouse Hover on the ‘Tops’
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //Click on the ‘Jackets’
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");

        //Verify the product price displayed in Low to High
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));

        List<String> actualPrice = new ArrayList<>(); // add actual price in this list
        for (WebElement price : priceElements) {
            actualPrice.add(price.getText());
        }

        List<String> expectedPriceOrder = new ArrayList<>(actualPrice);
        Collections.sort(expectedPriceOrder);
        Assert.assertEquals("Price are not displayed in the Low to High order", expectedPriceOrder, actualPrice);

        }



    @After
    public void tearDown() {
        //closeBrowser();
    }


}
