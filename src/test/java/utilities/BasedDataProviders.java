package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;


public class BasedDataProviders {
	
    @DataProvider(name="Data")
    public Object[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//UsersFiles.xlsx";
        XLUtility xl = new XLUtility(path);
        int rownum = xl.getRowCount("sheet1");
        int colcount = xl.getCellCount("sheet1", 1);
        Object[][] apidata = new Object[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("sheet1", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name="UserNames")
    public Object[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//UsersFiles.xlsx";
        XLUtility xl = new XLUtility(path);
        int rownum = xl.getRowCount("sheet1");
        Object[] apidata = new Object[rownum];

        for (int i = 1; i <= rownum; i++) {
            apidata[i - 1] = xl.getCellData("sheet1", i, 1);
        }
        return apidata;
    }
}