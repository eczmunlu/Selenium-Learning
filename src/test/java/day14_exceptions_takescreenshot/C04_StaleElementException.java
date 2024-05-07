package day14_exceptions_takescreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementException extends TestBase {

    /*
    StaleElementException nasil alinir?
    ==> Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde sakladiktan sonra
    o sayfada yenileme yapan herhangi bir islem(navigate.refresh(), back(), forward()...) yapildiginda
    locateini aldigimiz webelementi tekrar kullanmak istersek bu exceptionu aliriz

    Bu hatayi nasil handle ederiz?
    => Bu exceptionu handle etmek icin webelementi navigate.refresh(), back(), forward() ...
    methodlari kullanildiginda tekrar locate etmeliyiz
     */

    @Test
    void test01() {

        driver.get("https://techproeducation.com");

        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));

        driver.navigate().refresh();

        //StaleElementException aldigimizda locate i güncellemeliyiz
        searchBox= driver.findElement(By.id("searchHeaderInput"));

        searchBox.sendKeys("CAYLAR TAZE");

    }
}