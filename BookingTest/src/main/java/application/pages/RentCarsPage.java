package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RentCarsPage extends BasePage {
    public RentCarsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ss_origin")
    WebElement placeInput;

    @FindBy(xpath = "//button[@data-sb-id='main']")
    WebElement checkPriceButton;

    @FindBy(xpath = "//li[@data-list-item]")
    List<WebElement> placeList;

    @FindBy(xpath = "//div[contains(@class,'result__inner')]")
    List<WebElement> resultsList;

    @FindBy(xpath = "//td[contains(@class,'weekend ')]")
    List<WebElement> nextWeekendList;

    @FindBy(xpath = "//div[contains(@class,'_checkin')]")
    WebElement selectDateStartButton;

    @FindBy(xpath = "//a[contains(@class,'result__bui-btn')]")
    WebElement showAllCarsButton;

    @FindBy(xpath = "//a[contains(@class,'bui-u-unstyled-link')]")
    WebElement firstCarName;

    @FindBy(xpath = "//div[contains(@class,'bui-price-display__value')]")
    WebElement firstCarPrice;

    private void setPlace(String place) {
        placeInput.sendKeys(place);
    }

    private void clickOnCheckPriseButton() {
        checkPriceButton.click();
    }

    private void clickOnFirstPlaceListElement() {
        placeList.get(0).click();
    }

    private void clickOnSelectDateStartButton() {
        selectDateStartButton.click();
    }

    private void selectNextWeekend() {
        nextWeekendList.get(0).click();
        nextWeekendList.get(nextWeekendList.size()-1).click();
    }

    public void selectPlaceOnNextWeekend(String place) {
        setPlace(place);
        clickOnFirstPlaceListElement();
        clickOnSelectDateStartButton();
        selectNextWeekend();
        clickOnCheckPriseButton();
    }

    public int getResultsNumber() {
        return resultsList.size();
    }

    public void clickToShowAlCarsButton(){
        showAllCarsButton.click();
    }

    public String getFirstCarName(){
        return firstCarName.getText();
    }

    public String getFirstCarPrice(){
        return firstCarPrice.getText();
    }

    public void goToRentCarOptionPage(){
        firstCarName.click();
        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
    }
}
