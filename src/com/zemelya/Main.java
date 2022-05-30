package com.zemelya;

import com.zemelya.domain.Book;
import com.zemelya.domain.Student;
import com.zemelya.domain.User;
import com.zemelya.domain.FieldsForSorting;
import com.zemelya.util.Generators;
import com.zemelya.util.Utils;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int countOfBooks = 20;
        int indexToDelete = 6; // 7-й элеммент по заданию

        // генерация книг LinkedList
        List<Book> booksLinkedList = Generators.generateBooks(countOfBooks);

        // вывод на печать
        System.out.println("Исходный список LinkedList");
        Utils.<List<Book>>printCollection(booksLinkedList);

        // удаление по индексу
        booksLinkedList.remove(indexToDelete);

        // вывод на печать
        System.out.println("Список после удаления 7-го элемена");
        Utils.<List<Book>>printCollection(booksLinkedList);

        // генерация книг HashSet
        int countOfBooksForHashSet = 25;
        int countOfTheSameBooks = 6;

        Set<Book> booksHashSet = Generators.generateBooks(countOfBooksForHashSet, countOfTheSameBooks);

        // вывод на печать
        System.out.println("Исходный список книг");
        Utils.<Set<Book>>printCollection(booksHashSet);

        // вывод на печать книг, названия которых начинаются с гласных букв
        System.out.println("Книги с названием начинающимся с гласной буквы");
        Utils.printBookWithFirstVowel(booksHashSet);

        // Сортировка и вывод на печать по фамилии
        System.out.println("Sorted by surname");
        Utils.sortBooks(booksHashSet, FieldsForSorting.AUTHOR_SURNAME);

        // Сортировка и вывод на печать по имени
        System.out.println("Sorted by name");
        Utils.sortBooks(booksHashSet, FieldsForSorting.AUTHOR_NAME);

        // Сортировка и вывод на печать по отчеству
        System.out.println("Sorted by patronymic");
        Utils.sortBooks(booksHashSet, FieldsForSorting.AUTHOR_PATRONYMIC);

        // генерации студентов
        Set<Student> students = Generators.generateStudents(10);

        // вывод на печать
        System.out.println("Список студентов");
        Utils.<Set>printCollection(students);

        //удаление нечетных студентов и вывод четных
        Utils.showAndDeleteStudents(students);

        // генерация пользователей
        List<User> users = Generators.generateUser(10);
        System.out.println("Список пользователей");
        Utils.printCollection(users);
        Utils.printUsersAndFriends(users.get(0), 5, 1);
    }

}
