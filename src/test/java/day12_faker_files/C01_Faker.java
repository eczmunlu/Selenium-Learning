package day12_faker_files;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class C01_Faker {

    @Test
    void fakerClassWork() {

        //faker objesi ile fake bir isim yazdırınız
        Faker faker=new Faker();
        System.out.println("firstName = " + faker.name().firstName());

        //faker objesi ile fake bir soyisim yazdırınız
        System.out.println(faker.name().lastName());

        //faker objesi ile fake bir adress yazdırınız
        System.out.println(faker.address().fullAddress());

        //faker objesi ile fake bir telefon No yazdırınız
        System.out.println(faker.phoneNumber().cellPhone());

        //faker objesi ile fake bir email yazdırınız
        System.out.println(faker.internet().emailAddress());

        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        String number=faker.number().digits(15);
        System.out.println("number = " + number);

        //faker objesi ile fake bir isimsoyisim yazdırınız
        System.out.println(faker.name().fullName());
    }

    @Test
    void test01() {
        /*
        Eger       belli bir bolgeye     ozel fake data     olusturmak istersek bunu           local class i
        araciligiyla asagidaki gibi yapabiliriz.
         */
        Faker faker=new Faker(new Locale("TR"));
        System.out.println(faker.name().fullName());
        System.out.println(faker.address().fullAddress());
    }
}
