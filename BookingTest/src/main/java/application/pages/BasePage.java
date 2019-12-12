package application.pages;

import framework.driverSingleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class BasePage {
    protected WebDriver driver = WebDriverSingleton.create();
}

