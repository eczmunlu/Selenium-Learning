package day06_xpath_css;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    /*
        /   --> Bir alt child i secer
        //  --> Sayfadaki herhangi bir webelementi secer    orn  //div
        @   --> Bir webelementinin attribute unu secmek icin kullanilir
        []  --> Index veya kosul belirtmek icin kull
        *   --> All    farketmeksizin sec  demektir

        SYNTAX:

          //tagname [ @ attribute name  = ' attribute value ' ] ----------->  "" cift tirnak ta olur
          //   *    [ @         *       = ' attribute value ' ]
        ( //tagname [ @ attribute name  = ' attribute value ' ] ) [ index ]
     */

    //web sayfasına gidin. https://www.amazon.com/
    //Arama kutusunda "city bike" aratin (arama kutusunu xpath ile locate edin)
    //Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
    //Sadece sonuc sayısını yazdırınız
    //Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
    //sayfayi kapatınız

    @Test
    void test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //go to the web page. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);


        //Search "city bike" in the search box (locate the search box with xpath)
        WebElement searchbox = driver.findElement(By.xpath("//input [@type = 'text']"));
        searchbox.sendKeys("city bike", Keys.ENTER);

        //Print the number of relevant results displayed on Amazon
        WebElement resultText = driver.findElement(By.xpath("(//div[@class ='sg-col-inner'])[1]"));
        System.out.println("resultText = " + resultText.getText());

        //Just print the result number
        System.out.println("result = " + resultText.getText().split(" ")[2]);

        //Then click on the text of the first result that appears.
        driver.findElement(By.xpath("(//h2)[1]/a")).click();

        //close the page
         driver.quit();
    }
}
