package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {

    //access modifier lari secerken mumkun oldugunca ihtiyacimizi gideren en dar kapsamli olani secmemiz tavsiye edilir
    protected  WebDriver driver;

    @BeforeEach
    void  setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    void tearDown() {

        // driver.quit();
    }

    // Hard Wait
     public void waitForSecond (int second){
         try {
             Thread.sleep(second*1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }

     // select visibleText DropDownMenu
    public void selectVisible(WebElement ddm, String option){
        Select select=new Select(ddm);
        select.selectByVisibleText(option);
    }

    //select Index DropDownMenu
    public void selectIndex (WebElement ddm, int index){
        Select select=new Select(ddm);
        select.selectByIndex(index);
    }

    //select Value DropDownMenu
    public void selectValue (WebElement ddm, String value){
        Select select=new Select(ddm);
        select.selectByValue(value);
    }

}
