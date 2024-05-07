package day11_actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {

    @Test
    void test01() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java  yazdıralım
        WebElement searchBox=driver.findElement(By.id("APjFqb"));
        Actions actions=new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT) // arama kutusunda shift e basılı tutar
                .sendKeys("selenium") // shift basılı iken selenium yazar
                .keyUp(searchBox,Keys.SHIFT) // shift tusundan elini kaldırır
                .sendKeys("  _  java",Keys.ENTER)
                .perform();

    }
    @Test
    void test02() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java  yazdıralım
        WebElement searchBox=driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"  -java",Keys.ENTER);



    }
}
