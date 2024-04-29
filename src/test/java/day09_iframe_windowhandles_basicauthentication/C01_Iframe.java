package day09_iframe_windowhandles_basicauthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
    Bir html dokumanı icinde yerlestirilmis olan baska bır html dokumanina Inline Frame  (  Iframe ) denir
    Sayfadaki bir webelementi locate ettigimizde NoSuchElement Exception aliyorssak locate i kontrol ederiz.
    yine ayni hatayi aliyorsak ulasmak istedigimiz webelement ifarem icinde olabilir.
    Dolayisiyla iframe icindeki bir webelement e ulasmak icin driver imizi iframe geciririz;

    3 şekilde :
        1-  driver.switchTo().frame(sayafdki iframe İNDEX İ ) --->  O DAN BASLAR
        2-  driver.switchTo().frame(<iframe> id / name attribute degeri)
        3-  driver.switchTo().frame(iframe webelement i)

        Tekrar ana sayfaya gecmek istersek           defaultContent()        methodu ile gecebiliriz
    Eger ic ice iframelere gecis yaptiysak ve bir üst frame e tekrar driver i tasimak istersek          parentFrame()
    methodu ile bir üst frame e gecis yapabiliriz
     */



    @Test
    void test01() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edin
        String actualText =driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assertions.assertTrue(actualText.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edin
        driver.switchTo().frame(0);
        WebElement aplicationListWE =driver.findElement(By.xpath("//h1"));
        Assertions.assertTrue(aplicationListWE.getText().contains("Applications lists"));

        //Sayfada iframe yazısının oldugunu test edin
        driver.switchTo().parentFrame(); // defaultContent()  ilk HTML ye döner    ---->  bu da olurdu
        WebElement iframeText =  driver.findElement(By.xpath("//h3"));
        Assertions.assertTrue(iframeText.getText().contains("iframe"));

    }


}