package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P02 extends TestBase {

    @Test
    void test01() {

        // https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        // click me buttonu na tiklayiniz
        WebElement button= driver.findElement(By.id("growbutton"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(driver->button.getAttribute("class").contains("grown")); //  driver yerine t de denebilirdi mustafa da denebilir
        button.click();



        // "Event Triggered" yazisinin görüntülendigini dogrulayiniz
        Assertions.assertEquals("Event Triggered",driver.findElement(By.id("growbuttonstatus")).getText());

    }

    @Test
    void test02() {   //  farklı yöntem !!!!!!!!!!
        // https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        // click me buttonu na tiklayiniz
        WebElement button= driver.findElement(By.id("growbutton"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));     // !!!!!!!!!!!!!!!!!!!!!!!!!
        wait.until(ExpectedConditions.attributeContains(button,"class","grown"));
        button.click();



        // "Event Triggered" yazisinin görüntülendigini dogrulayiniz   //    ikinci yontem   !!!!!!!!!!!!!!
        WebElement eventTriggerdWebElement = driver.findElement(By.id("growbuttonstatus"));
        Assertions.assertTrue(eventTriggerdWebElement.isDisplayed());

    }
     /*
    Button webelementinin class atribute degeri grown icerene kadar bekle,
    dynamic webelementler ile calisirken bu tarz yöntemler kullanilabilir
     */
}
