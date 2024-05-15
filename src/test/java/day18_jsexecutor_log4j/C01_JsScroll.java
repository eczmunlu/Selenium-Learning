package day18_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsScroll extends TestBase {

    //JavascriptExecutor ile specific bir webelemente scroll
    @Test
    void test01() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        //Challenges a kadar scroll yapiniz
        WebElement challenges = driver.findElement(By.xpath("//h2[.='Challenges']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",challenges);

        //  false --->   sayfanın altında goruntuluyor. true -->  sayfanın basında  goruntuluyor(yukarıda)  !!!!!!!!!

    }


    //JavascriptExecutor ile sayfanin en altina ve en üstüne scroll
    @Test
    void test02() {

        driver.get("https://techproeducation.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Sayfanin toplam yuksekligini dynamic olarak aldik ve y koordinati olarak verdik
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        waitForSecond(2);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    @Test
    void test03() {
        driver.get("https://techproeducation.com/");
        jsScrollEnd();
        waitForSecond(2);
        jsScrollHome();
    }

}




