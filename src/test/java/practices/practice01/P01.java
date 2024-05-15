package practices.practice01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class P01 {
      /*
    https://www.youtube.com adresine gidin
   Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
   TEST1=> Sayfa başlığının "YouTube" oldugunu test edin
        => YouTube logosunun görüntülendiğini (isDisplayed()) test edin
   TEST2=> Search Box 'in erisilebilir oldugunu test edin (isEnabled())
   TEST3=> wrongTitleTest  => Sayfa basliginin "youtube" olmadigini dogrulayin
*/
      WebDriver driver;
    @BeforeEach
    void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    void test01() {
        String expectedTitle ="YouTube";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle,"Sayfa baslıkları uyumlu degil");
        WebElement logo=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        assertTrue(logo.isDisplayed(),"Logo goruntulenemedi");
    }

    @Test
    void test02() {
        WebElement searchBox=driver.findElement(By.xpath("//input[@id]"));
        assertTrue(searchBox.isEnabled());
    }

    @Test
    void test03() {
        assertNotEquals("youtube",driver.getTitle());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
