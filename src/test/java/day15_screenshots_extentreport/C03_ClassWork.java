package day15_screenshots_extentreport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_ClassWork extends TestBase {

    @Test
    void test01() {

//Go to Techproeducation page
        driver.get("https://techproeducation.com/");

//Verify that the home page has loaded successfully.
        Assertions.assertEquals("https://techproeducation.com/",driver.getCurrentUrl());

//Take a screenshot of the page
        screenShot();

//Verify that the phone number displayed on the page is +1 585 304 29 59
        WebElement phoneNumber =driver.findElement(By.xpath("(//a[.='+1 585 304 29 59'])[1]"));
        Assertions.assertEquals("+1 585 304 29 59",phoneNumber.getText());

//take a screenshot of the displayed phone number
        screenShotOfWebElement(phoneNumber);
        waitForSecond(1);

//print selenium in search box and take screenshot of search box
        WebElement searchBox=driver.findElement(By.id("searchHeaderInput"));
        searchBox.sendKeys("selenium");
        screenShotOfWebElement(searchBox);
    }
}
