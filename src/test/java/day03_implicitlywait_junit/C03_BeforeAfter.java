package day03_implicitlywait_junit;

import org.junit.jupiter.api.*;

public class C03_BeforeAfter {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll notasyonuna sahip olan bir metod class taki tum test metodlarindan once 1 kez calisir");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach notasyonuna sahip olan bir metod her bir test metodlarindan once 1 kez calisir");
    }

    @Test
    void test01() {
        System.out.println(" test01 calisti");
    }
    @Test
    void test02() {
        System.out.println(" test02 calisti");
    }
    @Test @Disabled
    void test03() {
        System.out.println(" test03 calisti");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach notasyonuna sahip olan bir method her bir test methodundan sonra 1 kez calistirilir.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll notasyonuna sahip olan bir method class taki tum test methodlarindan sonra 1 kez calistirilir.");
    }
}
