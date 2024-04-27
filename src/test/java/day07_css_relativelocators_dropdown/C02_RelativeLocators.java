package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_RelativeLocators {


//Go to https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
//Locate Berlin with relative locator
//Test that relative locators are working correctly
//close the page


    @Test
    void test01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //Berlin'i relativ_e locator ile locate edin
       WebElement nyc=  driver.findElement(By.id("pid3_thumb"));
       WebElement byArea=driver.findElement(By.id("pid8_thumb"));
       WebElement berlin=  driver.findElement( with(By.tagName("img")).below(nyc).toLeftOf(byArea) );
        //Relative locator'larin dogru calistigini test edin
        String expectedIdValue = "pid7_thumb";
        String actualIdValue = berlin.getAttribute("id");
        Assertions.assertEquals(expectedIdValue,actualIdValue);

        //sayfayı kapatınız
        driver.quit();


    }


}