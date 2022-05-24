package com.zemelya.util;

import com.zemelya.domain.Book;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;
import java.util.List;

public class Generators {

    public static String generateString(int length) {

        boolean useLetters = true;
        boolean useNumbers = false;

        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static List<Book> GenerateBooks(int count) {

        final int LENGHT_OF_TITLE = 20;
        final int LENGHT_OF_AUTHOR = 10;
        final int MAX_YEAR_PUBLICATION = 2022;

        List<Book> list = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            list.add(
                    new Book(Generators.generateString(LENGHT_OF_TITLE),
                            Generators.generateString(LENGHT_OF_AUTHOR),
                            (int) (Math.random() * MAX_YEAR_PUBLICATION))
            );
        }

        return list;
    }
}
