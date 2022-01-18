package Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtility {
    WebDriver driver;

    public JavascriptUtility(WebDriver driver) {
        this.driver =driver;
    }

    public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element, driver);// 1
            changeColor(bgcolor, element, driver);// 2
        }
    }

    private static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }
}
