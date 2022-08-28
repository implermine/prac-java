package org.example._compare.model;

import java.util.Comparator;

public class BookWidthComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getWidth(),o2.getLength());
    }
}
