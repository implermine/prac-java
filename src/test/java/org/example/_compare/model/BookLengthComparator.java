package org.example._compare.model;

import java.util.Comparator;

public class BookLengthComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getLength(), o2.getLength());
    }
}