package day11_actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    /*
    Sayfadaki bir webelementi locate ettigmiz halde NoSuchElement EXCEPTION aliyorsak

    1) Wait / Syncronization problemi olabilir ==> ImplicitlyWait süresini artirabiliriz.
    2) Locate kontrol edilmelidir
    3) Webelmenet iframe icinde olup olmadigina bakariz
    4) Driver webelementi göremiyor olabilir, dolayisiyla actions class ile scroll yapip webelementin görünür
    olmasini saglariz
     */

    @Test
    void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        Actions actions = new Actions(driver);
        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(2);


        for (int i = 0; i < 3; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitForSecond(2);

        }

        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.PAGE_UP).perform();
            waitForSecond(2);
        }
    }

    @Test
    void test02() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        waitForSecond(2);

        //Sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();

    }

    @Test
    void test03() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        // Events yazisina kadar scroll yap
        Actions actions=new Actions(driver);
        WebElement event =driver.findElement(By.xpath("//h2[.='Events']"));
        actions.scrollToElement(event).perform();
    }
}
