package stepDefinitions;

import PageObjectModel.AbstractClass;
import PageObjectModel.SearchingFlightPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.readProperteis;

import java.util.concurrent.TimeUnit;

public class SearchingFlightStep  {

    WebDriver driver;


    SearchingFlightPage sp = new SearchingFlightPage();

    @Given("^Navigate to website$")
    public void Navigate_to_website() throws Throwable {

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(readProperteis.getData("URL"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Given("^Type to \"(.*?)\"$")
    public void type_to(String arg1) throws Throwable {

        sp.typeTheDestination(arg1);
    }

    @Given("^Type to \"(.*?)\" and \"(.*?)\" date$")
    public void type_to_and_date(String arg1, String arg2) throws Throwable {

        sp.typeTheCheckInDate(arg1, arg2);
    }

    @And("^Close the date field$")
    public void closeTheDateField() throws InterruptedException {
        sp.closeTheDateField();
        Thread.sleep(5000);
    }

    @Then("^Click on search button$")
    public void click_on_search_button() throws Throwable {

        sp.clickOnSearchButton();

    }


}