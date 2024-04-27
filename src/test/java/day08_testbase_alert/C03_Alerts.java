package day08_testbase_alert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alerts extends TestBase {
    /*

    Eger bir sayfadaki bir buton tiklandiktan sonra bir uyari penceresi cikiyorsa ve
    bu cikan pencereye inspect yaparak locate alamiyorsak bu bir -----     JS Alert    -----      tir.

    JS Alert  u handle edebilmek icin driver imizi o pencereye gecis yaptirmamiz gerekecek .
    Bunun icin driver object miz uzerinden -----     switchTo()    ------  methoduyla alert() e gecis yapacağız

     */

    //   https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

    //Bir metod olusturun: acceptAlert


    @Test
    void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        waitForSecond(2);
        //      birinci butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        waitForSecond(2);
        //      uyarıdaki OK butonuna tıklayın
        driver.switchTo(). // gecis metodu
                alert(). // Driver i alert e gecirdik
                accept(); // uyarıdaki ok e tiklar

        waitForSecond(2);

        //      result mesajının  "You successfully clicked an alert" oldugunu test edin.
        String actualResultMessage=  driver.findElement(By.id("result")).getText();
        String expectedResultMessage="You successfully clicked an alert";
        Assertions.assertEquals(expectedResultMessage,actualResultMessage);

    }


    //Bir metod olusturun: dismissAlert

    @Test
    void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        waitForSecond(2);
        //       ikinci butona tıklayın,
        driver.findElement(By.xpath("//button [@onclick='jsConfirm()']")).click();
        waitForSecond(2);

        //       uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss(); // cancel  (iptal ) a basar
        waitForSecond(2);

        //       result mesajının "successfuly" icermedigini test edin.
        String actualResultMessage =driver.findElement(By.id("result")).getText();
        String unexceptedResultMessage = "successfuly";
        Assertions.assertFalse(actualResultMessage.contains(unexceptedResultMessage));

    }

    //Bir metod olusturun: sendKeysAlert
    @Test
    void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        waitForSecond(2);
        //       ucuncu butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        //       uyarıdaki  metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Mustafa");
        waitForSecond(3);

        //       OK butonuna tıklayın
        driver.switchTo().alert().accept();

        //       result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResultMessage =driver.findElement(By.cssSelector("#result")).getText();
        Assertions.assertTrue(actualResultMessage.contains("Mustafa"));

    }



}
