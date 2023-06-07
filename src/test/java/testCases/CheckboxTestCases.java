package testCases;

import com.beust.ah.A;
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


    @Test (priority = 1)
    public void clickOnTheSingleCheckbox() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnSingleCheckbox();
        String actualMessage = checkboxPage.getYourDisplayedMessage();
        Assert.assertEquals(actualMessage, "Checked");
    }

    @Test (priority = 2)
    public void testIfTheCheckboxIsToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnSingleCheckbox();
        Assert.assertTrue(checkboxPage.isSingleCheckboxSelected());
    }

    @Test (priority = 3)
    public void clickOnTheCheckAllButtonToTestIfTheValueChanges() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        String initialValue = checkboxPage.getYourInitialValue();
        checkboxPage.clickOnCheckUncheckAllButton();
        String newValue = checkboxPage.getYourNewValue();
        Assert.assertNotEquals(newValue, initialValue);
    }

    @Test (priority = 4)
    public void clickOnTheCheckAllButtonToTestIfAllCheckboxesAreToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnCheckUncheckAllButton();
        Assert.assertTrue(checkboxPage.isCheckboxOption1Selected());
        Assert.assertTrue(checkboxPage.isCheckboxOption2Selected());
        Assert.assertTrue(checkboxPage.isCheckboxOption3Selected());
        Assert.assertTrue(checkboxPage.isCheckboxOption4Selected());
    }

    @Test (priority = 5)
    public void clickOnTheUncheckAllButtonToTestIfAllCheckboxesAreUnToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnCheckUncheckAllButton();
        checkboxPage.clickOnCheckUncheckAllButton();
        Assert.assertFalse(checkboxPage.isCheckboxOption1Selected());
        Assert.assertFalse(checkboxPage.isCheckboxOption2Selected());
        Assert.assertFalse(checkboxPage.isCheckboxOption3Selected());
        Assert.assertFalse(checkboxPage.isCheckboxOption4Selected());
    }

    @Test (priority = 6)
    public void clickOnEachCheckboxToTestIfTheyAreToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnCheckboxOption1();
        Assert.assertTrue(checkboxPage.isCheckboxOption1Selected());
        checkboxPage.clickOnCheckboxOption2();
        Assert.assertTrue(checkboxPage.isCheckboxOption2Selected());
        checkboxPage.clickOnCheckboxOption3();
        Assert.assertTrue(checkboxPage.isCheckboxOption3Selected());
        checkboxPage.clickOnCheckboxOption4();
        Assert.assertTrue(checkboxPage.isCheckboxOption4Selected());
    }

    @Test (priority = 7)
    public void clickOnEachToggledCheckboxToTestIfTheyAreUnToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnCheckUncheckAllButton();
        checkboxPage.clickOnCheckboxOption1();
        Assert.assertFalse(checkboxPage.isCheckboxOption1Selected());
        checkboxPage.clickOnCheckboxOption2();
        Assert.assertFalse(checkboxPage.isCheckboxOption2Selected());
        checkboxPage.clickOnCheckboxOption3();
        Assert.assertFalse(checkboxPage.isCheckboxOption3Selected());
        checkboxPage.clickOnCheckboxOption4();
        Assert.assertFalse(checkboxPage.isCheckboxOption4Selected());
    }

    @Test (priority = 8)
    public void toggleTwoOptionsAndClickOnCheckAllButtonToTestIfAllOptionsAreToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnCheckboxOption1();
        Assert.assertTrue(checkboxPage.isCheckboxOption1Selected());
        checkboxPage.clickOnCheckboxOption3();
        Assert.assertTrue(checkboxPage.isCheckboxOption3Selected());
        checkboxPage.clickOnCheckUncheckAllButton();
        Assert.assertTrue(checkboxPage.isCheckboxOption1Selected());
        Assert.assertTrue(checkboxPage.isCheckboxOption2Selected());
        Assert.assertTrue(checkboxPage.isCheckboxOption3Selected());
        Assert.assertTrue(checkboxPage.isCheckboxOption4Selected());
    }

    @Test (priority = 9)
    public void unToggleTwoOptionsAndClickOnUncheckAllButtonToTestIfAllOptionsAreUnToggled() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/ul/li[2]/a")).click();
        checkboxPage.clickOnCheckUncheckAllButton();
        checkboxPage.clickOnCheckboxOption2();
        Assert.assertFalse(checkboxPage.isCheckboxOption2Selected());
        checkboxPage.clickOnCheckboxOption4();
        Assert.assertFalse(checkboxPage.isCheckboxOption4Selected());
        checkboxPage.clickOnCheckUncheckAllButton();
        Assert.assertFalse(checkboxPage.isCheckboxOption1Selected());
        Assert.assertFalse(checkboxPage.isCheckboxOption2Selected());
        Assert.assertFalse(checkboxPage.isCheckboxOption3Selected());
        Assert.assertFalse(checkboxPage.isCheckboxOption4Selected());
    }
}
