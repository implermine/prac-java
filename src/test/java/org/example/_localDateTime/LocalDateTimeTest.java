package org.example._localDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {

    @Test
    @DisplayName("원하는 String 형태로 LocalDate 객체를 나타내기")
    void test1(){
        LocalDate localDate = LocalDate.now();

        String yyyyMMdd = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));

        System.out.println(yyyyMMdd);
    }

    @Test
    @DisplayName("원하는 String 형태로 LocalDateTime 객체를 나타내기")
    void localDateTimeToString(){
        LocalDateTime localDateTime = LocalDateTime.now();

        String yyyyMMdd = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        System.out.println(yyyyMMdd);
    }


    /**
     * 해당 rule에 대해선 다음을 참고
     *
     * https://shinsunyoung.tistory.com/49
     * DateTimeFormatterBuilder::appendPattern
     */
    @Test
    @DisplayName("String 형태인 시간데이터를 LocalDateTime 객체로 나타태기")
    void test2(){
        String given = "20220828:11:30:24";
        String given2 = "20220828:11:30:24 오전"; // --> locale을 따름

        LocalDateTime time = LocalDateTime.parse(given,DateTimeFormatter.ofPattern("yyyyMMdd:HH:mm:ss"));
        LocalDateTime time2 = LocalDateTime.parse(given2,DateTimeFormatter.ofPattern("yyyyMMdd:hh:mm:ss a"));


        System.out.println(time);
        System.out.println(time2);
    }

    @Test
    @DisplayName("해당 날짜의 다음 달 구하기")
    void getNextMonth(){
        LocalDateTime now = LocalDateTime.of(2022,12,31,0,0);

        System.out.println(now);
        System.out.println(now.getDayOfMonth());
        System.out.println(now.toLocalDate());

        LocalDate localDate = now.toLocalDate();
        LocalDate localDate1 = localDate.plusMonths(1L);


        System.out.println(localDate1);
    }

    /**
     * 오라클 plusMonth 기준,
     *
     * 12월 31 + 2 month는 2월 28일 or (2월 29일(윤년))이다.
     */
    @Test
    @DisplayName("ORACLE plusMonth와 같은 일을 하는 로직 구성하기")
    void getNextMonthLogicallyIdenticalWithOracleFunction(){
        LocalDate startDate = LocalDate.of(2022,12,31);

        LocalDate endDate = startDate.plusMonths(2);

        System.out.println(endDate);

    }

    @Test
    @DisplayName("LocalDateTime을 LocalDate로 바꾸기")
    void convert_localDateTime_to_localDate(){

        LocalDateTime localDateTime = LocalDateTime.of(2022,12,31,0,0);

        LocalDate localDate = localDateTime.toLocalDate();

        System.out.println(localDate);
    }

    @Test
    @DisplayName("String to LocalDate")
    void convert_string_to_localDate(){
        String stringDate = "20151215";

        LocalDate localDateDate = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyyMMdd"));

        System.out.println(localDateDate);


    }

    @Test
    @DisplayName("date minus")
    void minus_date(){
        LocalDate startDate = LocalDate.of(2022,12,31);
        LocalDate endDate = LocalDate.of(2023,2,15);

        Period between = Period.between(startDate, endDate);

        System.out.println("days = " + between.getDays());
        System.out.println("months = " +between.getMonths());
        System.out.println("years = " + between.getYears());

        LocalDate resultDate = startDate.plusMonths(between.getMonths()).plusDays(between.getDays());

        System.out.println(resultDate);

    }

    @Test
    @DisplayName("LocalDateTime을 LocalDateTime의 가까운 시간으로 truncate")
    void truncate(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime day = now.truncatedTo(ChronoUnit.DAYS);
        System.out.println(day);
        LocalDateTime hour = now.truncatedTo(ChronoUnit.HOURS);
        System.out.println(hour);
    }

    @Test
    @DisplayName("date -> string")
    void date_to_string(){
        LocalDate now = LocalDate.now();

        String stringNow = now.toString();

        System.out.println(stringNow);
    }

    @Test
    @DisplayName("Period 객체 활용")
    void utilize_period(){

        LocalDate startDate = LocalDate.of(2022,12,31);
        LocalDate endDate = LocalDate.of(2023,2,15);
        Period between = Period.between(startDate, endDate);

        LocalDate result = startDate.plus(between);

        System.out.println(result);
    }

    @Test
    @DisplayName("아무 String이나 Temporal로 매핑")
    void map_to_temporal_anyway(){
        String input = "2020년05월";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월");
        YearMonth yearMonth = YearMonth.parse(input, formatter);

        System.out.println("Year: " + yearMonth.getYear()); // Output: Year: 2020
        System.out.println("Month: " + yearMonth.getMonthValue()); // Output: Month: 5
    }

    @Test
    @DisplayName("YearMonth to flat string")
    void yearMonthToFlatString(){
        YearMonth arg = YearMonth.of(2002, 5);

        String yyyyMM = arg.format(DateTimeFormatter.ofPattern("yyyyMM"));

        System.out.println(yyyyMM);

    }
}
