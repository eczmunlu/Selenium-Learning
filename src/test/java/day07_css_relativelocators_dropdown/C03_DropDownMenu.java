package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDownMenu {

    /*

    --------------------------    DROPDOWN   ------------------------------
    Dropdown u automate etmek icin;
    1-Dropdown menuyu ilk olarak locate ederiz
    2-Select object olusturulur
    3-select objesi uzerinde cesitli metodlar sayesinde dropdown seceneklerine erisim saglanır

            ==========    SYNTAX :

            Select options = ( new Select ( WebElement dropdown );

            A- selectByVisibleText() ---> dropdown menudeki gorunur  text ile ulasmak icin kullanilir
            B- selectByIndex()----------> ındex ile ( o dan baslar) ulasmak icin kullanilir
            C- selectByValue()----------> value attribute degeri ile ulasmak icin kull.

    4-getOptions() -> Locate ettigimiz dropdown menudeki tum secenekleri verir.---List<WebElement> e atariz
    5-getFirstSelectedOption() -> dropdown menudeki secili secenegi verir.

    */
WebDriver driver;
    @BeforeEach
    void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown ");
    }

    @AfterEach @Disabled
    void tearDown() {
        driver.quit();
    }

    @Test
    void test01() {
        //     1.Method:
        //         a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year=driver.findElement(By.id("year"));
        WebElement month=driver.findElement(By.id("month"));
        WebElement day=driver.findElement(By.id("day"));

        //         b. Select objesi olustur
        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);

        //         c. Select object i kullanarak 3 farkli sekilde secim yapiniz
        selectYear.selectByIndex(0); // index 0 dan baslar
        selectMonth.selectByValue("4"); //<option value="4">May</option> =>buradaki value ya gore secilir
        selectDay.selectByVisibleText("15");//ekranda gorulen Text e göre secilir

    }

    @Test
    void test02() {
        //     2.Method:
        //         a. Tüm eyalet isimlerini yazdıralım
        WebElement states=driver.findElement(By.cssSelector("#state"));
        Select select = new Select(states);
        List<WebElement> stateList=  select.getOptions();

       //  1.YOL

       //  int i=1;
       //  for (WebElement w:stateList){
       //      System.out.println(i + ". "+ w.getText());
       //      i++;
       //  }

        //  2.YOL

        stateList.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    void test02a() {
        List <WebElement> statesList=
                driver.findElements(By.xpath("//select[@id='state']/option"));

        statesList.forEach(t-> System.out.println(t.getText()));
    }

    // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    // -3 farklı test methodu oluşturalım
    //     1.Method:
    //         a. Yil,ay,gün dropdown menu'leri locate ediniz
    //         b. Select objesi olustur
    //         c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    //     2.Method:
    //         a. Tüm eyalet isimlerini yazdıralım
    //     3.Method:
    //         a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
}
