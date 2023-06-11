package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage extends BasePage{
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    By SingleCheckbox = By.id("isAgeSelected");
    By CheckboxOption1 = By.id("ex1-check1");
    By CheckboxOption2 = By.id("ex1-check2");

    By CheckboxOption3 = By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[3]/div[2]/div[1]/div[3]/input");
    By CheckboxOption4 = By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[3]/div[2]/div[1]/div[4]/input");
    By CheckUncheckAllButton = By.id("box");
    By DisplayedMessage = By.id("txtAge");
    public boolean isSingleCheckboxSelected(){ return driver.findElement(SingleCheckbox).isSelected();}
    public void clickOnSingleCheckbox(){ driver.findElement(SingleCheckbox).click();}
    public void clickOnCheckboxOption1(){ driver.findElement(CheckboxOption1).click();}
    public void clickOnCheckboxOption2(){ driver.findElement(CheckboxOption2).click();}
    public void clickOnCheckboxOption3(){ driver.findElement(CheckboxOption3).click();}
    public void clickOnCheckboxOption4(){ driver.findElement(CheckboxOption4).click();}
    public void clickOnCheckUncheckAllButton(){ driver.findElement(CheckUncheckAllButton).click();}
    public String getYourDisplayedMessage(){ return driver.findElement(DisplayedMessage).getText();}
    public String getYourInitialValue(){ return driver.findElement(CheckUncheckAllButton).getAttribute("value");}
    public String getYourNewValue(){ return driver.findElement(CheckUncheckAllButton).getAttribute("value");}
    public boolean isCheckboxOption1Selected() { return driver.findElement(CheckboxOption1).isSelected();}
    public boolean isCheckboxOption2Selected() { return driver.findElement(CheckboxOption2).isSelected();}
    public boolean isCheckboxOption3Selected() { return driver.findElement(CheckboxOption3).isSelected();}
    public boolean isCheckboxOption4Selected() { return driver.findElement(CheckboxOption4).isSelected();}
}
