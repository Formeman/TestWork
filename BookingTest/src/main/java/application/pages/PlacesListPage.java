package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PlacesListPage extends BasePage {
    public PlacesListPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'d-deal-preset')]")
    List<WebElement> holidaysOffersList;

    @FindBy(xpath = "//span[contains(@class,'sr-hotel__name')]")
    WebElement hotelName;

    @FindBy(xpath = "//div[contains(@class,'bui-price-display__value')]")
    WebElement hotelPrice;

    @FindBy(xpath = "//a[contains(@class,'bui-button--primary')]")
    WebElement hotelButton;

    public int getHolidayOffersSize() {
        return holidaysOffersList.size();
    }

    public String getHotelName() {
        return hotelName.getText();
    }

    public String getHotelPrice() {
        return hotelPrice.getText();
    }

    public void goToHotelPage(){
        hotelButton.click();
        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
    }
}
