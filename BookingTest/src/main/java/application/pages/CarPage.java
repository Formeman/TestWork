package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarPage extends BasePage {
    public CarPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(@class,'bui-f-font-display_two')]")
    WebElement carName;

    @FindBy(xpath = "//div[contains(@class,'bui-price-display__value')]")
    WebElement carPrice;

    public String getCarName(){
        return carName.getText();
    }

    public String getCarPrice(){
        return carPrice.getText();
    }


}
