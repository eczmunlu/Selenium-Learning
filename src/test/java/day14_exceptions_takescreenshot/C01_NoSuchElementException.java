package day14_exceptions_takescreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

        /*
    Eger sayfadaki bir webelementi locate ettikten sonra NoSuchElementExcepiton aliyorsak;

    1) Locate i tekrar kontrol etmek
    2) Wait / Syncronization problemi olabilir; implictly wait suresini artirabiliriz
    3) Webelementin iframe icinde olup olmadigini kontrol ederiz
    4) Driver webelementi göremiyordur, dolayisiyla actions class yardimiyla scroll yaparak
    webelementin gorunur olmasini saglariz
    5) Bir linke tiklandiginda yeni bir sayfa yada sekme aciliyorysa eger driveri bu yeni acilan sayfaya gecirmed
      o sayfadaki bir webelementi locate ettigimizde bu hatayi aliriz
     */

    @Test
    void test01() {

        /*
        Bilincli olarak yanlis locate aldik ve NoSuchElementExcepiton aldik
         */
        driver.get("https://techproeducation.com");
        WebElement searchBox = driver.findElement(By.id(" searchHeaderInput"));
        searchBox.sendKeys("Batch231");

    }
}