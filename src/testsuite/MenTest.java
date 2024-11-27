package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        //Mouse Hover on the ‘Men’ Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));

        //Mouse Hover on the ‘Bottoms’
        mouseHoverToElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));

        //Click on the ‘Pants’
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));

        //Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the size 32.
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

        //Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the Color Black.
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        //Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the ‘Add To Cart’ Button.
        mouseHoverAndClickOnElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));

        //Verify the text
        //‘You added Cronus Yoga Pant to your shopping cart.’
        String verifyText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).trim().split("\n ")[0];
        verifyText("Invalid Display You added Cronus Yoga Pant to your shopping cart", "You added Cronus Yoga Pant to your shopping cart.", verifyText);

        //Click on the ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the text ‘Shopping Cart.’
        String shoppingCartText = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyText("Invalid Shopping Cart", "Shopping Cart", shoppingCartText);

        //Verify the product name ‘Cronus Yoga Pant’
        String yogaPantProduct = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        verifyText("Invalid Cronus Yoga Pant", "Cronus Yoga Pant", yogaPantProduct);

        //Verify the product size ‘32’
        String productSize = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        verifyText("Invalid Number", "32", productSize);


        //Verify the product color ‘Black’
        String productColor = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        verifyText("Invalid color", "Black", productColor);


    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
