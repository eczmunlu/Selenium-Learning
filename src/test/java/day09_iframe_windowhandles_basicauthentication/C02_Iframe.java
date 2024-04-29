package day09_iframe_windowhandles_basicauthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

//Go to https://the-internet.herokuapp.com/iframe
//Verify that the bold text contains the word "Editor"
//Delete the text in the textbox.
//Instead of the text you deleted, write "This textbox is located in iFrame".
//Verify that the "Elemental Selenium" text is on the page.



    @Test
    void test01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertTrue(actualText.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox=driver.findElement(By.xpath("//p"));
        textBox.clear(); //  silme işlemi yapar

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSelenium =driver.findElement(By.partialLinkText("Elemental Selenium"));
        Assertions.assertEquals("Elemental Selenium",elementalSelenium.getText());
    }
     /*
        HOMEWORK:
        //https://html.com/tags/iframe/ sayfasina gidiniz
        // sayfada bulunan youtube videosunu baslatiniz
         */
}
