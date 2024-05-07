package day15_screenshots_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    /*
    ExtentReport kullanabilmek icin 3 class a ihtiyac vardir.
    1) ExtentReports classindan raporlamayi baslatmak icin bir object olusturmamiz gerekir
    2) ExtentHtmlReporter classindan raporlari html formatinda olusturmasi icin object olusturmamiz gerekir
    3) ExtentTest classindan test adimlarina bilgi ekleyebilmek icin bir object olusturmamiz gerekir
     */

public class C04_ExtentReport {

    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    void extentReportTemplate() {

        //Bu objecti raporlari olusturmak ve yönetmek icin kullanacağız
        extentReports=new ExtentReports();

        /*
        Oncelikle olusturmak istedigimz html reportu project imizde nerede saklamak istiyorsak bir dosya yolu
        olusturmaliyiz, cunku bu path i kullanarak bir tane html report olusturacağız
        bunun icin ExtentHtmlReporter classindan object olusturmaliyiz
         */

        String date= DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path="target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter=new ExtentHtmlReporter(path);

        // ExtentReport a HTML raporlayiciyi ekler, bu raporun html formatinda olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);

        //HTML reportun title kismini ayarlar,browser sekmesinnde goruntulenir
        extentHtmlReporter.config().setDocumentTitle("Batch 231 Test Reports");

        //Raporun adini ayarlar, bu rapordaki ana basliktir
        extentHtmlReporter.config().setReportName("My Extent Report");

        //Bu HTML report unda gormek istedigimiz diger bilgileri asagidaki key value olarak gireriz
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Ali Can");

        //Amazon Test adinda yeni bir test olusturur ve bu teste Test Steps alt basligini aciklama olarak ekler
        extentTest=extentReports.createTest("Amazon Test","Test Steps");

        // ====================      BURAYA KADAR SABLON AYARLAMASI TAMAMLANDI    =======================

        // Testin basarili oldugunu belirtir,   rapora PASS ekler

             extentTest.pass("PASS");

        //  Testin basarisiz oldugunu belirtir FAIL ekler

             extentTest.fail("FAIL");

        // Test ile ilgili bilgilendirici not ekler

            extentTest.info("BILGILENDIRME NOTU");

        // Test ile ilgili UYARI MESAJI notunu ekler

            extentTest.warning("UYARI MESAJI");

        // Testin atlandigini belirten mesaj  rapora ekler

            extentTest.skip("ATLATMA MESAJI");

        //Tum test verilerini kaydeder ve HTML raporu olusturur

            extentReports.flush();


    }
}
