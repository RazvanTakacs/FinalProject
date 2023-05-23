package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage {
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    By MaleRadioButton = By.xpath("/html/body/div[1]/div[1]/section[3]/div/div/div[2]/div[1]/div[2]/label[1]/input");
    By FemaleRadioButton = By.xpath("/html/body/div[1]/div[1]/section[3]/div/div/div[2]/div[1]/div[2]/label[2]/input");
    By GetCheckedValue = By.id("buttoncheck");
    By DisplayedMessage = By.xpath("/html/body/div[1]/div[1]/section[3]/div/div/div[2]/div[1]/div[2]/p[2]");
    public void clickOnMaleRadioButton(){ driver.findElement(MaleRadioButton).click();}
    public void clickOnFemaleRadioButton(){ driver.findElement(FemaleRadioButton).click();}
    public void clickOnGetValueButton(){ driver.findElement(GetCheckedValue).click();}
    public String getYourDisplayedMessage(){ return driver.findElement(DisplayedMessage).getText();}
    public boolean isMaleRadioButtonSelected(){ return driver.findElement(MaleRadioButton).isSelected();}
    public boolean isFemaleRadioButtonSelected(){ return driver.findElement(FemaleRadioButton).isSelected();}
}
