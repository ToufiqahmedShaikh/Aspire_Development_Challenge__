package Tests;

import BasePage.BasePage;
import Pages.*;
import org.bouncycastle.crypto.prng.drbg.DualECPoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

public class AspireTest {
    BasePage basePage;
    Properties prop;
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeSuite
    public void setup() throws InterruptedException {

        //Creating objects for BasePage & properties
        basePage = new BasePage();
        prop = basePage.initialiseProperties();

        //Fetching values

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("URL");

        driver = basePage.initializeDriver(browser);
        driver.get(url);

        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void loginTest() {

        loginPage =new LoginPage(driver);

        String username = prop.getProperty("UserID");
        String password = prop.getProperty("Password");

        loginPage.loginToAspire(username, password);

    }

  @Test (priority = 2)
    public void createProduct() throws InterruptedException {
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      mainPage = new MainPage(driver);
      InventoryPage inventoryPage = new InventoryPage(driver);
      ProductPage productPage = new ProductPage(driver);

      mainPage.NavigateTo(mainPage.inventoryId);

      inventoryPage.ClickOnMenuLink(inventoryPage.productDropdown);
      inventoryPage.ClickOnMenuLink(inventoryPage.products);
      productPage.ClickOn(productPage.createProduct);
      productPage.setValue(productPage.productNameEditBox, "SeleniumTest002");

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

      productPage.ClickOn(productPage.updateQuantityid);
      productPage.ClickOn(productPage.getUpdateQuantityid3);
      productPage.ClickOn(productPage.dropDownBtn);
      productPage.ClickOn(productPage.dropDownValue1);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      productPage.setValue(productPage.quantityAmount, "15");
      Thread.sleep(10);
      productPage.ClickOn(productPage.saveQuantitybtn);
      Thread.sleep(10);
      productPage.ClickOn(productPage.applicationid);
      mainPage.NavigateTo(mainPage.manufacuringId);
  }

  @Test (priority = 3)
     public void Manufacture() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        ManufacturingPage manufacturingPage = new ManufacturingPage(driver);
        manufacturingPage.ClickOn(manufacturingPage.createManufactureBtn);
        manufacturingPage.ClickOn(manufacturingPage.productTextBox);
        manufacturingPage.setValue(manufacturingPage.productTextBox,"SeleniumTest002");
        manufacturingPage.selectValueFromList(manufacturingPage.productList,"SeleniumTest002");
        Thread.sleep(15);
        manufacturingPage.setValue(manufacturingPage.manufactureQuantityTextBox,"15");
        manufacturingPage.ClickOn(manufacturingPage.addProduct);
        manufacturingPage.ClickOn(manufacturingPage.addProductRow);
        manufacturingPage.setValue(manufacturingPage.addProductRow,"SeleniumTest002");
        manufacturingPage.selectValueFromList(manufacturingPage.getproductlist2,"SeleniumTest002");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        manufacturingPage.ClickOn(manufacturingPage.consumeQuantity);
        manufacturingPage.setValue(manufacturingPage.consumeQuantity,"15");
        Thread.sleep(10);
        manufacturingPage.ClickOn(manufacturingPage.confirmBtn);
        Thread.sleep(10);
        manufacturingPage.ClickOn(manufacturingPage.markAsDoneBtn);
        manufacturingPage.setValue(manufacturingPage.quantityproduced,"15");
        manufacturingPage.ClickOn(manufacturingPage.Manufacturelogo);
        manufacturingPage.ClickOn(manufacturingPage.removefilter);

        List<WebElement> TableValues = manufacturingPage.getTableContent("SeleniumTest002");

        for  (WebElement ele: TableValues)
        {
           String actualStatus = ele.getText();
           Assert.assertEquals("Done", actualStatus);

        }
    }
}
