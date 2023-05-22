package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckboxPage;

public class CheckboxTestCases extends BasePage {

    private CheckboxPage checkboxPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        checkboxPage = new CheckboxPage(driver);
    }


    @Test
    public void clickOnTheSingleCheckbox() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnSingleCheckbox();
        String actualMessage = checkboxPage.getYourDisplayedMessage();
        Assert.assertEquals(actualMessage,"Success - Check box is checked");
    }

    @Test
    public void testIfTheCheckboxIsToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnSingleCheckbox();
        Assert.assertTrue(checkboxPage.isSingleCheckboxSelected());
    }
}
