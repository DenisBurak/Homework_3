package com.zemelya.util;

import com.zemelya.domain.Book;
import com.zemelya.domain.FieldsForSorting;
import com.zemelya.domain.Student;
import com.zemelya.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Utils {

    public static <T extends Collection> void printCollection(T collection) {

        Iterator iterator = collection.iterator();
        int orderNumber = 1;
        while (iterator.hasNext()) {
            System.out.println(orderNumber + ":" + iterator.next());
            orderNumber++;
        }
    }

    public static void printBookWithFirstVowel(Set<Book> books) {
        String vowels = "AEIOUaeiou";
        for (Book book : books) {
            if (vowels.indexOf(book.getTitle().charAt(0)) > 0) {
                System.out.println(book);
            }
        }
    }

    public static void sortBooks(Set<Book> books, FieldsForSorting field) {

        Comparator bookComporator = null;

        switch (field) {
            case AUTHOR_SURNAME: {
                bookComporator = new BookAuthorSurnameCorporator();
                break;
            }
            case AUTHOR_NAME: {
                bookComporator = new BookAuthorNameComporator();
                break;
            }
            case AUTHOR_PATRONYMIC: {
                bookComporator = new BookAuthorPatronymicComporator();
                break;
            }
            default:
                System.out.println("Wrong field");
                return;
        }

        List list = new ArrayList(books);
        list.sort(bookComporator);
        Utils.<List>printCollection(list);

    }

    public static void showAndDeleteStudents(Set<Student> students) {

        List<Student> studentsForRemove = new ArrayList<>();
        // буду использовать поле order для определения четности студента при обходе коллекции
        int order = 1;
        for (Student student : students) {
            if (order % 2 == 0) {
                System.out.println(student);
            } else {
                studentsForRemove.add(student);
            }
            order++;
        }

        students.removeAll(studentsForRemove);
    }

    public static void printUsersAndFriends(User user, int maxLevel, int currentLevel) {

        if (currentLevel == maxLevel && maxLevel != 1) {
            return;
        } else {
            if (maxLevel == 1) {
                System.out.print(user.getName() + "->" + user.FriendsToString());
            } else {
                if (currentLevel == 1) {
                    System.out.print(user.getName() + "->" + user.FriendsToString());
                }

                for (int i = 0; i < user.getFriends().size(); i++) {
                    System.out.print("->" + user.getFriends().get(i).getName() + "->" + user.getFriends().get(i).FriendsToString());
                }
                ++currentLevel;

                for (int i = 0; i < user.getFriends().size(); i++) {
                    printUsersAndFriends(user.getFriends().get(i), maxLevel, currentLevel);
                }
            }
        }
    }
}
