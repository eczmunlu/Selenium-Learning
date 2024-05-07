package day12_faker_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    //Go to https://the-internet.herokuapp.com/upload
//press the chooseFile button
//Select the file you want to upload
//Press the Upload button
//"File Uploaded!" Test whether your text is displayed



    @Test
    void fileUploadTest() {

        // https://the-internet.herokuapp.com/upload   adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload ");

        //chooseFile butonuna basalim
        WebElement chooseFile=driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.

        String dynamicPath = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";
        chooseFile.sendKeys(dynamicPath); // dosya secme butonu input tag ı ise sendKeys çalışır. !!!!!!!!!!!!!!!!!!

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        String actualText=driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("File Uploaded!",actualText);

    }
}