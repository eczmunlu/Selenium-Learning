package day08_testbase_alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TestBaseClassWork extends TestBase {

    /*
     https://testcenter.techproeducation.com/index.php?page=dropdown sayfasina gidelim
     Year, month, day dropdown menulerden reusable method kullanarak secim yapalim
     */

    @Test
    void reusableMethodUsage() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //           a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));



        waitForSecond(2);
        selectIndex(year,0);
        waitForSecond(2);
        selectIndex(month,1);
        waitForSecond(2);
        selectIndex(day,2);
        waitForSecond(3);

        selectVisible(year,"2000");
        waitForSecond(3);
        selectVisible(month,"July");
        waitForSecond(3);
        selectVisible(day,"19");
        waitForSecond(5);



    }


}