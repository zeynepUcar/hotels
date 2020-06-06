package PageObjectModel;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.readProperteis;
import java.util.List;


public class SearchingFlightPage extends AbstractClass {
    private WebDriver driver ;

    public SearchingFlightPage(){
        driver = Driver.getDriver();
        PageFactory.initElements( driver , this );
    }
    @FindBy(css = "input[placeholder=\"e.g., Las Vegas\"]")
    private WebElement getDestination;

    @FindBy(css = "input[id=\"qf-0q-localised-check-in\"]")
    private WebElement getCheckInDate;

    @FindBy(css = "input[id=\"qf-0q-localised-check-out\"]")
    private WebElement getCheckOutDate;

    @FindBy(css = "button[class=\"widget-overlay-close\"]")
    private WebElement closingField;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement searchButton;

    @FindBy(xpath="//fieldset[@id='filter-price']//div[@aria-labelledby='f-price-min-label']")
    private WebElement nightlyPriceMinSlider ;

    @FindBy(xpath="//fieldset[@id='filter-price']//div[@aria-labelledby='f-price-max-label']")
    private WebElement nightlyPriceMaxSlider ;

    @FindBy(xpath="//aside[@class=\"pricing resp-module\"]//a/strong")
    private List<WebElement> listOfPriceRange ;
    @FindBy(xpath="//aside[@class=\"pricing resp-module\"]//a/ins")
    private List<WebElement> listOfPriceRange1 ;


    @FindBy(xpath="//aside[@class=\"pricing resp-module\"]//a/strong/../../../preceding-sibling::div/h3")
    private WebElement nameOfHotelsInRange ;

    public void typeTheDestination(String destination){

        destination = readProperteis.getData("destination");
        sendKeysFunctionalities(getDestination, destination );
    }

    public void typeTheCheckInDate(String dateIn, String dateOut){

        getCheckInDate.clear();  //field is needed to clean before write
        dateIn = readProperteis.getData("check-in");
        sendKeysFunctionalities(getCheckInDate, dateIn);

        getCheckOutDate.clear();
        dateOut = readProperteis.getData("check-out");
        sendKeysFunctionalities(getCheckOutDate, dateOut);

    }

    public void closeTheDateField(){
        clickOnFunctionalities(closingField);
    }

    public void clickOnSearchButton(){

        clickOnFunctionalities(searchButton);
    }
   public void sliderFilterMin(int xOffset){slider(driver,nightlyPriceMinSlider,xOffset);

    }
    public void sliderFilterMax(int xOffset){slider(driver,nightlyPriceMaxSlider,xOffset);

    }

    public void checkIfThePriceInRange()  {
        String minPrice=readProperteis.getData("minPrice");
        String maxPrice=readProperteis.getData("maxPrice");

        int min=Integer.parseInt(minPrice);
        int max=Integer.parseInt(maxPrice);
        List<WebElement> list=listOfPriceRange;
        List<WebElement> list2=listOfPriceRange1;
        list.addAll(list2);

        boolean condition = false;
        for (int i=0;i<list.size();i++) {
            int price=Integer.parseInt(list.get(i).getText().substring(1));
            if (price>=min && price<=max ){
                condition=true;
                Assert.assertTrue(condition);

            }
        }


    }



}
