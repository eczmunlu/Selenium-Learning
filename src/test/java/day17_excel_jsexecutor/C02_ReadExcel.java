package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C02_ReadExcel {

    @Test
    void test01() throws IOException {

        String path ="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell = workbook.getSheet("Sheet1").getRow(0).getCell(1);
        System.out.println("cell = " + cell);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String actualCell = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("actualCell = " + actualCell);
        Assertions.assertEquals("France",actualCell);


        //Örnek 3: Kullanılan satır sayısın bulun
        //getPhysicalNumberOfRows() methodu icinde data bulunan satir sayisini verir
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());


        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        //getLastRowNum() methodu bir sheet teki son satirin indexini verir, dolayisiyla eger 5 satir varsa bu method 4 verir
        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());

        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}

        Map<String  , String> countryCapitals = new LinkedHashMap<>();

        for (int i = 0; i <=workbook.getSheet("Sheet1").getLastRowNum() ; i++) {

            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

            countryCapitals.put(country,capital);
        }
        System.out.println("countryCapitals = " + countryCapitals);


    }
}