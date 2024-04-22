package day04_assertions_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {

    /*
    Junit 4 de assertion yapmak icin assert class ı kullaniliyordu.
    Junit 5 de assertion yapmak icin assertion class ı kullanilir.
     */

    @Test
    void test01() {
        String expectedData="Junit 4";
        String actualData="Junit 5";
        Assertions.assertEquals(expectedData,actualData);
    }

    @Test
    void test02() {
        Assertions.assertTrue(3<5);
    }

    @Test
    void test03() {
        Assertions.assertFalse( "selenium".contains("E"));//PASS
    }

    @Test
    void test04() {
        Assertions.assertNotEquals("selenium","junit");//PASS
    }
// İKİ ARRAY IN ESIT OLABILMESI ICIN AYNI INDEX TE AYNI ELEMAN OLMASI GEREKIR
    @Test
    void test05() {
        char [] expectedArray={'j','u','n','i','t'};
        char [] actualArray={'j','u','n','i','t'};
        Assertions.assertArrayEquals(expectedArray,actualArray);
    }

    @Test
    void test06() {
        String str=null;
        Assertions.assertNull(str);//pass
    }

    @Test
    void test07() {
        String str="null";
        Assertions.assertNotNull(str);//pass

    }
}
