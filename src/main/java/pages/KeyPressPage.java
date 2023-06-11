package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage extends BasePage {
    public KeyPressPage(WebDriver driver) {
        super(driver);
    }

    By InputField = By.id("my_field");
    By DisplayedMessage = By.id("result");
    public void selectInputField(String arg1) { driver.findElement(InputField).sendKeys(arg1);}
    public String getYourDisplayedMessage(){ return driver.findElement(DisplayedMessage).getText(); }
    public void selectInputField(Keys arg1) { driver.findElement(InputField).sendKeys(arg1);}
    public String getInputFieldMessage(){ return driver.findElement(InputField).getAttribute("value").toUpperCase();}
    public String getLastChar(String arg1) { return arg1.substring(arg1.length()-1);}
}

