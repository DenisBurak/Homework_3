package com.zemelya;

import com.zemelya.domain.Book;
import com.zemelya.util.Generators;
import com.zemelya.util.Utils;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int countOfBooks = 20;
        List<Book> books = Generators.GenerateBooks(countOfBooks);
        Utils.<List<Book>>printCollection(books);


    }

}
