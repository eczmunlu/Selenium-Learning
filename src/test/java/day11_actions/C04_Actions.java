package day11_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {

//Go to https://jqueryui.com/droppable/
//Drag me to my target webelement onto the Drop here webelement


    @Test
    void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/ ");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        // alttaki 3 basamak ı yaptık hata aldık. çalışacağımız yerin locati doğru mu diye kontrol ettik doğru ancak
        // iframe içinde .inspect te iframe var mı diye aradık 1 tane varmış index ile gecis yaptık

        driver.switchTo().frame(0);

        Actions actions =new Actions(driver); //1
        WebElement source =driver.findElement(By.xpath("//p[.='Drag me to my target']"));//2a
        WebElement target =driver.findElement(By.xpath("//div[@id='droppable']"));//2b
        actions.dragAndDrop(source,target).perform();//3

    }

    @Test
    void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/ ");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);

        Actions actions =new Actions(driver); //1
        WebElement source =driver.findElement(By.xpath("//p[.='Drag me to my target']"));//2a
        WebElement target =driver.findElement(By.xpath("//div[@id='droppable']"));//2b
      // actions.clickAndHold(source) // source elementine mouse i basılı tutar
      //         .moveToElement(target) // basılı tutarak aldığı source yi target a surukler
      //         .release() // target a gidince mouse ın tık ını serbest bırakır
      //         .perform(); // uygula

        actions.clickAndHold(source).moveByOffset(138,50).release().perform();  //  istediğimiz koordinata götürmek için

        // homework
        // drag and drop sonrası işlem başarılı mı değil mi test et
        //p[text()='Dropped!']

        String actualText =driver.findElement(By.id("droppable")).getText();
        String expectedText ="Dropped!";
        //System.out.println("actualText = " + actualText);
        Assertions.assertEquals(expectedText,actualText);



    }
}
