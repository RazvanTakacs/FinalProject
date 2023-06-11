package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage {
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    By MaleRadioButton = By.cssSelector("input[type='radio'][value='Male'][name='optradio']");
    By FemaleRadioButton = By.cssSelector("input[type='radio'][value='Female'][name='optradio']");
    By GetCheckedValue = By.id("buttoncheck");
    By DisplayedMessage = By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[1]/div/p[2]");
    By GroupMaleRadioButton = By.cssSelector("input[type='radio'][value='Male'][name='gender']");
    By GroupFemaleRadioButton = By.cssSelector("input[type='radio'][value='Female'][name='gender']");
    By GroupOtherRadioButton = By.xpath("//input[@value='Other']");
    By AgeGroupZeroToFive = By.cssSelector("input[type='radio'][value='0 - 5'][name='ageGroup']");
    By AgeGroupFiveToFifteen = By.cssSelector("input[type='radio'][value='5 - 15'][name='ageGroup']");
    By AgeGroupFifteenToFifty = By.cssSelector("input[type='radio'][value='15 - 50'][name='ageGroup']");
    By GetValues = By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[3]/div/div/div[1]/button");
    By YourGender = By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[3]/div/div/div[2]/p[1]/span");
    By YourAgeGroup = By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[3]/div/div/div[2]/p[2]/span");
    public void clickOnMaleRadioButton(){ driver.findElement(MaleRadioButton).click();}
    public void clickOnFemaleRadioButton(){ driver.findElement(FemaleRadioButton).click();}
    public void clickOnGetValueButton(){ driver.findElement(GetCheckedValue).click();}
    public String getYourDisplayedMessage(){ return driver.findElement(DisplayedMessage).getText();}
    public boolean isMaleRadioButtonSelected(){ return driver.findElement(MaleRadioButton).isSelected();}
    public boolean isFemaleRadioButtonSelected(){ return driver.findElement(FemaleRadioButton).isSelected();}
    public void clickOnGroupMaleRadioButton(){ driver.findElement(GroupMaleRadioButton).click();}
    public void clickOnGroupFemaleRadioButton(){ driver.findElement(GroupFemaleRadioButton).click();}
    public void clickOnGroupOtherRadioButton(){ driver.findElement(GroupOtherRadioButton).click();}
    public void clickOnTheGetValuesButton(){ driver.findElement(GetValues).click();}
    public String getYourGender(){ return driver.findElement(YourGender).getText();}
    public String getYourAgeGroup(){ return driver.findElement(YourAgeGroup).getText();}
    public void clickOnAgeGroupZeroToFive() {driver.findElement(AgeGroupZeroToFive).click();}
    public void clickOnAgeGroupFiveToFifteen() {driver.findElement(AgeGroupFiveToFifteen).click();}
    public void clickOnAgeGroupFifteenToFifty() {driver.findElement(AgeGroupFifteenToFifty).click();}
}
