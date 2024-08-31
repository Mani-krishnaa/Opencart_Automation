package GenericUtility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    //DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = "/home/manikrishna/Intellij/Open_cartAutomation/testData/Open_cartLoginDetails.xlsx"; // path of the file

        ExcelUtils xlUtil = new ExcelUtils(path); // here creating object for utility

        int totalRows = xlUtil.getRowCount("Sheet1");
        int totalCols = xlUtil.getCellCount("Sheet1", 1);

        String[][] loginData = new String[totalRows][totalCols]; // created for two dimension array which can store

        for (int i = 1; i <= totalRows; i++)  // 1 // read the data from x1 storing in two deminsional array
        {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlUtil.getCellData("Sheet1", i, j);
            }
        }
        return loginData;// returning two dimension array
    }
}

//DataProvider 2


//DataProvider 3


//DataProvider 1




