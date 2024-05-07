package day12_faker_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileText {

    @Test
    void test01() {
        /*
        System.getProperty("user.dir") --->   javada programin su anda calisan klasor(dizin) verir.
                                                ===  (current working directory)   ===
         */
        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));
        /*
        Bilgisayarınızda bulunan herhangi bir dosyanin varligini test edebilmeniz icin oncelikle varligini test etmek
        istedigimiz dosyanin yolunu >>>>path<<<<  almalıyız

        Sonra ise Files.exists()  methodu ile test gerceklestirecegiz
         */

          //C:\Users\Mustafa           \Desktop\Batch231.txt
        String ortakYol ="\\Desktop\\Batch231.txt";
        String dynamicPath =System.getProperty("user.home") + ortakYol;
        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));
             /*
                     Files.exists(Paths.get(dynamicPath) methodunu       kullanarak belirtmis oldugumuz
                     path objectinin dosya sistemimizde var olup olmadigini kontrol ettik
             */
    }
}
