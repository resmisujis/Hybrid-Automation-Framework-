package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShotUtility
{
    public static String getscrnshotasbase64(WebDriver driver){
        TakesScreenshot ts=(TakesScreenshot)driver;
        String base64path = ts.getScreenshotAs(OutputType.BASE64);
        return base64path;
    }
}
