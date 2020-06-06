package stepDefinitions;

import PageObjectModel.SearchingFlightPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import utilities.readProperteis;

public class BayramStep {
   WebDriver driver;
    SearchingFlightPage sp = new SearchingFlightPage();


    @When("^move the sliders as you desired$")
    public void moveTheSlidersAsYouDesired() {
        sp.sliderFilterMin(Integer.parseInt(readProperteis.getData("min")));
        sp.sliderFilterMax(Integer.parseInt(readProperteis.getData("max")));

// 220---330

    }

    @Then("^the prices found has to be in the range$")
    public void thePricesFoundHasToBeInTheRange()  {
     sp.checkIfThePriceInRange();
    }
}
