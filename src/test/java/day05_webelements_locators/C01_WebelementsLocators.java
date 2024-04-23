package day05_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_WebelementsLocators {
    // Go to Google page
    // Find the search box according to the "name" attribute and type "selenium"
    // Make the call
    //Test that the header contains selenium
    //Print how many links are on the page to the console
    //If the links on the page have text, print them to the console
    //close the page


    @Test
    void test01() {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Google sayfasına gidelim
        driver.navigate().to("https://google.com");

       // <textarea class="gLFyf" aria-controls="Alh6id" aria-owns="Alh6id" autofocus="" title="Ara" value="" jsaction="paste:puy29d;" aria-label="Ara" -aria-autocomplete="both" aria-expanded="true" aria-haspopup="false" autocapitalize="off" autocomplete="off" autocorrect="off" id="APjFqb" maxlength="2048" name="q" role="combobox" rows="1" spellcheck="false" data-ved="0ahUKEwiGqpG_99eFAxVKRPEDHeppD88Q39UDCAU" aria-activedescendant="" style=""></textarea>

        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalim
        WebElement searchBox =driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");

        // Aramayı yapalim
        searchBox.submit();

        //Başlığın selenium içerdiğini test edelim
        Assertions.assertTrue(driver.getTitle().contains("selenium"));

        //Sayfada kaç tane link olduğunu yazdıralım
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("linklerin sayisi = " + links.size());

        /*
        Eger birden fazla webelementi locate etmek istiyorsak findElements methodu kullaniriz
        Bu method bize elemanlari webelement olan bir list return eder

        Uzerinde yazisi olan bir webelement icin o yaziyi alabilmek icin getText() methodunu kullaniriz

         */

        //Sayfadaki linklerin metinleri varsa konsola yazdıralım        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for ( WebElement  w : links){
            if(!w.getText().isEmpty()){
                System.out.println(w.getText());
            }
        }
        //sayfayı kapatalım
        driver.quit();
    }
}