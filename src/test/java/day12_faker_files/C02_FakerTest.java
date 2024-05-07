package day12_faker_files;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FakerTest extends TestBase {

    //Go to https://www.globalsqa.com/samplepagetest/
    //Fill textboxes with fake data

    @Test
    void fakerTest() {

        //https://www.globalsqa.com/samplepagetest/ sitesine gidin
        driver.get("https://www.globalsqa.com/samplepagetest/");


        //Textbox lari fake datalar ile doldurun
        Faker faker=new Faker();

        WebElement nameBox=driver.findElement(By.id("g2599-name"));
        nameBox.sendKeys(faker.name().firstName(), Keys.TAB,
        faker.internet().emailAddress(),Keys.TAB,
        faker.internet().domainName());

        WebElement commentBox=driver.findElement(By.id("contact-form-comment-g2599-comment"));
        commentBox.sendKeys(faker.lorem().paragraph());
    }
}
