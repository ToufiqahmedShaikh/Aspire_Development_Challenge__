package Pages;

import Util.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    ElementUtility elementUtil;


    public LoginPage(WebDriver driver) {
            this.driver = driver;
            elementUtil = new ElementUtility(this.driver);
        }

        //By locators : By Xpath
          By loginId = By.xpath("//input[@id='login']");
          By passwordId = By.xpath("//input[@id='password']");
          By  loginButton = By.xpath("//button[@type='submit' and text()='Log in']");


        //login method
    public void loginToAspire(String username,String password)
    {
        System.out.println("Login with : " + username + " and " + password);
        elementUtil.DoSetData(loginId, username);
        elementUtil.DoSetData(passwordId, password);
        elementUtil.DoClickOn(loginButton);
    }

}
