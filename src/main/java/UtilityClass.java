import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilityClass {
    public static String getTD(int rowIndex,int colIndex) throws IOException, InvalidFormatException
    {
        FileInputStream file = new FileInputStream("src/test/resources/adi01.xlsx");
        Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
        String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
        return value;
    }


}
