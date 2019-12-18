import framework.driverSingleton.WebDriverSingleton;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import application.pages.*;
import framework.utils.ConfigUtil;

import java.util.concurrent.TimeUnit;

public class BookingTest {
    WebDriver driver;
    MainPage mainPage;
    RentCarsPage rentCarsPage;
    HolidayOffersPage holidayOffersPage;
    ExcursionsPage excursionsPage;
    SelectedDirectionPage selectedDirectionPage;
    PlacesListPage placesListPage;
    HotelPage hotelPage;
    CarPage carPage;
    FlightsPage flightsPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = WebDriverSingleton.create();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ConfigUtil.getConfig("pageLoadTimeout")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigUtil.getConfig("implicitlyWait")), TimeUnit.SECONDS);

        driver.get(ConfigUtil.getConfig("url"));

        mainPage = new MainPage();
        rentCarsPage = new RentCarsPage();
        holidayOffersPage = new HolidayOffersPage();
        excursionsPage = new ExcursionsPage();
        selectedDirectionPage = new SelectedDirectionPage();
        placesListPage = new PlacesListPage();
        hotelPage = new HotelPage();
        carPage = new CarPage();
        flightsPage = new FlightsPage();
    }

    @AfterMethod(alwaysRun = true)
    public void finish() {
        WebDriverSingleton.kill();
    }

    @Parameters({"place","needResultNumber"})
    @Test
    public void firstCase(String place,int needResultNumber) {
        mainPage.goToRentCarsPage();
        rentCarsPage.selectPlaceOnNextWeekend(place);

        Assert.assertTrue(rentCarsPage.getResultsNumber() >= needResultNumber, "There must be at least 3 results");
    }

    @Parameters("place")
    @Test
    public void secondCase(String place) {
        mainPage.goToRentCarsPage();
        rentCarsPage.selectPlaceOnNextWeekend(place);
        rentCarsPage.clickToShowAlCarsButton();
        String carName = rentCarsPage.getFirstCarName();
        String carPrice = rentCarsPage.getFirstCarPrice();
        rentCarsPage.goToRentCarOptionPage();

        Assert.assertEquals(carName, carPage.getCarName(), "Car name must be the same");
        Assert.assertEquals(carPrice, carPage.getCarPrice(), "Car price must be the same");
    }

    @Parameters("place")
    @Test
    public void thirdCase(String place) {
        mainPage.goToHolidayOffersPage();
        holidayOffersPage.selectPlaceOnNextWeekend(place);
        Assert.assertTrue(placesListPage.getHolidayOffersSize() > 0, "Number of holidays offers must be more than 0");
    }

    @Test
    public void fourthCase() {
        mainPage.goToExcursionPage();
        int variantsNumber = excursionsPage.getVariantsNumber();
        excursionsPage.goToFirstVariantPage();
        selectedDirectionPage.clickOnAllRecomendationButton();
        Assert.assertEquals(variantsNumber, selectedDirectionPage.getRecommendationNumber(), "Number of recommendation must be the same");
    }

    @Parameters("place")
    @Test
    public void fifthCase(String place) {
        mainPage.goToHolidayOffersPage();
        holidayOffersPage.selectPlaceOnNextWeekend(place);
        String hotelName = placesListPage.getHotelName();
        String hotelPrice = placesListPage.getHotelPrice();
        placesListPage.goToHotelPage();

        Assert.assertTrue(hotelPage.getHotelName().contains(hotelName), "Hotel name must be the same");
        Assert.assertTrue(hotelPage.getHotelPrice().contains(hotelPrice), "Hotel price must be the same");
    }

    @Parameters({"place", "endPlace"})
    @Test
    public void sixthCase(String startPlace, String endPlace) {
        mainPage.goToflightsPage();
        flightsPage.clickOnOneWayButton();
        flightsPage.setStartFlightPlace(startPlace);
        flightsPage.setEndFlightPlace(endPlace);
        flightsPage.selectTodayDate();
        flightsPage.clickOnFindButton();

        Assert.assertTrue(flightsPage.getNumberOfBestFlights() == 3, "Number of best flights must be 3");
    }

    @Parameters({"place", "endPlace"})
    @Test
    public void seventhCase(String startPlace, String endPlace) {
        mainPage.goToflightsPage();
        flightsPage.clickOnOneWayButton();
        flightsPage.setStartFlightPlace(startPlace);
        flightsPage.setEndFlightPlace(endPlace);
        flightsPage.selectTodayDate();
        flightsPage.clickOnFindButton();
        flightsPage.clickOnFirstFlight();

        Assert.assertTrue(flightsPage.getStartOfFlightPlace().contains(startPlace), "Start place must be the same");
        Assert.assertTrue(flightsPage.getEndOfFlightPlace().contains(endPlace), "Start place must be the same");
    }
}
