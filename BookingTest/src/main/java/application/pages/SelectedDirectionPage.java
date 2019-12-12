package application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectedDirectionPage extends BasePage {

    public SelectedDirectionPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@role='button']")
    WebElement allRecommendationButton;

    @FindBy(xpath = "//div[@class='css-1qm1lh']")
    List<WebElement> recommendationList;

    public void clickOnAllRecomendationButton(){
        allRecommendationButton.click();
    }

    public int getRecommendationNumber(){
       return recommendationList.size();
    }
}
