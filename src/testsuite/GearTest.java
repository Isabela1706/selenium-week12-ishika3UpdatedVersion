package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){

        clickOnElement(By.xpath("//p[contains(text(),'Consent')]"));

        //Mouse Hover on the ‘Gear’ Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));

        //Click on the ‘Bags’
        clickOnElement(By.xpath("//span[contains(text(),'Bags')]"));

        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        //Verify the text ‘Overnight Duffle’
        String overnightDuffleText = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyText("Invalid Overnight Duffle", "Overnight Duffle", overnightDuffleText);

        //Change the Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextElement(By.id("qty"), "3");


        //Click on the ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));

        //Verify the text
        //‘You added Overnight Duffle to your shopping cart.’
        String textMessageVerify = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).trim().split("\n ")[0];
        verifyText("Invalid message display ", "You added Overnight Duffle to your shopping cart.", textMessageVerify);

        //Click on the ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the product name ‘Overnight Duffle’
        String productName = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        verifyText("Invalid Product Name", "Overnight Duffle", productName);

        //Verify the Qty is ‘3’
        Assert.assertEquals("3", driver.findElement(By.xpath("//input[@class='input-text qty']")).getAttribute("value"));

        //Verify the product price ‘$135.00’
        String productPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"));
        verifyText("Invalid Price", "$135.00", productPrice);


        //Change the Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextElement((By.xpath("//input[@class='input-text qty']")),"5");



        //Click on the ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        //Verify the product price ‘$225.00’
        String totalProductPrice = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
     verifyText("Invalid Products Total", "$225.00", totalProductPrice );




    }
    @After
    public void tearDown() {
        closeBrowser();
    }


}
