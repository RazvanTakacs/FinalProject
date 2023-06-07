package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SelectDropdownPage extends BasePage {
    public SelectDropdownPage(WebDriver driver) {
        super(driver);

    }

    By Dropdown = By.id("select-demo");
    By MultiSelect = By.id("multi-select");
    By SelectedDay = By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div[2]/p");
    By FirstSelectedBtn = By.id("printMe");
    By LastSelectedBtn = By.id("printAll");
    By FirstSelectedOption = By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[2]/div[2]/div/div[2]/p[1]");
    By LastSelectedOption = By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[2]/div[2]/div/div[2]/p[2]");
    public WebElement getSelectedDayOption(){
        Select selectDayOption = new Select(driver.findElement(Dropdown));
        return selectDayOption.getAllSelectedOptions().get(0);
    }
    public int getSelectedDaySize(){
        Select selectDayOption = new Select(driver.findElement(Dropdown));
        return selectDayOption.getAllSelectedOptions().size();
    }
    public void selectDayByValue(String day) {
        Select selectDayOption = new Select(driver.findElement(Dropdown));
        selectDayOption.selectByValue(day);
    }
    public String getSelectedDay(){ return driver.findElement(SelectedDay).getText();}

    public void selectStateByValue(String state) {
        Select selectDayOption = new Select(driver.findElement(MultiSelect));
        selectDayOption.selectByValue(state);
    }
    public WebElement getSelectedStateOption() {
        Select selectDayOption = new Select(driver.findElement(MultiSelect));
        List<WebElement> allSelectedOptions = selectDayOption.getAllSelectedOptions();
        return allSelectedOptions.get(allSelectedOptions.size() - 1);
    }

    public void clickOnFirstSelectedBtn(){ driver.findElement(FirstSelectedBtn).click();}
    public void clickOnLastSelectedBtn(){ driver.findElement(LastSelectedBtn).click();}
    public String getFirstSelectedState(){ return driver.findElement(FirstSelectedOption).getText();}
    public String getLastSelectedState(){ return driver.findElement(LastSelectedOption).getText();}

}

