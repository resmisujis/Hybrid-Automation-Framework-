package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.extendReportsUtility;
import utilities.utilityFetchProperty;

import java.io.IOException;

public class driverInstance {
    public WebDriver driver;
    @BeforeMethod
    public void initiateDriverInstance() throws IOException {
        String browsername = utilityFetchProperty.fetchPropertyValue("browsername");
        switch(browsername)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.get(utilityFetchProperty.fetchPropertyValue("url"));
        driver.manage().window().maximize();
        String testcasename=this.getClass().getSimpleName();
        extendReportsUtility.extentReportInitialization(testcasename);
    }

    @BeforeClass
    public void initializeExtentReport()
    {
        String testcasename=this.getClass().getSimpleName();
        extendReportsUtility.createExtentReportInstance(testcasename);
    }

    @AfterMethod
    public void closeInstance(ITestResult result)
    {
        extendReportsUtility.printExtentReports(result,driver);
        driver.quit();
    }
}
