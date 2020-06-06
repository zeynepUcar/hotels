package PageObjectModel;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class AbstractClass {

    WebDriver driver;
    WebDriverWait wait;

    public void waitMethod(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public AbstractClass(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnFunctionalities(WebElement clickElement){

        waitMethod();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        clickElement.click();

    }

    public void sendKeysFunctionalities(WebElement sendKeysElements, String value){

        waitMethod();

        try {
            wait.until(ExpectedConditions.visibilityOf(sendKeysElements));
        }catch (Exception e){

            System.out.println(e.getMessage());
        }
        sendKeysElements.sendKeys(value);
    }
    public static void slider(WebDriver driver,WebElement slider,int xOffset) {
        Dimension dim=slider.getSize();
        int x=dim.getWidth();
        Actions action = new Actions(driver);
        action.clickAndHold(slider).moveByOffset(x-xOffset,0).release().build().perform();

    }
}
