package org.example._compare;

import org.example._compare.model.Book;
import org.example._compare.model.BookLengthComparator;
import org.example._compare.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CompareTest {

    /**
     * Comparable 인터페이스의 구현으로 Collection.sort 자동 지원 받기
     */
    @Test
    @DisplayName("Using Comparable")
    void test(){

        List<Person> personList = new ArrayList<>();

        personList.add(new Person(150));
        personList.add(new Person(170));
        personList.add(new Person(160));
        personList.add(new Person(180));
        personList.add(new Person(200));
        personList.add(new Person(190));

        Collections.sort(personList);

        System.out.println(personList);

    }

    /**
     * Comparable 인터페이스의 구현으로 Stream.sorted 자동 지원 받기
     */
    @Test
    void test2(){
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(150));
        personList.add(new Person(170));
        personList.add(new Person(160));
        personList.add(new Person(180));
        personList.add(new Person(200));
        personList.add(new Person(190));

        List<Person> collect = personList.stream().sorted().collect(Collectors.toList());

        System.out.println(personList); // not sorted
        System.out.println(collect); // sorted
    }

    /**
     * Comparator 인터페이스의 구현으로 Stream.sorted 자동 지원 받기
     */
    @Test
    void test3(){
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book(0,5));
        bookList.add(new Book(0,6));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,7));
        bookList.add(new Book(0,1));
        bookList.add(new Book(0,2));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,8));

        List<Book> collect = bookList.stream().sorted(new BookLengthComparator()).collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * ambda 이용해서 Stream.sorted 지원 받기
     */
    @Test
    void test4(){
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book(0,5));
        bookList.add(new Book(0,6));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,7));
        bookList.add(new Book(0,1));
        bookList.add(new Book(0,2));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,8));

        List<Book> collect = bookList.stream().sorted((o1, o2) -> Integer.compare(o1.getLength(), o2.getLength())).collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * Comparator 인터페이스와 JAVA8 Functional Interface implemented with Anonymous class를 이용해서 Stream.sorted 지원 받기
     */
    @Test
    void test5(){
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book(0,5));
        bookList.add(new Book(0,6));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,7));
        bookList.add(new Book(0,1));
        bookList.add(new Book(0,2));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,8));

        BookLengthComparator bookLengthComparator = new BookLengthComparator() {
            @Override
            public int compare(Book o1, Book o2) {
                return super.compare(o1, o2);
            }
        };

        List<Book> collect = bookList.stream().sorted(bookLengthComparator).collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * Comparator 인터페이스와 JAVA8 Functional Interface implemented with Anonymous class를 이용해서 Stream.sorted 지원 받기 2
     */
    @Test
    void test6(){
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book(0,5));
        bookList.add(new Book(0,6));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,7));
        bookList.add(new Book(0,1));
        bookList.add(new Book(0,2));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,3));
        bookList.add(new Book(0,8));

        Comparator<Book> comparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getLength(),o2.getLength());
            }
        };

        List<Book> collect = bookList.stream().sorted(comparator).collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    @DisplayName("Person을 lambda로 비교")
    void test_lambda(){

        List<Person> personList = new ArrayList<>();

        personList.add(new Person(150));
        personList.add(new Person(170));
        personList.add(new Person(160));

        personList.sort(Comparator.comparing(Person::getHeight,Comparator.reverseOrder()));

        System.out.println(personList);

    }

    @Test
    @DisplayName("compare and get max")
    void test_limit(){
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(150));
        personList.add(new Person(170));
        personList.add(new Person(160));

        //personList.clear();
        //personList = null;

        System.out.println(personList);
        Optional<Person> max = personList.stream().max(Comparator.comparing(Person::getHeight));

        max.ifPresent(System.out::println);
    }
}
