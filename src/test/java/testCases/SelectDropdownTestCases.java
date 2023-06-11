package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SelectDropdownPage;

public class SelectDropdownTestCases extends BasePage {
    private SelectDropdownPage selectDropdownPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        selectDropdownPage = new SelectDropdownPage(driver);
    }

//    @Test (priority = 1)
    public void testIfTheFirstElementFromTheListIsDisabled() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        Assert.assertFalse(selectDropdownPage.getSelectedDayOption().isEnabled());
    }

//    @Test (priority = 2)
    public void selectAnOptionFromTheDropdownList() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectDayByValue("Monday");
        Assert.assertTrue(selectDropdownPage.getSelectedDay().contains("Monday"));
    }

//    @Test (priority = 3)
    public void selectAnotherOptionFromTheDropdownListToTestIfTheValueChanges() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectDayByValue("Monday");
        Assert.assertTrue(selectDropdownPage.getSelectedDay().contains("Monday"));
        selectDropdownPage.selectDayByValue("Sunday");
        Assert.assertTrue(selectDropdownPage.getSelectedDay().contains("Sunday"));
    }

//    @Test (priority = 4)
    public void selectAnOptionFromTheDropdownListAndCheckItsValue() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectDayByValue("Monday");
        String selection = selectDropdownPage.getSelectedDayOption().getText();
        Assert.assertTrue(selectDropdownPage.getSelectedDay().contains(selection));
    }

//    @Test (priority = 5)
    public void selectAStateFromTheMultiDropdownList() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectStateByValue("Ohio");
        selectDropdownPage.clickOnFirstSelectedBtn();
        String firstOption = selectDropdownPage.getSelectedStateOption().getText();
        Assert.assertTrue(selectDropdownPage.getFirstSelectedState().contains(firstOption));
    }

//    @Test (priority = 6)
    public void selectAStateAndClickTheGetLastSelectedButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectStateByValue("Ohio");
        selectDropdownPage.clickOnLastSelectedBtn();
        Assert.assertTrue(selectDropdownPage.getLastSelectedState().contains("Ohio"));
    }

//    @Test (priority = 7)
    public void selectTwoStatesToTestIfBothOptionsAreDisplayed() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectStateByValue("Ohio");
        selectDropdownPage.clickOnFirstSelectedBtn();
        selectDropdownPage.selectStateByValue("Texas");
        selectDropdownPage.clickOnLastSelectedBtn();
        Assert.assertTrue(selectDropdownPage.getFirstSelectedState().contains("Ohio"));
        Assert.assertTrue(selectDropdownPage.getLastSelectedState().contains("Texas"));
    }

//    @Test (priority = 8)
    public void clickOnMultipleStatesAndThenClickOnTheFirstSelectedButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectStateByValue("Ohio");
        selectDropdownPage.selectStateByValue("New York");
        selectDropdownPage.selectStateByValue("Washington");
        selectDropdownPage.clickOnLastSelectedBtn();
        String lastOption = selectDropdownPage.getSelectedStateOption().getText();
        Assert.assertTrue(selectDropdownPage.getLastSelectedState().contains(lastOption));
    }

//    @Test (priority = 9)
    public void selectTwoDifferentStatesThenClickOnTheFirstSelectedButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div[1]/div[1]/ul/li[4]/a")).click();
        selectDropdownPage.selectStateByValue("California");
        selectDropdownPage.clickOnFirstSelectedBtn();
        selectDropdownPage.selectStateByValue("Florida");
        selectDropdownPage.clickOnLastSelectedBtn();
        selectDropdownPage.clickOnFirstSelectedBtn();
        Assert.assertTrue(selectDropdownPage.getFirstSelectedState().contains("Florida"));
        Assert.assertTrue(selectDropdownPage.getLastSelectedState().contains("Florida"));
    }
}
