package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {


    //access modifier lari secerken mumkun oldugunca ihtiyacimizi gideren en dar kapsamli olani secmemiz tavsiye edilir
    protected WebDriver driver;

    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;

    public void createExtentReport(String testName){
        //Bu objecti raporlari olusturmak ve yönetmek icin kullanacağız
        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter=new ExtentHtmlReporter(path);

        //ExtentReports' a HTML raporlayiciyi ekler, Bu raporun html formatinda olusturulmasini saglar.
        extentReports.attachReporter(extentHtmlReporter);

        //HTML reportun title kısmını ayarlar, browser sekmesinde görüntülenir
        extentHtmlReporter.config().setDocumentTitle("Batch 231 Test Report");

        //Raporun adini ayarlar, bu raporda görüntülenecek olan genel basliktir
        extentHtmlReporter.config().setReportName("My Extent Report");

        //Bu html reportunda görmek isteyebileceğimiz diger bilgileri asagidaki sekilde key valua olarak girebiliriz
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Ali Can");

        //Amazon Test adinda yeni bir test olusturur ve bu teste Test Steps alt basligini aciklama olarak ekler
        extentTest=extentReports.createTest(testName,"Test Steps");
    }



    @BeforeEach
    void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterEach
    void tearDown() {
        //  driver.quit();

    }

    //Hard Wait
    public void waitForSecond(int second)  {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //select visibleText DropDownMenu
    public void selectVisible(WebElement ddm,String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //select Index DropDownMenu
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void switchToWindow(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }



    //File Upload Robot Class
    public void uploadFilePath(String dosyaYolu){
        try{
            waitForSecond(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();
            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);
            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);
            // Sonraki işlemler için ek 3 saniye bekler.
        }catch (Exception ignored){
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }
    }

    //Tam ekran screenshot
    public void screenShot(){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\screenShot"+date+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(path),  ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Webelement screen shot
    public void screenShotOfWebElement( WebElement webElement ){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\webElementSS"+date+".png";
        try {
            Files.write(Paths.get(path),  webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //extent rapora ekran görüntüsü ekleme
    public void addScreenShotToReport(){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\screenShot"+date+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(path),  ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+path);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //rapora Webelement screen shot ekleme
    public void addScreenShotOfWebElementToReport( WebElement webElement ){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\webElementSS"+date+".png";
        try {
            Files.write(Paths.get(path),  webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}