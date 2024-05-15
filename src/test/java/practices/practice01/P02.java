package practices.practice01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class P02 extends TestBase {

    // Go to https://testpages.herokuapp.com/styled/calculator
    // Test the application for mathematical operations by creating four different test methods.





    @Test
    void plus() {

        // https://testpages.herokuapp.com/styled/calculator adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // Dört farkli test metdhodu olusturarak matematiksel işlem icin uygulamayi test edin.
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);// ilk kutu 12 yazdık
        driver.findElement(By.id("function")).sendKeys("plus"); //dropdown menuden select ile de yapılabilirdi.!!!!!!!!sendkeys ile kısayoldan // + seçtik
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);// ikinci kutuya 3 yazdık
        driver.findElement(By.id("calculate")).click(); // calculate e bastık

        String result=driver.findElement(By.cssSelector("#answer")).getText();
        Integer expectedResult=Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber);
        Integer actualResult=Integer.valueOf(result);
        assertEquals(expectedResult,actualResult,"Toplama islemi hatali");

    }
    @Test
    void minus() {

        // https://testpages.herokuapp.com/styled/calculator adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // Dört farkli test metdhodu olusturarak matematiksel işlem icin uygulamayi test edin.
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);// ilk kutu 12 yazdık
        WebElement ddm=driver.findElement(By.id("function"));
        selectVisible(ddm,"minus"); //dropdown menuden select ile de yapılabilirdi.!!!!!!!!
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);// ikinci kutuya 3 yazdık
        driver.findElement(By.id("calculate")).click(); // calculate e bastık

        String result=driver.findElement(By.cssSelector("#answer")).getText();
        Integer expectedResult=Integer.valueOf(firstNumber) - Integer.valueOf(secondNumber);
        Integer actualResult=Integer.valueOf(result);
        assertEquals(expectedResult,actualResult,"Cıkarma islemi hatali");

    }
    @Test
    void times() {

        // https://testpages.herokuapp.com/styled/calculator adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // Dört farkli test metdhodu olusturarak matematiksel işlem icin uygulamayi test edin.
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);// ilk kutu 12 yazdık
        WebElement ddm=driver.findElement(By.id("function"));
        selectVisible(ddm,"times"); //dropdown menuden select ile de yapılabilirdi.!!!!!!!!
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);// ikinci kutuya 3 yazdık
        driver.findElement(By.id("calculate")).click(); // calculate e bastık

        String result=driver.findElement(By.cssSelector("#answer")).getText();
        Integer expectedResult=Integer.valueOf(firstNumber) * Integer.valueOf(secondNumber);
        Integer actualResult=Integer.valueOf(result);
        assertEquals(expectedResult,actualResult,"Carpma islemi hatali");

    }
    @Test
    void divide() {

        // https://testpages.herokuapp.com/styled/calculator adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // Dört farkli test metdhodu olusturarak matematiksel işlem icin uygulamayi test edin.
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);// ilk kutu 12 yazdık
        WebElement ddm=driver.findElement(By.id("function"));
        selectVisible(ddm,"divide"); //dropdown menuden select ile de yapılabilirdi.!!!!!!!!
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);// ikinci kutuya 3 yazdık
        driver.findElement(By.id("calculate")).click(); // calculate e bastık

        String result=driver.findElement(By.cssSelector("#answer")).getText();
        Integer expectedResult=Integer.valueOf(firstNumber) / Integer.valueOf(secondNumber);
        Integer actualResult=Integer.valueOf(result);
        assertEquals(expectedResult,actualResult,"Bolme islemi hatali");

    }
}
