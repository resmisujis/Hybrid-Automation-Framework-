package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class addUser
{
    WebDriver driver;
    public addUser(WebDriver driver) //constructor
    {
        this.driver = driver; //differentiate the driver
    }

    public void enteruserName(String userName)
    {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
    }

    public void enterPassword(String password)
    {
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
    }

    public void clickSignIn()
    {
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    }

    public void clickAdminMenu()
    {
        driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
    }

    public void clickAddButton()
    {
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
    }

    public void selectUserRole()
    {
        Select selt = new Select(driver.findElement(By.xpath("//select[@id='systemUser_userType']")));
        selt.selectByVisibleText("Admin");
    }

    public void enterEmployeeName(String EmployeeName)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys(EmployeeName);
    }

    public void enterUsrName(String username)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(username);
    }

    public void selectStatus()
    {
        Select sel = new Select(driver.findElement(By.xpath("//select[@id='systemUser_status']")));
        sel.selectByVisibleText("Enabled");
    }

    public void enterPass(String pass)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys(pass);
    }

    public void enterCPass(String cpass)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys(cpass);
    }

    public void clickSave()
    {
        driver.findElement(By.xpath("btnSave")).click();
    }



















}
