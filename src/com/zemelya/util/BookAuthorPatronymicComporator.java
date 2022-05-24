package com.zemelya.util;

import com.zemelya.domain.Book;

import java.util.Comparator;

public class BookAuthorPatronymicComporator implements Comparator<Book> {

    public int compare(Book a, Book b) {

        return a.getAuthorPatronymic().compareToIgnoreCase(b.getAuthorPatronymic());

    }
}
