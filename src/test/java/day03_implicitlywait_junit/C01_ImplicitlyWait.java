package day03_implicitlywait_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWait {
    /*
    Bir sayfaya gittigimizde internetten kaynakli yada sayfaya ayni anda cok fazla giris yapilmasindan kaynakli
    web elementler hemen yüklenmeyebilir. Dolayisiyla islem yapilmak istenen web element henuz yuklenmemisse kodlarimiz
    bu elemeti bulamaz ve hata aliriz.
    Iste bu nedenle implicitlyWait metodu ile bekleme yaparak bu sayfanin yuklenmesini belirtecegimiz max sure icin
    bekletme saglariz.Eger belirtilen sureden once yukleme tamamlanirsa kalan sure icin bekleme yapmaz, dinamik bir suredir.

    ImplicitlyWait ile isimizin cogunu hallederiz geriye kalan detaylar icin ileride excipitlyWait i kullanicagiz
     */
    public static void main(String[] args) {

       //Go to TechProEducation page
       //test that the page title contains TechPro Education
       //go to facebook page
       //test that the page url contains facebook
       //go back to techpro page
       //Test that you are back
       //close the page

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();// driver tum web elementleri rahatlikla görsün
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// driver tum web elementleri yuklenmesini beklesin


        //techpro sayfasına gidiniz
        driver.get("https://techproeducation.com");
        //sayfa başlığının TechPro Education içerdiğini test ediniz
        String ecpextedData="TechPro Education";
        String actualData = driver.getTitle();
        if (actualData.contains(ecpextedData)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        //sayfa url'inin facebook içerdiğini test ediniz
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //techpro sayfasına geri dönününüz
        driver.navigate().back();

       //Geri döndüğünüzü test ediniz

        //1.YOL
        if (driver.getTitle().equals("TechPro Education IT Programs")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        //2.YOL
        if (driver.getCurrentUrl().equals("https://techproeducation.com/")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //sayfayı kapatınız
        driver.quit();

    }
}
