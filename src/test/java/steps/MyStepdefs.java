package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import pages.*;
import ru.yandex.FirstTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyStepdefs extends FirstTest {

    Market market ;
    MarketMenu marketMenu ;

    @Before
    public void initialization(){
        before();
    }

    @Given("open Yandex main page")
    public void openYandexMainPage() {
        chromeDriver.get("https://yandex.ru/");
    }

    @And("go to Yandex servis {string}")
    public void goToYandexServis(String nameServis) {
        Yandex yandex = new Yandex(chromeDriver);
        yandex.GoTo(nameServis);
    }

    @Then("open Menu")
    public void openMenu() {
        market= new Market(chromeDriver);
        market.openMenu();
    }

    @Then("select a section {string}")
    public void selectASection(String sectionName) {
       marketMenu= new MarketMenu(chromeDriver);
        marketMenu.goToPageComp(sectionName);
    }

    @And("select a subsection {string}")
    public void selectASubsection(String subsectionName) {
        MarketComputers marketComputers= new MarketComputers(chromeDriver);
        marketComputers.goToPageNout(subsectionName);
    }

    @When("set filters for price {string}{string} and model {string} {string}")
    public void setFiltersForPriceAndModel(String minPrice, String maxPrace, String model1, String model2) {
        MarketNout marketNout = new MarketNout(chromeDriver);
        marketNout.installPriceAndModel(minPrice, maxPrace,model1, model2);

    }
    @And("set the number {int} of items  per page")
    public void setTheNumberOfItemsPerPage(int value) {
        MarketNout marketNout = new MarketNout(chromeDriver);
        marketNout.installCountItems(value);
    }

    @Then("check that the number of elements is {int}")
    public void checkThatTheNumberOfElementsIs(int value) {
        MarketNout marketNout = new MarketNout(chromeDriver);
        assertTrue("Количество элементов на странице не равно"+value,
                marketNout.getLaptops().size()==value);

    }
String beforeSearch;
    String afterSearch;

    @Then("check that the corresponding product is being searched for by the name of the first element")
    public void checkThatTheCorrespondingProductIsBeingSearchedForByTheNameOfTheFirstElement() {
        MarketNout marketNout = new MarketNout(chromeDriver);
         beforeSearch= marketNout.getNameFirstElementSearch();

        marketNout.findFirstLaptopInSearch();
         afterSearch =marketNout.getNameFirstElementSearch();


    }
    @Then("Equals results")
    public void equalsResults() {
        assertTrue("сохраненное название продукта"+beforeSearch+"отличается от найденого в результате поиска "+afterSearch ,
                beforeSearch.contains(afterSearch));
        System.out.println("бла бла");
    }
    @After
    public void close() {
        closeTest();
    }

}

