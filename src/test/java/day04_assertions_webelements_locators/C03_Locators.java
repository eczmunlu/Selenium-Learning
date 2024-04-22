package day04_assertions_webelements_locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Locators {

    //Go to Amazon page
    //Locate the search box and print and search for iPhone
    //close the page

    @Test
    void test01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        aria-label="Search Amazon" spellcheck="false">
         */

        //Arama kutusunu locate ediniz ve iphone yazdırıp aratınız

        //            A. YOL

       // WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        // searchBox.sendKeys("iphone", Keys.ENTER);
        //searchBox.submit();

        /*
        bir arama kutusunda locate edip bir text gonderirsek iki sekilde enter a basilir

        1-  submit()  meth

        2- sendKeys () methodu icinde body de string ifadeden sonra     Keys.ENTER   (==>ENUM)      yazilir
         */

        //       B.   YOL

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //        C .    YOL
        driver.findElement(By.name("field-keywords")).sendKeys("iphone",Keys.ENTER);


        //sayfayı kapatınız
        driver.quit();


    }
}
