package application.pages;

import framework.utils.RegularUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExcursionsPage extends BasePage {

    public ExcursionsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    private String numbersPattern = "^[0-9]+";

    @FindBy(xpath = "//a//span//div")
    WebElement variants;

    public int getVariantsNumber() {
       return Integer.parseInt(RegularUtil.getTextByPattern(variants.getText(),numbersPattern));
    }

    public void goToFirstVariantPage(){
        variants.click();
    }
}
