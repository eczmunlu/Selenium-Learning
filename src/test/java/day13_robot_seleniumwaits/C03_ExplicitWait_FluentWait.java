package day13_robot_seleniumwaits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_ExplicitWait_FluentWait extends TestBase {

    @Test
    void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.tagName("button")).click();

        //Hello World! Yazının sitede oldugunu test et

        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        WebElement helloWorld = driver.findElement(By.xpath("//*[.='Hello World!']"));

        wait.withTimeout(Duration.ofSeconds(20))// max bekleme suresini belirttik
                .pollingEvery(Duration.ofMillis(200))//belirttigimiz araliklarla kosulu kontrol ediyoruz
                .withMessage("Web Elementi ve sureyi kontrol et")//Eger belirtilen max süre icinde kosul saglanmaz
                // ise burada yazmis olduğumuz hata mesaji ile TimeOutException ile birlikte görünecek
                .until(ExpectedConditions.visibilityOf(helloWorld));//Webelementin görünür olup olmadigi kosulunu kontrol ettik

        Assertions.assertEquals("Hello World!",helloWorld.getText());
    }
}