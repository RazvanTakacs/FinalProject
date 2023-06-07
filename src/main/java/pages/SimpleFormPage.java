package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleFormPage extends BasePage {

    public SimpleFormPage(WebDriver driver) {
        super(driver);
    }

    By TextField = By.id("user-message");
    By GetCheckedValue = By.id("showInput");
    By YourMessage = By.id("message");
    By TwoInputFieldsEnterA = By.id("sum1");
    By TwoInputFieldsEnterB = By.id("sum2");
    By GetValuesButton = By.xpath("//*[@id=\"gettotal\"]/button");
    By SumOfTheTwoNumbers = By.id("addmessage");
    public void selectTextField(String arg1) {
        driver.findElement(TextField).sendKeys(arg1);
    }
    public void clickOnGetCheckedValue(){ driver.findElement(GetCheckedValue).click();}
    public void selectTextFieldForA(String arg) { driver.findElement(TwoInputFieldsEnterA).sendKeys(arg);}
    public void selectTextFieldForB(String arg) { driver.findElement(TwoInputFieldsEnterB).sendKeys(arg);}
    public void clickOnGetValuesButton(){driver.findElement(GetValuesButton).click();}
    public String getYourDisplayedMessage(){ return driver.findElement(YourMessage).getText(); }
    public String getYourDisplayedSum(){ return driver.findElement(SumOfTheTwoNumbers).getText();}

}



