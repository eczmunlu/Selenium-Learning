package day15_screenshots_extentreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_WebElementScreenShot extends TestBase {

    @Test
    void test01() throws IOException {

        //go to the Amazon page
        driver.get("https://amazon.com");

        //search for laptop in the search box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop ",Keys.ENTER);

        //take the screenshot
        screenShot();

        //get the image of the result text webelement
        WebElement resultText= driver.findElement(By.xpath("//*[contains  (text() , 'results for')]"));

        String date= DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path="src/test/java/screenshots/resultTextWebElement"+date+".png";
        Files.write(Paths.get(path),resultText.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    void test02() {
        //go to the Amazon page
        driver.get("https://www.amazon.com");

        //search for laptop in the search box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop ",Keys.ENTER);

        //take the screenshot
        screenShot();

        //get the image of the result text webelement-------  reusuable method ile
        WebElement resultText= driver.findElement(By.xpath("//*[contains  (text() , 'results for')]"));
        screenShotOfWebElement(resultText);



    }
}
