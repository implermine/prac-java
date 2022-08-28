package org.example.functionalinterface.imperativeanddeclarative;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.example.functionalinterface.imperativeanddeclarative.ImperativeAndDeclarative.Gender.*;

public class ImperativeAndDeclarative {

    @Test
    @DisplayName("Imperative")
    void imperative(){
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        // Imperative approach
        System.out.println("// Imperative approach");

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

    }

    @Test
    @DisplayName("Declarative")
    void declarative(){
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        // Declarative approach
        System.out.println("// Declarative approach");

        // this was previous introduction to declarative approach...
        //List<Person> females2 = people.stream()
        //        .filter(person -> FEMALE.equals(person.gender))
        //        .collect(Collectors.toList());
        //
        //females2.forEach(System.out::println);

        // but what is think nowadays, are different

        // `미리` 술어(=술부)를 정의해 둘 수 있다.
        Predicate<Person> femalePredicate = (person) -> FEMALE.equals(person.gender);

        List<Person> females = people.stream()
                .filter(femalePredicate)
                .collect(Collectors.toList());

        //forEach로 Sysout을 하는것은 declarative와 아무 관련없다.
        for (Person female : females) {
            System.out.println(female);
        }

    }



    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }
}
