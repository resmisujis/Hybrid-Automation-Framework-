

package testCases;

        import baseClass.driverInstance;
        import org.testng.Assert;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;
        import pages.loginPage;
        import utilities.excelUtility;

public class TC1_loginValidation extends driverInstance
{
    @Test(dataProvider = "Authentication")
    public void loginValidation(String username,String password){
        loginPage lp=new loginPage(driver);
        lp.enteruserName(username);
        lp.enterPassword(password);
        lp.clickSignIn();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard",driver.getCurrentUrl());
    }
    @DataProvider(name = "Authentication")
    public Object[][] credentials()
    {
        String testcasename=this.getClass().getSimpleName();  //to get the desired class
        excelUtility.setExcelfile(); // to load the excel
        int startingtestcaserow=excelUtility.getstartingrownumber(testcasename);

        Object[][] test = excelUtility.gettabledata(startingtestcaserow);
        return test;
    }

}

