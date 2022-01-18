package Pages;

import Util.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    ElementUtility elementUtil;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtility(this.driver);
    }

    // Xpath for Objects on Main Page
    public By inventoryId = By.xpath("//div[text()='Inventory']");
    public By manufacuringId = By.xpath("//div[text()='Manufacturing']");
    public By discuss = By.xpath("//div[text()='Discuss']");
    public By barcode = By.xpath("//div[text()='Barcode']");



    //Methods
    public void NavigateTo(By obj)
    {
        elementUtil.DoClickOn(obj);
    }

}
