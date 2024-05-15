package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    void test01() throws IOException {
        //1- oncelikle excel dosyasinin path ı tespit edilir.
        String path="src/test/java/resources/Capitals.xlsx";

        //2-Belirtilen path bulunan excel dosyasini java classina akısı olusturulur
        FileInputStream fis=new FileInputStream(path);

        //3- java ortaminda bir excel dosyasi actik
        Workbook workbook= WorkbookFactory.create(fis);

        //4-excel den bir sayfa actık (birden fazla sayfa bulunabilir
        Sheet sheet= workbook.getSheet("Sheet1");

        //5-sayfadaki belirtilen index teki satira erismek icin kullanilir
        Row row=sheet.getRow(0); //  index 0 dan baslar

        //6- bir row daki belirtilen cell e erisilir
        Cell cell=row.getCell(0);


        System.out.println(cell);// COUNTRY




    }
    @Test
    void test02() throws IOException {

        //1)Oncelikle excel dosyasinin bulundugu path ayarlanir
        String path ="src/test/java/resources/Capitals.xlsx";

        //2) Belirtilen path te bulunan excel dosyasindan java classimiza data akisi olusturur
        FileInputStream fis = new FileInputStream(path);

        //3) java ortaminda bir excel dosyasi actik
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));




    }
}
