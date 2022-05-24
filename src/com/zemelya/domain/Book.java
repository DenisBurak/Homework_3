package com.zemelya.domain;

import java.util.Objects;

public class Book {

    private String title;
    private String authorSurname;
    private String authorName;
    private String authorPatronymic;
    private int year;

    private final int DEFAULT_YEAR = 1;

    public Book() {
        this.title = "";
        this.authorSurname = "";
        this.authorName = "";
        this.authorPatronymic = "";
        this.year = DEFAULT_YEAR;
    }

    public Book(String title, String authorSurname, String authorName, String authorPatronymic, int year) {
        this.title = title;
        this.authorSurname = authorSurname;
        this.authorName = authorName;
        this.authorPatronymic = authorPatronymic;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPatronymic() {
        return authorPatronymic;
    }

    public void setAuthorPatronymic(String authorPatronymic) {
        this.authorPatronymic = authorPatronymic;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(authorSurname, book.authorSurname) &&
                Objects.equals(authorName, book.authorName) &&
                Objects.equals(authorPatronymic, book.authorPatronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorSurname, authorName, authorPatronymic, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' + ", authorSurname='" + authorSurname + '\'' +
                ", authorName='" + authorName + '\'' + ", authorPatronymic='" + authorPatronymic + '\'' +
                ", year=" + year + '}';
    }
}
