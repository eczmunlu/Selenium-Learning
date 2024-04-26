package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {
    /*
        --------------------------   SYTAX    ---------------------------------------------------

       1)                                   tagname     [   attributeName   =   'attributeValue' ]

       2) id ile css locate alınacaksa                      #idAttributeValue

       3) class ile css selector ile locate                 .classAttributeValue


       XPath ile CssSelector arasindaki fark ============================================================

       1-Css  de index kullanimi yok , Xpath  ile bir webelement için birden fazla sonuc varsa index ile tek e dusururuz

       2-Xpath ile bir webelementi sadece text i ile locate edebiliriz. Fakat Css ile bu olmaz.

       3-CssSelector Xpath a gore daha hizli calisir.

     */

    //Go to https://the-internet.herokuapp.com/add_remove_elements/
    //Press the Add Element button
    //Test that the delete button is visible
    //press the delete key
    //Test that the "Add/Remove Elements" text is visible
    //close the page

    @Test
    void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.cssSelector("button[ onclick = 'addElement()']")).click();

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton =driver.findElement(By.cssSelector("button[class]"));
        Assertions.assertTrue(deleteButton.isDisplayed());
        Thread.sleep(3000);

        //Delete tusuna basin
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        Assertions.assertTrue(driver.findElement(By.cssSelector("h3")).isDisplayed());
        //sayfayı kapatınız
        driver.quit();

    }
}
