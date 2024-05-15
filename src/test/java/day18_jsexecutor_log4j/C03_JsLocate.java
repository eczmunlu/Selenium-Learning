package day18_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsLocate extends TestBase {

    @Test
    void test01() {
        
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchBox = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox')");
        searchBox.sendKeys("selenium");

    }

    @Test
    void test02() {

        driver.get("https://techproeducation.com");

        // Events yazisini BATCH231 olarak degistir
        WebElement eventsText= driver.findElement(By.xpath("//h2[.='Events']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].textContent='BATCH 231'",eventsText);

    }
}