package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_Driver {
    /*
   WebdriverManager sayesinde istedigimiz browser icin setup yaparak otomasyonda kullanabiliriz
   Bu sayede browser a gore gerekli olan driver i bilgisayarimiza indirmek, yapilandirmak.. zorunda kalmayiz
    */

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver edgeD = new EdgeDriver();
        edgeD.get("https://google.com");
        edgeD.quit();

        WebDriverManager.chromedriver().setup();
        WebDriver chromeD = new ChromeDriver();
        chromeD.get("https://google.com");
        chromeD.quit();

    }
}
