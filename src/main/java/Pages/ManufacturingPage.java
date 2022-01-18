package Pages;

import Util.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManufacturingPage {
    WebDriver driver;
    ElementUtility elementUtil;


    public ManufacturingPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtility(this.driver);
    }

    //Xpath
    public By createManufactureBtn = By.xpath("//button[@class='btn btn-primary o_list_button_add']");
    public By productTextBox = By.xpath ("//input[@id='o_field_input_909']");
    public By productList = By.xpath("//ul[@id='ui-id-11']/li");
    public By manufactureQuantityTextBox= By.id("o_field_input_911");

    public By addProduct= By.xpath("//th[@data-name=\'product_id\']//ancestor::thead//following::tbody/tr/td[@colspan=\'5\']/a[text()=\'Add a line\']");
    public By addProductRow = By.xpath("//th[@data-name='product_id']//ancestor::thead//following::tbody/tr/td[@colspan='5']/a[text()='Add a line']//ancestor::tr//preceding-sibling::tr/td/div[@name='product_id']/div/input");
    public By getproductlist2 =By.xpath("//ul[@id='ui-id-66']/li");
    public By consumeQuantity = By.xpath("//input[@name='product_uom_qty']");

    public By confirmBtn =By.xpath("//button[@name='action_confirm']");
    public  By markAsDoneBtn=By.xpath("//button[@name='button_mark_done' and @class='btn btn-primary']");
    public By quantityproduced =By.xpath("//input[@name='qty_producing']");
    public By Manufacturelogo =By.xpath("//a[@class='o_menu_brand' and text()='Manufacturing']");
    public By removefilter =By.xpath("//i[@title='Remove']");

    public void ClickOn(By obj)
    {
        elementUtil.DoClickOn(obj);
    }
    public void setValue(By objectId,String string)
    {
        elementUtil.DoSetData(objectId,string);
    }

    public void selectValueFromList(By locators,String str) {
        String webelem = "";
        List<WebElement> list = driver.findElements(locators);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            if (text.equals(str)) {
                list.get(i).click();
                break;
            }
        }
    }
    public List<WebElement> getTableContent(String str)
    {

     By manufactureTableXpath =By.xpath("//td[@title=str]//following-sibling::td/span[@name='state']");

     List<WebElement> list =driver.findElements(manufactureTableXpath);

     return list;

    }
}
