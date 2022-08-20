package testCases;

import baseClass.driverInstance;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.addUser;
import utilities.excelUtility;

public class TC2_UserCreation extends driverInstance
{
    @Test(dataProvider = "Authentication")
    public void userCreation (String userName, String password,String EmployeeName, String username,String pass, String cpass) throws InterruptedException {
        addUser aus=new addUser(driver);
        aus.enteruserName(userName);
        aus.enterPassword(password);
        aus.clickSignIn();
        Thread.sleep(5000);
        aus.clickAdminMenu();
        aus.clickAddButton();
        aus.selectUserRole();
        aus.enterEmployeeName(EmployeeName);
        aus.enterUsrName(username);
        aus.selectStatus();
        aus.enterPass(pass);
        aus.enterCPass(cpass);
        aus.clickSave();
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

