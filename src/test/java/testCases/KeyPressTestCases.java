package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.KeyPressPage;

public class KeyPressTestCases extends BasePage {
    private KeyPressPage keyPressPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        keyPressPage = new KeyPressPage(driver);
    }

    @Test(priority = 1)
    public void testIfTheInputFieldAcceptsText() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/ul/li[5]/a")).click();
        keyPressPage.selectInputField("Test");
        Assert.assertTrue(driver.getPageSource().contains("Test"));
    }

    @Test(priority = 2)
    public void testIfTHeInputFieldAcceptsNumbers() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/ul/li[5]/a")).click();
        keyPressPage.selectInputField("5");
        String actualDisplayedMessage = keyPressPage.getYourDisplayedMessage();
        String actualInputMessage = keyPressPage.getInputFieldMessage();
        actualInputMessage = keyPressPage.getLastChar(actualInputMessage);
        Assert.assertEquals(actualDisplayedMessage,"You entered: " + actualInputMessage);
    }

    @Test(priority = 3)
    public void enterALetterAndThenANumberToTestIfTheDisplayedValueChanges() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/ul/li[5]/a")).click();
        keyPressPage.selectInputField("t");
        String actualDisplayedMessage = keyPressPage.getYourDisplayedMessage();
        String actualInputMessage = keyPressPage.getInputFieldMessage();
        actualInputMessage = keyPressPage.getLastChar(actualInputMessage);
        Assert.assertEquals(actualDisplayedMessage,"You entered: " + actualInputMessage);

        keyPressPage.selectInputField("5");
        actualDisplayedMessage = keyPressPage.getYourDisplayedMessage();
        actualInputMessage = keyPressPage.getInputFieldMessage();
        actualInputMessage = keyPressPage.getLastChar(actualInputMessage);
        Assert.assertEquals(actualDisplayedMessage,"You entered: " + actualInputMessage);
    }

    @Test(priority = 4)
    public void testIfTheInputFieldAcceptsArrowKeys()  throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/ul/li[5]/a")).click();
        keyPressPage.selectInputField(Keys.ARROW_DOWN);
        String actualDisplayedMessage = keyPressPage.getYourDisplayedMessage();
        Assert.assertEquals(actualDisplayedMessage,"You entered: DOWN");
    }

    @Test (priority = 5)
    public void testIfTheInputFieldAcceptsNumpadKeys() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/ul/li[5]/a")).click();
        keyPressPage.selectInputField(Keys.NUMPAD5);
        String actualDisplayedMessage = keyPressPage.getYourDisplayedMessage();
        String actualInputMessage = keyPressPage.getInputFieldMessage();
        actualInputMessage = keyPressPage.getLastChar(actualInputMessage);
        Assert.assertEquals(actualDisplayedMessage,"You entered: NUMPAD" + actualInputMessage);
    }
}