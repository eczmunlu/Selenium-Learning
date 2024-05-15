package day18_jsexecutor_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Log4j extends TestBase {


    @Test
    void test01()  {

        // LogManager.getLogger(C04_Log4j.class); methodu ile parantez icinde belirtilen class icin bir tane logger objecti olusturur
        Logger logger=LogManager.getLogger(C04_Log4j.class);

        driver.get("https://amazon.com");
        logger.info("Amazon web sayfasına gidildi");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("arama kutusu locate edildi");

        searchBox.sendKeys("selenium");
        logger.info("arama kutusunda selenium aratildi");
    }
}
