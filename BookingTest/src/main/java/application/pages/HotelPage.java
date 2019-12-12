package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage extends BasePage {

    public HotelPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='hp__hotel-name']")
    WebElement hotelName;

    @FindBy(xpath = "//div[contains(@class,'bui-price-display__value')]")
    WebElement hotelPrice;

    public String getHotelName(){
        return hotelName.getText();
    }

    public String getHotelPrice(){
        return hotelPrice.getText();
    }
}
