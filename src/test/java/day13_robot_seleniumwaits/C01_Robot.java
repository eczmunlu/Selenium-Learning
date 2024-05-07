package day13_robot_seleniumwaits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C01_Robot extends TestBase {

    @Test
    void test01() throws AWTException {

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.delay(3000);//3 saniye bekler

        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.delay(3000);//3 saniye bekler

        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.delay(3000);//3 saniye bekler

        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.delay(3000);//3 saniye bekler

        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.delay(3000);//3 saniye bekler
    }


    //Go to "https://www.ilovepdf.com/compress_pdf"
    // upload the file
    //test if the file has been uploaded successfully



    @Test
    void robotTest() {

        /*
       File Upload yaparken sendKeys() methodunun islemedigi istisnai durumlarda Testbase classda
       olusturdugumuz uploadFilePath(String dosyaYolu) methodu ile dosya yi yukleyebiliriz
       uploadFilePath(String dosyaYolu) methodu windows kullanicilari icindir
       Bu methodu kullanirken manual olarak mouse ve klavye yi kullanmamaliyiz
         */

        //"https://www.ilovepdf.com/compress_pdf" sitesine gidin
        driver.get("https://www.ilovepdf.com/compress_pdf");

        //  dosyayi yukleyin
        driver.findElement(By.id("pickfiles")).click();
        waitForSecond(3);

        //             "C:\Users\mua           \Desktop\Batch 231upload.pdf"
        String dynamicPath = System.getProperty("user.home")+"\\Desktop\\Batch 231upload.pdf";
        uploadFilePath(dynamicPath);

        waitForSecond(3);
        //   dosyanin basariyla yuklendigini test edin
        WebElement uploadedFile = driver.findElement(By.xpath("//span[.='Batch 231upload.pdf']"));
        Assertions.assertTrue(uploadedFile.isDisplayed());
    }
}