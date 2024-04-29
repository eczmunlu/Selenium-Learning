package day09_iframe_windowhandles_basicauthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {

//On Windows 1, go to https://www.techproeducation.com
//Verify that the title contains "TechPro Education"
//Open https://www.youtube.com in Windows 2 (in a new window)
//In Windows 3 (in a new window), open https://www.linkedin.com:
//Go to the techproeducation page,
//go to youtube page,
//Go to LinkedIn page

    @Test
    void test01() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle =driver.getWindowHandle();

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));
        waitForSecond(2);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere acar ve driver ı buraya geçiş yaptırır. !!!!!
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle= driver.getWindowHandle();
        waitForSecond(2);

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.linkedin.com");
        String linkedinWindowHandle= driver.getWindowHandle();
        waitForSecond(2);

        //techproeducation sayfasına geçiniz,
        driver.switchTo().window(techproWindowHandle);
        waitForSecond(2);

        //youtube sayfasına geçiniz,
        driver.switchTo().window(youtubeWindowHandle);
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(linkedinWindowHandle);

         /*
        Acilmis olan tum pencerelerin window handle degerlerini getWindowHandles() method ile aldik.
        Bu method bize Set return eder, ancak setlerde index kullanarak istedigimiz bir elemani secmek mumkun degildir
        Bu nedenle bizde bu seti kullanarak bir tane List olusturduk
        Listlerde get methodu sayesinde index ile istedigimiz pencereye rahat gecis yapabiliriz
         */

        //techproeducation sayfasına geçiniz,

        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(0));
        waitForSecond(2);

        //youtube sayfasına geçiniz,
        driver.switchTo().window(windowsList.get(1));
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(windowsList.get(2));

    }
}
