package testCases;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SimpleFormPage;


public class SimpleFormTestCases extends BasePage {
    private SimpleFormPage simpleFormPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        simpleFormPage = new SimpleFormPage(driver);
    }

    @Test(priority = 2)
    public void testIfTheInputFieldAcceptsText() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.selectTextField("Test");
        Assert.assertTrue(driver.getPageSource().contains("Test"));
    }

    @Test(priority = 1)
    public void doNotWriteTextThenClickOnTheCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.clickOnGetCheckedValue();
        String actualText = simpleFormPage.getYourDisplayedMessage();
        Assert.assertEquals(actualText, "");
    }

    @Test (priority = 3)
    public void writeTextThenClickOnTheCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.selectTextField("Test");
        simpleFormPage.clickOnGetCheckedValue();
        String actualText = simpleFormPage.getYourDisplayedMessage();
        Assert.assertEquals(actualText, "Test");
    }

    @Test (priority = 4)
    public void doNotWriteTextThenClickOnTheGetValuesButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.clickOnGetValuesButton();
        String actualSum = simpleFormPage.getYourDisplayedSum();
        Assert.assertEquals(actualSum, "Entered value is not a number");
    }

    @Test (priority = 5)
    public void writeANumberInTheFirstInputField() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.selectTextFieldForA("5");
        simpleFormPage.clickOnGetValuesButton();
        String actualSum = simpleFormPage.getYourDisplayedSum();
        Assert.assertEquals(actualSum, "Entered value is not a number");
    }

    @Test (priority = 6)
    public void writeANumberInTheSecondInputField() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.selectTextFieldForB("5");
        simpleFormPage.clickOnGetValuesButton();
        String actualSum = simpleFormPage.getYourDisplayedSum();
        Assert.assertEquals(actualSum, "Entered value is not a number");
    }

    @Test (priority = 7)
    public void writeNumbersInBothInputFields() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.selectTextFieldForA("5");
        simpleFormPage.selectTextFieldForB("5");
        simpleFormPage.clickOnGetValuesButton();
        String actualSum = simpleFormPage.getYourDisplayedSum();
        Assert.assertEquals(actualSum,"10");
    }

    @Test (priority = 8)
    public void writeANumberInTheFirstInputFieldAndTextInTheSecond() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[1]/a")).click();
        simpleFormPage.selectTextFieldForA("5");
        simpleFormPage.selectTextFieldForB("Test");
        simpleFormPage.clickOnGetValuesButton();
        String actualSum = simpleFormPage.getYourDisplayedSum();
        Assert.assertEquals(actualSum,"NaN");
    }
}

