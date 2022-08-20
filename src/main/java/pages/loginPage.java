package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.extendReportsUtility;

public class loginPage
{
    WebDriver driver;
    public loginPage(WebDriver driver) //constructor
    {
        this.driver = driver; //differentiate the driver
    }
    public void enteruserName(String userName)
    {
        driver.findElement(By.id("txtUsername")).sendKeys(userName);
        extendReportsUtility.loger.log(Status.INFO,"Enter user name: " + userName);
    }

    public void enterPassword(String password)
    {
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        extendReportsUtility.loger.log(Status.INFO,"Enter Password: " + password);
    }

    public void clickSignIn()
    {
       driver.findElement(By.id("btnLogin")).click();
        extendReportsUtility.loger.log(Status.INFO,"Clicked Sign In");
    }

}
