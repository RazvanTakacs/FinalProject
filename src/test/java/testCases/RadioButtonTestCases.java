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

    @Test (priority = 1)
    public void doNotSelectAValueAndClickOnTheGetCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnGetValueButton();
        String actualMessage = radioButtonPage.getYourDisplayedMessage();
        Assert.assertEquals(actualMessage,"Radio button is Not checked");
    }

    @Test (priority = 2)
    public void selectTheMaleRadioButtonToTestIfTheButtonIsSelected() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnMaleRadioButton();
        Assert.assertTrue(radioButtonPage.isMaleRadioButtonSelected());
    }

    @Test (priority = 3)
    public void selectTheMaleRadioButtonThenTheFemaleRadioButtonToTestIfMaleRadioButtonIsUnSelected() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnMaleRadioButton();
        radioButtonPage.clickOnFemaleRadioButton();
        Assert.assertTrue(radioButtonPage.isFemaleRadioButtonSelected());
        Assert.assertFalse(radioButtonPage.isMaleRadioButtonSelected());
    }

    @Test (priority = 4)
    public void selectTheMaleRadioButtonAndClickGetCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnMaleRadioButton();
        radioButtonPage.clickOnGetValueButton();
        Assert.assertTrue(driver.getPageSource().contains("Radio button 'Male' is checked"));
    }

    @Test (priority = 5)
    public void selectTheFemaleRadioButtonAndClickGetCheckedValueButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnFemaleRadioButton();
        radioButtonPage.clickOnGetValueButton();
        Assert.assertTrue(driver.getPageSource().contains("Radio button 'Female' is checked"));
    }

    @Test (priority = 6)
    public void selectTheGroupMaleRadioButtonAndClickGetValuesButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnGroupMaleRadioButton();
        radioButtonPage.clickOnTheGetValuesButton();
        String actualGender = radioButtonPage.getYourGender();
        Assert.assertEquals(actualGender,"Gender : Male");
    }

    @Test (priority = 7)
    public void selectMaleThanFemaleGroupRadioButtonsToTestIfGenderValueChanges() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnGroupMaleRadioButton();
        radioButtonPage.clickOnTheGetValuesButton();
        String actualGender = radioButtonPage.getYourGender();
        Assert.assertEquals(actualGender,"Gender : Male");
        radioButtonPage.clickOnGroupFemaleRadioButton();
        radioButtonPage.clickOnTheGetValuesButton();
        String newActualGender = radioButtonPage.getYourGender();
        Assert.assertEquals(newActualGender,"Gender : Female");
    }

    @Test (priority = 8)
    public void selectGenderAndAgeGroupToTestIfBothValuesAreDisplayed() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[3]/a")).click();
        radioButtonPage.clickOnGroupOtherRadioButton();
        radioButtonPage.clickOnAgeGroupZeroToFive();
        radioButtonPage.clickOnTheGetValuesButton();
        String Gender = radioButtonPage.getYourGender();
        Assert.assertEquals(Gender,"Gender : Other");
        String AgeGroup = radioButtonPage.getYourAgeGroup();
        Assert.assertEquals(AgeGroup,"Age : 0 - 5");
    }
}