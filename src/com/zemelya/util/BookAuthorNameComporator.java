package com.zemelya.util;

import com.zemelya.domain.Book;

import java.util.Comparator;

public class BookAuthorNameComporator implements Comparator<Book> {

    public int compare(Book a, Book b){

        return a.getAuthorName().compareToIgnoreCase(b.getAuthorName());

    }
}
