package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HolidayOffersPage extends BasePage {

    public HolidayOffersPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "ss")
    WebElement placeInput;

    @FindBy(xpath = "//button[@data-sb-id='main']")
    WebElement checkPriceButton;

    @FindBy(xpath = "//td[contains(@class,'weekend ')]")
    List<WebElement> nextWeekendList;

    @FindBy(xpath = "//div[contains(@class,'_checkin')]")
    WebElement selectDateButton;

    @FindBy(xpath = "//li[@data-list-item]")
    List<WebElement> placeList;

    private void setPlace(String place) {
        placeInput.sendKeys(place);
    }

    private void clickOnCheckPriseButton() {
        checkPriceButton.click();
    }

    private void clickOnFirstPlaceListElement() {
        placeList.get(0).click();
    }

    private void clickOnSelectDateButton(){
        selectDateButton.click();
    }

    private void selectNextWeekend() {
        nextWeekendList.get(0).click();
        nextWeekendList.get(nextWeekendList.size()-1).click();
    }

    public void selectPlaceOnNextWeekend(String place) {
        setPlace(place);
        clickOnFirstPlaceListElement();
        clickOnSelectDateButton();
        selectNextWeekend();
        clickOnCheckPriseButton();
    }
}
