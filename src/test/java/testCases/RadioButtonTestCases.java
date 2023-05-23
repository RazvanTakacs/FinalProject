package testCases;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckboxPage;
import pages.RadioButtonPage;

public class RadioButtonTestCases extends BasePage {

    private RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test
    public void doNotSelectAValueAndClickOnTheGetCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnGetValueButton();
        String actualMessage = radioButtonPage.getYourDisplayedMessage();
        Assert.assertEquals(actualMessage,"Radio button is Not checked");
    }

    @Test
    public void selectTheMaleRadioButtonToTestIfTheButtonIsSelected() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnMaleRadioButton();
        Assert.assertTrue(radioButtonPage.isMaleRadioButtonSelected());
    }

    @Test
    public void selectTheMaleRadioButtonThenTheFemaleRadioButtonToTestIfMaleRadioButtonIsUnSelected() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnMaleRadioButton();
        radioButtonPage.clickOnFemaleRadioButton();
        Assert.assertTrue(radioButtonPage.isFemaleRadioButtonSelected());
        Assert.assertFalse(radioButtonPage.isMaleRadioButtonSelected());
    }

    @Test
    public void selectTheMaleRadioButtonAndClickGetCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnMaleRadioButton();
        radioButtonPage.clickOnGetValueButton();
        Assert.assertTrue(driver.getPageSource().contains("Radio button 'Male' is checked"));
    }

    @Test
    public void selectTheFemaleRadioButtonAndClickGetCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnFemaleRadioButton();
        radioButtonPage.clickOnGetValueButton();
        Assert.assertTrue(driver.getPageSource().contains("Radio button 'Female' is checked"));
    }
}