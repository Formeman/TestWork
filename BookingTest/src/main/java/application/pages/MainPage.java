package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@data-ga-track,'cars')]")
    WebElement rentCarsButton;

    @FindBy(xpath = "//a[contains(@class,'bui-button')]")
    WebElement holidayOffersButton;

    @FindBy(xpath = "//a[contains(@data-ga-track,'attractions')]")
    WebElement excursionsButton;

    @FindBy(xpath = "//a[contains(@data-ga-track,'flights')]")
    WebElement flightsButton;

    public void goToRentCarsPage(){
        rentCarsButton.click();
    }

    public void goToHolidayOffersPage(){
        holidayOffersButton.click();
    }

    public void goToExcursionPage(){
        excursionsButton.click();
    }

    public void goToflightsPage(){
        flightsButton.click();
    }
}
