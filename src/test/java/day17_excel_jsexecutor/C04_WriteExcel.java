package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_WriteExcel {

    @Test
    void test01() throws IOException {


        //classwork
        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        Row row=workbook.getSheet("customer_info").getRow(0);

        Cell cell3=row.createCell(2); // 3ncu cell olustruldu
        cell3.setCellValue("STATUS"); // 3NCU cell e value olarak STATUS yazdık

        workbook.getSheet("customer_info").getRow(1).createCell(2).setCellValue("valid");
        workbook.getSheet("customer_info").getRow(2).createCell(2).setCellValue("valid");
        workbook.getSheet("customer_info").getRow(3).createCell(2).setCellValue("invalid");

        FileOutputStream fos=new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
        workbook.write(fos);   //   output ile akıs olusturduk ve write ila hepsini yazdık


        fis.close();
        fos.close();


    }

    @Test
    void test02() throws IOException {     //   2 YOL

        //classwork
        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        // Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet1 = workbook.getSheet("customer_info");

        Row row =sheet1.getRow(0);

        //ucuncu celli olustur
        Cell cell3= row.createCell(2);

        // ucuncu cell in value sunu STATUS olarak ayarladi
        cell3.setCellValue("STATUS");

        //ikinci satirin ucuncu hucresini olusturacağız ve bu hücrenin degerini valid olarak ayarlayacağız
        sheet1.getRow(1).createCell(2).setCellValue("valid");


        //ücün satirin ucuncu hucresini olusturacağız ve bu hücrenin degerini valid olarak ayarlayacağız
        sheet1.getRow(2).createCell(2).setCellValue("valid");


        //dördüncü satirin ucuncu hucresini olusturacağız ve bu hücrenin degerini valid olarak ayarlayacağız
        sheet1.getRow(3).createCell(2).setCellValue("invalid");

        FileOutputStream fos = new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
        workbook.write(fos);

        fis.close();
        fos.close();

    }

    @Test
    void test03() throws IOException {

        /*
            Homework
          Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
          ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")
        */
        String path="src/test/java/resources/mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet=workbook.getSheet("customer_info");
        sheet.getRow(0).createCell(3).setCellValue("Name");

         String [] nameList={"ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam"};
         int i=1;
         for (String w:nameList){
             sheet.getRow(i).createCell(3).setCellValue(w);
             i++;
         }

        FileOutputStream fos= new FileOutputStream(path);
        workbook.write(fos);

        fis.close();
        fos.close();

    }

}
