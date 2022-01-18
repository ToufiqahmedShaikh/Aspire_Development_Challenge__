package Pages;

import Util.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;
    ElementUtility elementUtil;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtility(this.driver);;
    }


   public By productDropdown = By.xpath("//ul/li//a[@data-menu-xmlid='stock.menu_stock_inventory_control']");
    public By products =By.xpath("//a[@data-menu-xmlid='stock.menu_product_variant_config_stock']");
    public void ClickOnMenuLink(By obj)
    {
        elementUtil.DoClickOn(obj);

    }


}
