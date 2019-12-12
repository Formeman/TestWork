package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsPage extends BasePage {

    public FlightsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inputWrapper']//input[1]")
    WebElement startFlightPlaceInput;

    @FindBy(xpath = "//div[contains(@class,'col-destination switch')]//input[1]")
    WebElement endFlightPlaceInput;

    @FindBy(xpath = "//div[contains(@class,'dateInput size-l input-flat')]")
    WebElement dateFlightInput;

    @FindBy(xpath = "//span[contains(@class,'centre')]")
    WebElement findButton;

    @FindBy(xpath = "//div[contains(@class,'BestFlights')]//div[@class='resultWrapper']")
    List<WebElement> bestFlightsList;

    @FindBy(xpath = "//span[@class='origin']")
    WebElement startOfFlightPlace;

    @FindBy(xpath = "//span[@class='destination']")
    WebElement endOfFlightPlace;

    @FindBy(xpath = "//label[contains(@id,'oneway-label')]")
    WebElement oneWayButton;

    @FindBy(xpath = "//div[contains(@class,'col-day today')]")
    WebElement todayDateButton;

    public void setStartFlightPlace(String place){
        startFlightPlaceInput.clear();
        startFlightPlaceInput.sendKeys(place);
    }

    public void setEndFlightPlace(String place){
        endFlightPlaceInput.sendKeys(place);
    }

    public void selectTodayDate(){
        dateFlightInput.click();
        todayDateButton.click();
    }

    public void clickOnFindButton(){
        findButton.click();
    }

    public int getNumberOfBestFlights(){
        return bestFlightsList.size();
    }

    public void clickOnFirstFlight(){
        bestFlightsList.get(0).click();
    }

    public String getStartOfFlightPlace(){
        return startOfFlightPlace.getText();
    }

    public String getEndOfFlightPlace(){
        return endOfFlightPlace.getText();
    }

    public void clickOnOneWayButton(){
        oneWayButton.click();
    }
}
