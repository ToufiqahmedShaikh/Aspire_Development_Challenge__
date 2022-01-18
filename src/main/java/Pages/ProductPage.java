package Pages;

import Util.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {

    WebDriver driver;
    ElementUtility elementUtil;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtility(this.driver);
    }

    public By createProduct = By.xpath("//button[@class='btn btn-primary o-kanban-button-new']");
    public By searchEditBox = By.xpath("//input[@type='text']");

    public By productNameEditBox = By.id("o_field_input_736");

    public  By updateQuantityid= By.cssSelector("button[name*='update']");
    public By updateQuantityid2=By.name("action_update_quantity_on_hand");

    public By getUpdateQuantityid3 = By.xpath("//button[@class='btn btn-primary o_list_button_add']");

    public By dropDownBtn= By.xpath("//input[@class='o_input ui-autocomplete-input']");
    public By locationTextBox = By.xpath("//div/input[@class='o_input ui-autocomplete-input']");
    public  By quantityAmount =By.xpath("//td/input[@name='inventory_quantity']");
    By DropdownList =By.xpath("//div[@class='o_input_dropdown']");
    public By saveQuantitybtn = By.xpath("//div/button[@class='btn btn-primary o_list_button_save']");
    public By applicationid=By.xpath("//a[@title='Applications']");
    public By dropDownValue1=By.xpath("//li/a[contains(text(),'Partner Locations/HN')]");

    public void ClickOn(By obj)
    {
        elementUtil.DoClickOn(obj);

    }

    public void setValue(By objectId,String string)
    {
        elementUtil.DoSetData(objectId,string);
    }




    }

