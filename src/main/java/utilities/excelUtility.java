package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class excelUtility
{
    private static FileInputStream excelfile;
    private static XSSFWorkbook excelworkbook;
    private static XSSFSheet excelsheet;
    private static XSSFCell excelcell;
    public static void setExcelfile() {
        try {
            excelfile=new FileInputStream(utilityFetchProperty.fetchPropertyValue("excelPath"));
            excelworkbook=new XSSFWorkbook(excelfile);
            excelsheet=excelworkbook.getSheet("DataSheet");
        }
        catch (Exception e){
            System.out.println("The exeception is" +e);
        }
    }
    public static int getstartingrownumber(String testcasename){
        int i=1;
        try {
            int rowcount=excelsheet.getLastRowNum(); //to get total rows in excel
            for (i=1;i<=rowcount;i++)
            {
                if (getcelldata(i,0).equalsIgnoreCase(testcasename)){ //row is defined as i and we know colnum is 0
                    break;
                }
            }
            return i;
        }
        catch (Exception e){
            //System.out.println("The Exception is " +e);
            throw e;
        }
    }
    public static String getcelldata(int rownum,int colnum){
        try {
            excelcell=excelsheet.getRow(rownum).getCell(colnum); //to get specific cell in a row
            return excelcell.getStringCellValue();  //to return value in the specific  cell
        }
        catch (Exception e)
        {
            return "";   //to handle exception in the excel
        }
    }
    public static int nexttestcaserownumber(int startingtestcaserow){
        int i;

        for(i=startingtestcaserow+1;i<=excelsheet.getLastRowNum();i++) //to get lastrow in excel
        {
            if(getcelldata(i,0)!="")   //to check cell value is not equals to null
            {
                break;
            }
        }
        return i;
    }
    public static Object[][] gettabledata(int startingtestcaserow)
    {
        int endingtestcaserow=nexttestcaserownumber(startingtestcaserow);
        int numberofcolumns=(excelsheet.getRow(startingtestcaserow).getLastCellNum())-1;
        String dataarray[][]=new String[endingtestcaserow-startingtestcaserow][numberofcolumns]; //to find array size
        try {
            int ci = 0;  // row by default as zero i.e [0][0],[0][1]
            while (startingtestcaserow < endingtestcaserow)  // to read 1, 4
            {

                int cj = 0;
                for (int j = 1; j <= numberofcolumns; j++, cj++)
                {
                    dataarray[ci][cj] = getcelldata(startingtestcaserow, j);
                }
                ci++;
                startingtestcaserow++;

            }
        } catch (Exception e) {
            throw e;
        }
        return dataarray;
    }
}