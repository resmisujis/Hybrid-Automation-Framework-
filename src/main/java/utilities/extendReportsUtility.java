package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import javax.xml.transform.Result;
import java.text.SimpleDateFormat;
import java.util.Date;

public class extendReportsUtility
{
    public static ExtentReports reporter;
    public static ExtentTest loger;

    public static ExtentSparkReporter spark;

    public static void createExtentReportInstance(String classname)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
        Date now = new Date();
        String timeStamp = sdf.format(now);
        spark= new ExtentSparkReporter("./extendReports/"+classname+timeStamp+".html");
        spark.config().setDocumentTitle("Testing Document File");
        spark.config().setReportName("Testing Report Title");
        reporter= new ExtentReports();
        reporter.attachReporter(spark);
        }

    public static void extentReportInitialization(String classname)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
        Date now = new Date();
        String timeStamp = sdf.format(now);
        loger= reporter.createTest(classname +timeStamp);
    }

    public static void printExtentReports (ITestResult Result, WebDriver driver)
    {
        if (Result.getStatus()==ITestResult.SUCCESS)
        {
            loger.log(Status.PASS, MarkupHelper.createLabel(Result.getName()+"Test has passed", ExtentColor.GREEN));
        }

        else if (Result.getStatus()==ITestResult.FAILURE)
        {
            loger.log(Status.FAIL, MarkupHelper.createLabel(Result.getName()+"Test has failed", ExtentColor.RED));
            loger.fail(Result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotUtility.getscrnshotasbase64(driver)).build());
        }

        else
        {
            loger.log(Status.SKIP, MarkupHelper.createLabel(Result.getName()+"Test Skipped", ExtentColor.YELLOW));
        }

        reporter.flush();

    }
}

