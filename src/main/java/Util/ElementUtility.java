package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Util.JavascriptUtility.flash;
import static java.lang.System.out;

public class ElementUtility {
    WebDriver driver;

    public ElementUtility(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            flash(element, driver);

        } catch (Exception e) {
            out.println("Error occurred as :" + e);
        }
        return element;
    }


    public void DoSetData(By locator, String value) {
        try {
            getElement(locator).clear();
            getElement(locator).sendKeys(value);
        } catch (Exception e) {
            out.println("Error occurred as :"+e);
        }
    }

    public void DoClickOn(By locator) {
        try {
            getElement(locator).click();
        } catch (Exception e) {
            out.println("Error occurred as :"+e);
        }
    }


}
