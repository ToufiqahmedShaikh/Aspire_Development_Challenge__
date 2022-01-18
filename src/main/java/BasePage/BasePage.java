package BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;
    public WebDriver initializeDriver(String BrowserName)
    {
        switch (BrowserName.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case  "safari":
                WebDriverManager.safaridriver().setup();
                driver= new SafariDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver =new OperaDriver();
                break;
            case  "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Please choose correct browser. "+BrowserName+" setup doesn't exist");

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;
    }

    public Properties initialiseProperties()  {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("C:\\Users\\ToufiqahmedS\\IdeaProjects\\Aspire_Development_Challenge\\src\\main\\java\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


}
