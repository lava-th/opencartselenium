package Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    //DataProvider 1

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
     String path="C:\\Users\\DELL\\Lavanya\\Automation\\SeleniumFramework\\src\\test\\java\\testData\\Opencart_LoginData.xlsx";
     //taking excel file from testData

        ExcelUtility excelUtility=new ExcelUtility(path);//Crating an object for xlutility
        int totalRows=excelUtility.getRowCount("Sheet1");
        int totalCols=excelUtility.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalRows][totalCols];//Created for two dimension array which can store the data user and password
        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                loginData[i-1][j]=excelUtility.getCellData("Sheet1",i,j); //1,0

            }
        }
return  loginData;//returning two-dimensional array

    }

}
