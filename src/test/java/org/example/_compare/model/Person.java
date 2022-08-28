package org.example._compare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Comparable로 비교를 구현 할 객체
 */
@Getter
@Setter
@AllArgsConstructor
public class Person implements Comparable<Person> {

    private int height;


    @Override
    public int compareTo(Person otherPerson) {
        if(this==otherPerson){
            return 0;
        }

        if(this.height == otherPerson.height){
            return 0;
        }

        if(this.height > otherPerson.height){
            return 1;
        }

        return -1;

        // or

        // return Integer.compare(this.height,otherPerson.height);

    }

    public String toString() {
        return "Person(height=" + this.getHeight() + ")";
    }
}
