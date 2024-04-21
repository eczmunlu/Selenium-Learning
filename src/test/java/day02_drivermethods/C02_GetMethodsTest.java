package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_GetMethodsTest {
    public static void main(String[] args) {
        // Go to TechproEducation page https://www.techproeducation.com/
        // Print the page title
        //Test if the page title contains "IT"
        // Print the page address (url)
        // Test that the page url contains "education".
        //Print the page handle value
        // Test whether the word "IT Programs" appears in the page HTML codes
        // Close the page.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        TechproEducation sayfasina gidin. https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        //  Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        //  Sayfa basliginin "IT" icerdigini test edin
        if(actualTitle.contains("IT")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //  Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        //  Sayfa url'inin "education" icerdigini test edin.
        if(actualUrl.contains("education")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //  Sayfa handle degerini yazdirin
        String windowHandle =driver.getWindowHandle();
        System.out.println("windowHandle = " + windowHandle);


        //  Sayfa HTML kodlarinda "IT Programs" kelimesi gectigini test edin
        String techproPageSource = driver.getPageSource();

        if(techproPageSource.contains("IT Programs")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //  Sayfayi kapatin.

        driver.close();//Driver in en son bulundugu sayfaya kapatir ve oturumu sonlandirmaz
        // driver.quit();//Birden fazla acilan pencereler var ise hepsini kapatir ve oturumu sonlandirir












    }
}