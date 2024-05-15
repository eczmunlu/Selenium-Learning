package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P01 extends TestBase {

    @Test
    void test01() {

// https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");

// select Option2 from the radio button
        driver.findElement(By.id("vfb-7-2")).click();

// select if checkbox1 and checkbox3 are not selected
        WebElement checkBox1=driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox3=driver.findElement(By.id("vfb-6-2"));
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        if (!checkBox3.isSelected()){
            checkBox3.click();
        }

// Test that Option2 is selected from the radio button
        Assertions.assertTrue(driver.findElement(By.id("vfb-7-2")).isSelected());

//Test that Option 3 is not selected in the radio button
        Assertions.assertFalse(driver.findElement(By.id("vfb-7-3")).isSelected());

//test that checkbox1 and checkbox3 are selected
        Assertions.assertTrue(checkBox1.isSelected() && checkBox3.isSelected());

//test if checkbox2 element is not selected
        Assertions.assertFalse(driver.findElement(By.id("vfb-6-1")).isSelected());
    }
}
