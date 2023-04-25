package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //* Verify the text “PRODUCTS”
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Products')]"),"Products");
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
       // Verify that six products are displayed on page
       // String name = verifyVisibleText(By.xpath("//span[text()='Products']"));
       // System.out.println(name);
        int product = countProductOnThePage(By.className("inventory_item"));
        System.out.println("Total products: " + product);



    }
    @After
    public void tearDown(){
       // closeBrowser();
    }
}
