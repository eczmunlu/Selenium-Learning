package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {

    //http://zero.webappsecurity.com sayfasina gidin
    //Signin buttonuna tiklayin
    //Login alanine  "username" yazdirin
    //Password alanine "password" yazdirin
    //Sign in buttonuna tiklayin
    //Online Banking altındaki Pay Bills sayfasina gidin
    //amount kismina yatirmak istediginiz herhangi bir miktari yazin
    //tarih kismina "2020-09-10" yazdirin
    //Pay buttonuna tiklayin
    //"The payment was successfully submitted." mesajinin ciktigini control edin
    //sayfayı kapatınız


    @Test
    void test01() {

        //Go to http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");

        //Click the Signin button
        driver.findElement(By.id("signin_button")).click();

        //Write "username" in the login field
        //Write "password" in the password field
        //Click the Sign in button

             WebElement login= driver.findElement(By.cssSelector("#user_login"));
             login.sendKeys("username", Keys.TAB,
                                         "password",Keys.ENTER);

             driver.navigate().back();//  sayfada    BUG      var  o uyarıdan geri çıkmak için

        //Go to the Pay Bills page under Online Banking
        driver.findElement(By.id("onlineBankingMenu")).click();
        waitForSecond(2);

        driver.findElement(By.id("pay_bills_link")).click();

        //Write any amount you want to deposit in the amount section
        //write "2020-09-10" in the date field
        WebElement amount= driver.findElement(By.id("sp_amount"));
        amount.sendKeys("5000",Keys.TAB,
                "2020-09-10");


        //Click the Share button
        driver.findElement(By.id("pay_saved_payees")).click();

        //"The payment was successfully submitted." Check if the message appears
        String actualSuccesMessage =  driver.findElement(By.xpath("//*[.='The payment was successfully submitted.']")).getText();
        String expectedSuccesMessage="The payment was successfully submitted.";
        Assertions.assertEquals(expectedSuccesMessage,actualSuccesMessage);

        //close the page
        driver.close();

    }
}
