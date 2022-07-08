package localDateTime;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    @Test
    void parse(){
        LocalDate localDate = LocalDate.now();

        String yyyyMMdd = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));


        String s = localDate.toString();



        System.out.println(yyyyMMdd);

    }

    @Test
    void unmarshalling(){
        String s = "20151215";

        LocalDate localDate = LocalDate.parse(s,DateTimeFormatter.ofPattern("yyyyMMdd"));

        System.out.println(localDate);
    }
}
