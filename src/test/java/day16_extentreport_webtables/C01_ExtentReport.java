package day16_extentreport_webtables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {

    //Go to Amazon page
    //Search selenium in the search box
    //Verify that the page title contains selenium

    @Test
    void test01() {

        createExtentReport("Amazon Title Test");

        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com/");
        extentTest.info("Kullanıcı amazon sayfasına gider");
        addScreenShotToReport();

        //Arama kutusunda selenium aratalim
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        // webelement goruntu ekleme
        addScreenShotOfWebElementToReport(searchBox);

        searchBox.submit();
        waitForSecond(1);
        extentTest.info("Arama kutusuna selenium yazılarak aratıldı");

        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assertions.assertTrue(driver.getTitle().contains("selenium"));
        extentTest.pass("Sayfanın basliginin selenium icerdigi dogrulandı");
        addScreenShotToReport();


        extentReports.flush();

    }
}
